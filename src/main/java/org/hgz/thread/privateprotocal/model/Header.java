package org.hgz.thread.privateprotocal.model;

import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/9 16:41
 */
public class Header {

  private int srcCode = 0xabef0101;

  private int length ;

  private long sessionID; // 会话id

  private byte type; // 消息类型  0 业务请求消息， 1 业务相应消息 2 业务即是请求也是相应 3 握手请求 4 握手应答 5 心跳请求消息 6 心跳应答消息

  private byte priority; // 消息优先级

  private Map<String, Object> attachment = new HashMap<String, Object> ();

  public int getSrcCode() {
    return srcCode;
  }

  public void setSrcCode(int srcCode) {
    this.srcCode = srcCode;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public long getSessionID() {
    return sessionID;
  }

  public void setSessionID(long sessionID) {
    this.sessionID = sessionID;
  }

  public byte getType() {
    return type;
  }

  public void setType(byte type) {
    this.type = type;
  }

  public byte getPriority() {
    return priority;
  }

  public void setPriority(byte priority) {
    this.priority = priority;
  }

  public Map<String, Object> getAttachment() {
    return attachment;
  }

  public void setAttachment(Map<String, Object> attachment) {
    this.attachment = attachment;
  }

  @Override
  public String toString() {
    return JSON.toJSONString (this);
  }
}