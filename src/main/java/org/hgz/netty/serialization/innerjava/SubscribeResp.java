package org.hgz.netty.serialization.innerjava;

import com.alibaba.fastjson.JSON;
import java.io.Serializable;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/8 17:35
 */
public class SubscribeResp implements Serializable {

  private static final long serialVersionUID = 8926938752232796485L;

  private int subReqID;

  private int respCode;

  private String desc;

  public int getSubReqID() {
    return subReqID;
  }

  public void setSubReqID(int subReqID) {
    this.subReqID = subReqID;
  }

  public int getRespCode() {
    return respCode;
  }

  public void setRespCode(int respCode) {
    this.respCode = respCode;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  @Override
  public String toString() {
    return JSON.toJSONString (this);
  }
}