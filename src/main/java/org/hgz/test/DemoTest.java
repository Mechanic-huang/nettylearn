package org.hgz.test;

import java.math.BigDecimal;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/5/9 13:17
 */
public class DemoTest {

  public static void main(String[] args) {

    String param = "19.90";
    String payAmoutCents = new BigDecimal (param).multiply (new BigDecimal (100)).intValue () + "";
    System.out.println (payAmoutCents);


  }
}