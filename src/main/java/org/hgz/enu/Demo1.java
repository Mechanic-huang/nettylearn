package org.hgz.enu;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/4/12 15:09
 */
public class Demo1 {

  public static void main(String[] args) {
    Thread AT = new Thread (
        new Runnable () {
          @Override
          public void run() {
            B optTypeCreate = B.OPT_TYPE_CREATE;
          }
        }

    );
    Thread BT = new Thread (
        new Runnable () {
          @Override
          public void run() {
            C optTypeCreate = C.OPT_TYPE_CREATE;
          }
        }

    );
    Thread CT = new Thread (
        new Runnable () {
          @Override
          public void run() {
            D optTypeCreate = D.OPT_TYPE_CREATE;
          }
        }

    );
    Thread DT = new Thread (
        new Runnable () {
          @Override
          public void run() {
            E optTypeCreate = E.OPT_TYPE_CREATE;
          }
        }

    );
    Thread ET = new Thread (
        new Runnable () {
          @Override
          public void run() {
            A1 optTypeCreate = A1.OPT_TYPE_CREATE;
          }
        }

    );
    Thread FT = new Thread (
        new Runnable () {
          @Override
          public void run() {
            A2 optTypeCreate = A2.OPT_TYPE_CREATE;
          }
        }

    );
    Thread A1T = new Thread (
        new Runnable () {
          @Override
          public void run() {
            A3 optTypeCreate = A3.OPT_TYPE_CREATE;
          }
        }

    );
    Thread A2T = new Thread (
        new Runnable () {
          @Override
          public void run() {
            A4 optTypeCreate = A4.OPT_TYPE_CREATE;
          }
        }

    );



    Thread B1 = new Thread (
        new Runnable () {
          @Override
          public void run() {
            AT.start ();
            BT.start ();
            CT.start ();
            DT.start ();
          }
        }
    );


    ET.start ();
    FT.start ();
    B1.start ();
    A1T.start ();
    A2T.start ();

  }









  public enum A {
    OPT_TYPE_CREATE(1,"创建"),
    OPT_TYPE_DELETE(2,"删除");

    /**
     * 编码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    A(int code,String desc){
      System.out.println (Thread.currentThread ().getId ());
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }
  }

  public enum B {
    OPT_TYPE_CREATE(1,"创建"),
    OPT_TYPE_DELETE(2,"删除");

    /**
     * 编码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    B(int code,String desc){
      System.out.println (Thread.currentThread ().getId ());
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }
  }
  public enum C {
    OPT_TYPE_CREATE(1,"创建"),
    OPT_TYPE_DELETE(2,"删除");

    /**
     * 编码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    C(int code,String desc){
      System.out.println (Thread.currentThread ().getId ());
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }
  }
  public enum D {
    OPT_TYPE_CREATE(1,"创建"),
    OPT_TYPE_DELETE(2,"删除");

    /**
     * 编码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    D(int code,String desc){
      System.out.println (Thread.currentThread ().getId ());
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }
  }
  public enum E {
    OPT_TYPE_CREATE(1,"创建"),
    OPT_TYPE_DELETE(2,"删除");

    /**
     * 编码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    E(int code,String desc){
      System.out.println (Thread.currentThread ().getId ());
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }
  }
  public enum F{
    OPT_TYPE_CREATE(1,"创建"),
    OPT_TYPE_DELETE(2,"删除");

    /**
     * 编码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    F(int code,String desc){
      System.out.println (Thread.currentThread ().getId ());
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }
  }
  public enum A1 {
    OPT_TYPE_CREATE(1,"创建"),
    OPT_TYPE_DELETE(2,"删除");

    /**
     * 编码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    A1(int code,String desc){
      System.out.println (Thread.currentThread ().getId ());
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }
  }
  public enum A2 {
    OPT_TYPE_CREATE(1,"创建"),
    OPT_TYPE_DELETE(2,"删除");

    /**
     * 编码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    A2(int code,String desc){
      System.out.println (Thread.currentThread ().getId ());
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }
  }
  public enum A3 {
    OPT_TYPE_CREATE(1,"创建"),
    OPT_TYPE_DELETE(2,"删除");

    /**
     * 编码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    A3(int code,String desc){
      System.out.println (Thread.currentThread ().getId ());
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }
  }
  public enum A4 {
    OPT_TYPE_CREATE(1,"创建"),
    OPT_TYPE_DELETE(2,"删除");

    /**
     * 编码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    A4(int code,String desc){
      System.out.println (Thread.currentThread ().getId ());
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }
  }
  public enum A5 {
    OPT_TYPE_CREATE(1,"创建"),
    OPT_TYPE_DELETE(2,"删除");

    /**
     * 编码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    A5(int code,String desc){
      System.out.println (Thread.currentThread ().getId ());
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }
  }





}