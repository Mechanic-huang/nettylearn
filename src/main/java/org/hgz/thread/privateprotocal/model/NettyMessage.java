package org.hgz.thread.privateprotocal.model;

import com.alibaba.fastjson.JSON;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/9 16:40
 */
public final class NettyMessage {

  private Header header;

  private Object body;

  public Header getHeader() {
    return header;
  }

  public void setHeader(Header header) {
    this.header = header;
  }

  public Object getBody() {
    return body;
  }

  public void setBody(Object body) {
    this.body = body;
  }

  @Override
  public String toString() {
    return JSON.toJSONString (this);
  }
}