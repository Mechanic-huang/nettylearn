package org.hgz.netty.serialization.innerjava;

import com.alibaba.fastjson.JSON;
import java.io.Serializable;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/8 17:31
 */
public class SubscribeReq implements Serializable {

  private static final long serialVersionUID = -1449875431059801729L;

  private int subReqID;

  private String userName;

  private String productName;

  private String phoneNumber;

  private String address;

  public int getSubReqID() {
    return subReqID;
  }

  public void setSubReqID(int subReqID) {
    this.subReqID = subReqID;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return JSON.toJSONString (this);
  }
}