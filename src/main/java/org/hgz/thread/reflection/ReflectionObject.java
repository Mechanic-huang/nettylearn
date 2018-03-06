package org.hgz.thread.reflection;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/12/15 16:35
 */

@MyAnnotation (name="soname", value= "Hello, world")
public class ReflectionObject {
  public String name;

  public ReflectionObject(String name) {
    this.name = name;
  }


  public void getName() {
  }

  public static void sayHello(String name) {
    System.out.println ("hello, " + name);
  }

}