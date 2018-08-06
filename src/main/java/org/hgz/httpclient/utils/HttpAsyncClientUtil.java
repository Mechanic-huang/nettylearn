//package org.hgz.httpclient;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.concurrent.FutureCallback;
//import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
//import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
//import org.apache.http.impl.nio.client.HttpAsyncClients;
//import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.nio.conn.NHttpClientConnectionManager;
//import org.apache.http.nio.reactor.ConnectingIOReactor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.TimeUnit;
//
///**
// * HttpAsyncClientUtil工具类
// *
// * @author wangyajun add 2014-10-13 http异步请求
// */
//public class HttpAsyncClientUtil {
//	private static final Logger LOG = LoggerFactory.getLogger(HttpAsyncClientUtil.class);
//	private int timeOut;
//	private CloseableHttpAsyncClient httpAsyncClient;
//	private ConnectingIOReactor ioReactor;
//	private PoolingNHttpClientConnectionManager poolConnectionManger;
//	private int maxTotal;
//	private int maxPerRoute;
//	private IdleConnectionEvictor connEvictor;
//
//	/*
//	 * 初始化线程池
//	 */
//	protected void init() {
//		try {
//			LOG.info("开始初始化HttpAsyncClient 线程池");
//			poolConnectionManger.setMaxTotal(this.maxTotal);
//			poolConnectionManger.setDefaultMaxPerRoute(this.maxPerRoute);
//			HttpAsyncClientBuilder builder = HttpAsyncClients.custom()
//					.setConnectionManager(poolConnectionManger);
//			httpAsyncClient = builder.build();
//			httpAsyncClient.start();
//			// 启动回收线程
//			connEvictor = new IdleConnectionEvictor(poolConnectionManger);
//			connEvictor.start();
//		} catch (Exception e) {
//			LOG.error("初始化 CloseableHttpAsyncClient 接口失败!",e);
//		}
//	}
//
//	public int getMaxTotal() {
//		return maxTotal;
//	}
//
//	public void setMaxTotal(int maxTotal) {
//		this.maxTotal = maxTotal;
//	}
//
//	public int getMaxPerRoute() {
//		return maxPerRoute;
//	}
//
//	public void setMaxPerRoute(int maxPerRoute) {
//		this.maxPerRoute = maxPerRoute;
//	}
//
//	public void setPoolConnectionManger(
//			PoolingNHttpClientConnectionManager poolConnectionManger) {
//		this.poolConnectionManger = poolConnectionManger;
//	}
//
//	/*
//	 * 停止线程池
//	 */
//	protected void shutDown() {
//		try {
//			LOG.info("开始关闭 HttpAsyncClient 线程池");
//			if (connEvictor != null) {
//				connEvictor.shutdown();
//				connEvictor.join();
//			}
//			if (this.httpAsyncClient != null) {
//				this.httpAsyncClient.close();
//				this.poolConnectionManger.shutdown();
//				this.ioReactor.shutdown();
//			}
//		} catch (Exception e) {
//			LOG.error("关闭CloseableHttpAsyncClient异步线程池失败!",e);
//		}
//	}
//
//	public static HttpAsyncClientUtil getHttpAsyncClientUtil() {
//		return (HttpAsyncClientUtil) SpringContextUtil
//				.getBean("asynClientUtil");
//	}
//
//	/*
//	 * 以post方式提交请求
//	 */
//	public void post(String url, Map<String, String> params, String charset,
//			final AsynHttpFuture futureCallBack) {
//		final HttpPost request = new HttpPost(url);
//		RequestConfig defaultRequestConfig = RequestConfig.custom()
//				.setSocketTimeout(timeOut).setConnectTimeout(timeOut)
//				.setConnectionRequestTimeout(timeOut).build();
//		request.setConfig(defaultRequestConfig);
//		// 设置字符编码
//		request.addHeader("charset", charset);
//		try {
//			if (params != null && !params.isEmpty()) {
//				LOG.debug("开始设置请求参数");
//				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//				for (String key : params.keySet()) {
//					nvps.add(new BasicNameValuePair(key, params.get(key)));
//				}
//				request.setEntity(new UrlEncodedFormEntity(nvps, charset));
//			}
//		} catch (Exception e) {
//			LOG.error("http 参数设置异常:{}", e);
//		}
//		futureCallBack.begin(params);
//		try {
//			final CountDownLatch latch = new CountDownLatch(1);
//			httpAsyncClient.execute(request,
//					new FutureCallback<HttpResponse>() {
//						@Override
//						public void completed(HttpResponse response) {
//							latch.countDown();
//							if (futureCallBack != null) {
//								futureCallBack.completed(request, response);
//							}
//						}
//						@Override
//						public void failed(Exception ex) {
//							latch.countDown();
//							if (futureCallBack != null) {
//								futureCallBack.failed(request, ex);
//							}
//							LOG.error("httpAsyncClient 调用失败", ex);
//						}
//						@Override
//						public void cancelled() {
//							latch.countDown();
//							if (futureCallBack != null) {
//								futureCallBack.cancelled(request);
//							}
//						}
//					});
//			latch.await();
//		} catch (Exception e) {
//			LOG.error("http 异步调用执行异常:{}", e);
//		}
//
//	}
//
//	/**
//	* @Description: 以get方式提交请求
//	* @param url
//	* @param params
//	* @param charset
//	* @param futureCallBack
//	*/
//	public void get(String url, Map<String, String> params, String charset,
//			final AsynHttpFuture futureCallBack) {
//		try {
//			if (params != null && !params.isEmpty()) {
//				LOG.debug("开始设置请求参数");
//				StringBuilder str = new StringBuilder("?");
//				for (String key : params.keySet()) {
//					str.append(key).append("=").append(params.get(key))
//							.append("&");
//				}
//				String queryString = str.deleteCharAt(str.length() - 1).toString();
//				url += queryString ;
//			}
//		} catch (Exception e) {
//			LOG.error("http 参数设置异常:", e);
//		}
//		final HttpGet request = new HttpGet(url);
//		RequestConfig defaultRequestConfig = RequestConfig.custom()
//				.setSocketTimeout(timeOut).setConnectTimeout(timeOut)
//				.setConnectionRequestTimeout(timeOut).build();
//		request.setConfig(defaultRequestConfig);
//		// 设置字符编码
//		request.addHeader("charset", charset);
//		futureCallBack.begin(params);
//		try {
//			final CountDownLatch latch = new CountDownLatch(1);
//			httpAsyncClient.execute(request,
//					new FutureCallback<HttpResponse>() {
//						@Override
//						public void completed(HttpResponse response) {
//							latch.countDown();
//							if (futureCallBack != null) {
//								futureCallBack.completed(request, response);
//							}
//						}
//						@Override
//						public void failed(Exception ex) {
//							latch.countDown();
//							if (futureCallBack != null) {
//								futureCallBack.failed(request, ex);
//							}
//							LOG.error("get请求http异步调用异常：",ex);
//						}
//						@Override
//						public void cancelled() {
//							latch.countDown();
//							if (futureCallBack != null) {
//								futureCallBack.cancelled(request);
//							}
//							LOG.warn("异步调用退出");
//						}
//					});
//			latch.await();
//		} catch (Exception e) {
//			LOG.error("http 异步调用执行异常:{}", e);
//		}
//	}
//
//	public int getTimeOut() {
//		return timeOut;
//	}
//
//	public void setTimeOut(int timeOut) {
//		this.timeOut = timeOut;
//	}
//
//	public ConnectingIOReactor getIoReactor() {
//		return ioReactor;
//	}
//
//	public void setIoReactor(ConnectingIOReactor ioReactor) {
//		this.ioReactor = ioReactor;
//	}
//
//	public void post(String url, Map<String, String> params,
//			final AsynHttpFuture futureCallBack) {
//		String charset = "UTF-8";
//		this.post(url, params, charset, futureCallBack);
//	}
//
//	public void get(String url, Map<String, String> params,
//			final AsynHttpFuture futureCallBack) {
//		String charset = "UTF-8";
//		this.get(url, params, charset, futureCallBack);
//	}
//
//	public static class IdleConnectionEvictor extends Thread {
//
//		private final NHttpClientConnectionManager connMgr;
//
//		private volatile boolean shutdown;
//
//		public IdleConnectionEvictor(NHttpClientConnectionManager connMgr) {
//			super();
//			this.connMgr = connMgr;
//			this.setName("httpAsync-IdleConnectionEvictor-thread");
//		}
//		@Override
//		public void run() {
//			try {
//				while (!shutdown) {
//					synchronized (this) {
//						wait(600000);// 10分钟回收异常
//						LOG.trace("回收异步空闲线程");
//						// Close expired connections
//						connMgr.closeExpiredConnections();
//						// Optionally, close connections
//						// that have been idle longer than 5 sec
//						connMgr.closeIdleConnections(5, TimeUnit.SECONDS);
//					}
//				}
//			} catch (InterruptedException ex) {
//				// terminate
//			}
//		}
//
//		public void shutdown() {
//			shutdown = true;
//			synchronized (this) {
//				notifyAll();
//			}
//		}
//
//	}
//
//}
