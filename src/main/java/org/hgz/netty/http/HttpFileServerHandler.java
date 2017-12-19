//package org.hgz.netty.http;
//
//import io.netty.buffer.Unpooled;
//import io.netty.channel.ChannelFutureListener;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.SimpleChannelInboundHandler;
//import io.netty.handler.codec.http.DefaultFullHttpResponse;
//import io.netty.handler.codec.http.FullHttpRequest;
//import io.netty.handler.codec.http.FullHttpResponse;
//import io.netty.handler.codec.http.HttpMethod;
//import io.netty.handler.codec.http.HttpResponse;
//import io.netty.handler.codec.http.HttpResponseStatus;
//import io.netty.handler.codec.http.HttpVersion;
//import io.netty.util.CharsetUtil;
//import java.io.File;
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.util.regex.Pattern;
//import javax.activation.MimetypesFileTypeMap;
//import org.omg.CORBA.UNSUPPORTED_POLICY;
//
///**
// * @author huang_guozhong
// * @Description
// * @Copyright 2015 © anzhi.com
// * @Created 2017/9/9 11:28
// */
//public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
//
//
//  private String url;
//
//  public HttpFileServerHandler(String url) {
//    this.url = url;
//  }
//
//  protected void messageReceived(ChannelHandlerContext ctx,
//      FullHttpRequest request) throws Exception {
//    if (!request.decoderResult ().isSuccess ()) {
//      sendError (ctx, HttpResponseStatus.BAD_REQUEST);
//      return;
//    }
//    if (request.method () != HttpMethod.GET) {
//      sendError (ctx, HttpResponseStatus.METHOD_NOT_ALLOWED);
//      return;
//    }
//
//    final String uri = request.uri ();
//    final String path = sanitizeUri (uri);
//
//  }
//
//
//  private static final Pattern INSECURE_URI = Pattern.compile (".*[<>&\"].*");
//
//  private static String sanitizeUri(String uri) {
//    try {
//      uri = URLDecoder.decode (uri, "UTF-8");
//    } catch (Exception e) {
//      try {
//        uri = URLDecoder.decode (uri, "ISO-8859-1");
//      } catch (UnsupportedEncodingException e1) {
//        throw new Error ();
//      }
//    }
//    if (!uri.startsWith ("/")) {
//      return null;
//    }
//
//    uri = uri.replace ('/', File.separatorChar);
//
//    if (uri.contains (File.separator + ".") || uri.contains ('.' + File.separator) || uri
//        .startsWith (".") || uri.endsWith (".") || INSECURE_URI.matcher (uri).matches ()) {
//      return null;
//    }
//
//    return System.getProperty ("user.dir" + File)
//
//  }
//
//
//  private static void sendRedirect(ChannelHandlerContext ctx, String newUri) {
//    FullHttpResponse response = new DefaultFullHttpResponse (HttpVersion.HTTP_1_1,
//        HttpResponseStatus.FOUND);
//    response.headers ().set ("LOCATION", newUri);
//    ctx.writeAndFlush (response).addListener (ChannelFutureListener.CLOSE);
//  }
//
//
//  /**
//   * 发送失败信息
//   */
//  private static void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
//    FullHttpResponse response = new DefaultFullHttpResponse (HttpVersion.HTTP_1_1, status,
//        Unpooled.copiedBuffer ("Faiure: " + status.toString () + "\r\n", CharsetUtil.UTF_8);
//    response.headers ().set ("CONTEN_TYPE", "text/plain; charset=UTF-8");
//    ctx.writeAndFlush (response).addListener (ChannelFutureListener.CLOSE);
//  }
//
//
//  private static void setContentTypeHeader(HttpResponse response, File file) {
//    MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap ();
//    response.headers ().set ("CONTENT_TYPE", mimetypesFileTypeMap.getContentType (file.getPath ()));
//  }
//}