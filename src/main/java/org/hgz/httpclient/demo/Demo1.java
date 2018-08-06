package org.hgz.httpclient.demo;

import com.mchange.v2.c3p0.impl.C3P0PooledConnectionPoolManager;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;


import java.io.IOException;

public class Demo1 {

    PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://www.mytogo.com/");
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            StatusLine statusLine = response.getStatusLine();
            HttpEntity entity = response.getEntity();
            Header[] allHeaders = response.getAllHeaders();

            for (Header header : allHeaders) {
                System.out.println(header.getName() + " : " + header.getValue() + " : " + header.getElements()[0].getName() + " : " + header.getElements()[0].getValue());
            }

//
//            String s = EntityUtils.toString(entity, "UTF-8");
//            System.out.println(s);

        } finally {
            response.close();
        }
    }
}
