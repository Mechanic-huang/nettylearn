package org.hgz.netty.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/12/15 16:33
 */
public class ConstructorDemo {

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Class<?> aClass = Class.forName ("org.hgz.netty.reflection.ReflectionObject");

    Constructor<?> constructor = aClass.getConstructor (new Class[]{String.class});

    Class<?>[] parameterTypes = constructor.getParameterTypes ();

    ReflectionObject o = (ReflectionObject) constructor.newInstance ("constructor-arg1");



  }



}