package org.hgz.thread.demo;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/10/16 16:42
 */
public class UnsafeDemo {
  static final sun.misc.Unsafe UNSAFE;
  static {
    UNSAFE = sun.misc.Unsafe.getUnsafe();
  }


  public static void main(String[] args) throws NoSuchFieldException {
    User user = new User ("黄国仲", 11, "男");
    Field sexField = User.class.getField ("sex");

    long sexOffset = UNSAFE.objectFieldOffset (sexField);

    if (UNSAFE.compareAndSwapObject (user,sexOffset,"男", "女")) {
      System.out.println ("更新成功");
      System.out.println (user.getSex ());
    } else {
      System.out.println ("更新失败");
    }

  }

  static class User implements Serializable{

    private static final long serialVersionUID = 6427527768447934934L;

    private String name;
    private int age;
    private String sex;

    public User() {
    }

    public User(String name, int age, String sex) {
      this.name = name;
      this.age = age;
      this.sex = sex;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public String getSex() {
      return sex;
    }

    public void setSex(String sex) {
      this.sex = sex;
    }
  }

}