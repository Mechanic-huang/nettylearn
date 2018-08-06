package org.hgz.httpclient.utils;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.pool.PoolStats;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

/**
 * @author huangguozhong
 * @Description 阻塞IO型HttpClient
 * @Created 2015年7月9日 下午9:03:35
 */
public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    private static final String DEFAULT_CHARSET = "UTF-8";

    private CloseableHttpClient httpClient;
    private PoolingHttpClientConnectionManager poolConnectionManager;
    /**
     * @Fields idleMonitor : 空闲连接监控线程
     */
    private IdleConnectionMonitorThread idleMonitor;

    public PoolingHttpClientConnectionManager getPoolConnectionManager() {
        return poolConnectionManager;
    }

    public void setPoolConnectionManager(
            PoolingHttpClientConnectionManager poolConnectionManager) {
        this.poolConnectionManager = poolConnectionManager;
    }

    private int connectionRequestTimeout;
    private int connectTimeout;
    private int socketTimeout;
    private static int cleanInternal = 1000 * 60 * 5; // 清理间隔时间（毫秒）
    private static int closeIdleTime = 30; // 清理多长时间空闲的连接（秒）

    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    /**
     * @param connectionRequestTimeout 从连接池中取连接的超时时间
     * @Description: 设置连接请求超时时间
     */
    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * @param connectTimeout
     * @Description: 从客户端连接服务器所用的连接超时时间
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    /**
     * @param socketTimeout
     * @Description: 服务端返回的时间超时时间
     */
    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public int getCleanInternal() {
        return cleanInternal;
    }

    public void setCleanInternal(int cleanInternal) {
        HttpClientUtil.cleanInternal = cleanInternal;
    }

    public static int getCloseIdleTime() {
        return closeIdleTime;
    }

    public void setCloseIdleTime(int closeIdleTime) {
        HttpClientUtil.closeIdleTime = closeIdleTime;
    }

    public void printInfo() {
        PoolStats poolStats = poolConnectionManager.getTotalStats();
        System.out.println("total " + poolStats);
        Set<HttpRoute> routes = poolConnectionManager.getRoutes();
        for (HttpRoute r : routes) {
            PoolStats ps = poolConnectionManager.getStats(r);
            System.out.println("route " + r + "   " + ps);
        }
    }

    public void init() {

        TrustManager manager = new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }
        };

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout)
                .build();

        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, new TrustManager[]{manager}, null);
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SSLConnectionSocketFactory sslSocketFactory =
                new SSLConnectionSocketFactory(sslContext,
                        new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"},
                        null,
                        NoopHostnameVerifier.INSTANCE);


        int maxPerRoute = poolConnectionManager.getDefaultMaxPerRoute();
        int maxTotal = poolConnectionManager.getMaxTotal();
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", sslSocketFactory)
                .build();
        poolConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        poolConnectionManager.setMaxTotal(maxTotal);
        poolConnectionManager.setDefaultMaxPerRoute(maxPerRoute);

        httpClient = HttpClients.custom()
                .setConnectionManager(poolConnectionManager)
                .setDefaultRequestConfig(requestConfig)
                .setSSLSocketFactory(sslSocketFactory)
                .build();
        idleMonitor = new IdleConnectionMonitorThread(poolConnectionManager);
        idleMonitor.start();
        logger.info("HttpClientUtil线程池启动成功 [connectionRequestTimeout={},connectTimeout={},socketTimeout={}]",
                connectionRequestTimeout,
                connectTimeout,
                socketTimeout);
    }

    public void shutdown() {
        try {
            logger.info("开始关闭 HttpClient 线程池");
            if (idleMonitor != null) {
                idleMonitor.shutdown();
                idleMonitor.join(); // wait
            }
            if (this.httpClient != null) {
                this.httpClient.close();
                this.poolConnectionManager.shutdown();
            }
        } catch (Exception e) {
            logger.error("关闭CloseableHttpClient线程池失败!", e);
        }
    }

    public String get(String url, Map<String, String> params, Map<String, String> headers) {
        long start = System.currentTimeMillis();
        HttpClientException recordException = null;
        String result = null;
        if (url == null) {
            throw new HttpClientException("url不能为空");
        }
        if (!url.startsWith("http")) {
            url = "http://" + url;
        }
        if (params != null && params.size() > 0) { // 包含参数
            String queryString = "";
            for (Entry<String, String> en : params.entrySet()) {
                queryString += (en.getKey() + "=" + en.getValue() + "&");
            }
            if (url.indexOf('?') > 0) { // url已经有参数
                if (url.charAt(url.length() - 1) == '&') { // 以&结尾
                    url += queryString;
                } else { // 不以&结尾
                    url += "&" + queryString;
                }
            } else {
                url += ("?" + queryString);
            }
        }
        HttpGet request = new HttpGet(url);
        // 请求头拼装
        if (headers != null && !headers.isEmpty()) {
            for (Entry<String, String> header : headers.entrySet()) {
                request.addHeader(header.getKey(), header.getValue());
            }
        }
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            StatusLine statusLine = response.getStatusLine();
            HttpEntity entity = response.getEntity();
            if (statusLine.getStatusCode() >= 300) {
                throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
            }
            if (entity == null) {
                throw new HttpResponseException(statusLine.getStatusCode(), "请求没有响应内容");
            }
            result = EntityUtils.toString(entity, DEFAULT_CHARSET);
            return result;
        } catch (IOException e) {
            request.abort();
            logger.error("http 获取内容失败 url={},method={},params={},ex=\n{}", url, "get", params, ExceptionUtils.getStackTrace(e));
            recordException = trans2UncheckException(e);

//			Cat.logError("httpclient连接池get连接异常",e);
            throw recordException;
        } finally {
            logger.debug("httpclient_get[url={},ret={},cost={}]", url, recordException == null ? result : recordException.toString(), (System.currentTimeMillis() - start));
        }
    }

    public String get(String url) {
        return get(url, null, null);
    }

    private String _post(String url, Map<String, String> params, String content, Map<String, String> headers, String charset) {
        long start = System.currentTimeMillis();
        HttpClientException recordException = null;
        String result = null;
        HttpPost request = new HttpPost(url);
        try {
            // params content 1 in 2 , content override params
            if (params != null && !params.isEmpty()) {
                logger.debug("开始设置请求参数");
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                for (String key : params.keySet()) {
                    nvps.add(new BasicNameValuePair(key, params.get(key)));
                }
                request.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
            }
            if (content != null) {
                StringEntity entity = new StringEntity(content, charset);
                request.setEntity(entity);
            }
        } catch (Exception e) {
            logger.error("http 参数设置异常:{}", e);
        }
        if (headers != null && !headers.isEmpty()) {
            for (Entry<String, String> header : headers.entrySet()) {
                request.addHeader(header.getKey(), header.getValue());
            }
        }
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
            StatusLine statusLine = response.getStatusLine();
            HttpEntity entity = response.getEntity();
            if (statusLine.getStatusCode() >= 300) {
                throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
            }
            if (entity == null) {
                throw new HttpResponseException(statusLine.getStatusCode(), "请求没有响应内容");
            }
            result = EntityUtils.toString(entity, DEFAULT_CHARSET);
            return result;
        } catch (IOException e) {
            // 防止资源泄露，释放连接池连接，并立即断开套接字连接
            request.abort();
            logger.error("http 获取内容失败 url={},method={},params={},cost={},ex=\n{}", url, "post", (System.currentTimeMillis() - start), params, ExceptionUtils.getStackTrace(e));
            // 细化异常判断
            recordException = trans2UncheckException(e);
//            Cat.logError("httpclient连接池post连接异常", e);
            throw recordException;
        } finally {
            logger.debug("httpclient_post[url={},ret={},cost={}]", url, recordException == null ? result : recordException.toString(), (System.currentTimeMillis() - start));
        }
    }

    public String post(String url, Map<String, String> params, Map<String, String> headers) {
        return _post(url, params, null, headers, DEFAULT_CHARSET);
    }


    public String post(String url, String content, Map<String, String> headers, String charset) {
        return _post(url, null, content, headers, charset);
    }

    private HttpClientException trans2UncheckException(IOException e) {
        HttpClientException ex = null;
        if (e instanceof ConnectionPoolTimeoutException) { // 连接池取连接超时
            ex = new HttpClientException(HttpClientException.CONNECTION_POOL_TIMEOUT_EXCEPTION, e.getMessage(), e);
        } else if (e instanceof HttpResponseException) { // 响应失败
            int statusCode = ((HttpResponseException) e).getStatusCode();
            ex = new HttpClientException(HttpClientException.HTTP_RESPONSE_EXCEPTION, e.getMessage() + "-" + statusCode, e);
        } else if (e instanceof ClientProtocolException) { // HttpResponseException 为子类
            ex = new HttpClientException(HttpClientException.CLIENT_PROTOCOL_EXCEPTION, e.getMessage(), e);
        } else if (e instanceof ConnectTimeoutException) { // ConnectionPoolTimeoutException 为该类子类 在后边判断
            ex = new HttpClientException(HttpClientException.CONNECT_TIMEOUT_EXCEPTION, e.getMessage(), e);
        } else if (e instanceof NoHttpResponseException) {
            ex = new HttpClientException(HttpClientException.NO_HTTP_RESPONSE_EXCEPTION, e.getMessage(), e);
        } else {
            ex = new HttpClientException(HttpClientException.ERROR_CODE_HTTP_CLIENT, e.getMessage(), e);
        }

        return ex;
    }

    public String post(String url) {
        return post(url, Collections.<String, String>emptyMap(), null);
    }

    public String post(String url, String content, String charset) {
        return post(url, content, null, charset);
    }

    public String post(String url, String content) {
        return post(url, content, null, DEFAULT_CHARSET);
    }


    public static class IdleConnectionMonitorThread extends Thread {
        private final HttpClientConnectionManager connMgr;
        private volatile boolean shutdown;

        public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
            super();
            this.connMgr = connMgr;
            setName("HttpClientUtil-idleMonitor-t");
        }

        @Override
        public void run() {
            try {
                while (!shutdown) {
                    synchronized (this) {
                        wait(cleanInternal);
                        // Close expired connections
                        connMgr.closeExpiredConnections();
                        // Optionally, close connections
                        // that have been idle longer than 30 sec
                        connMgr.closeIdleConnections(closeIdleTime, TimeUnit.SECONDS);
                        logger.trace("HttpClientUtil 清理空闲连接");
                    }
                }
            } catch (InterruptedException ex) {
                // terminate
                logger.error("空闲连接关闭失败", ex);
            }
        }

        public void shutdown() {
            shutdown = true;
            synchronized (this) {
                notifyAll();
            }
        }
    }


    public String doPost(String url, Map<String, String> map, String charset) {
        return _post(url, map, null, null, charset);
    }

}
