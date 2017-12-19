package org.hgz.netty.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/12/15 16:45
 */
public class FieldDemo {

  public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
    Class<?> aClass = Class.forName ("org.hgz.netty.reflection.ReflectionObject");

    Field[] fields = aClass.getFields ();
    Field nameField = aClass.getField ("name");
    Class<?> type = nameField.getType ();
    System.out.println (nameField.getName ());


  }
}