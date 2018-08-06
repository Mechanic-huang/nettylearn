package org.hgz.httpclient.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

import java.util.Map;

/**
 * HttpAsyncClientUtil工具类
 * 
 * @author wangyajun add 2014-10-13 http异步请求结果处理接口
 */
public interface AsynHttpFuture {

	public void begin(Map<String, String> params);

	public void completed(HttpUriRequest request, HttpResponse response);

	public void failed(HttpUriRequest request, Exception ex);

	public void cancelled(HttpUriRequest request);
}
