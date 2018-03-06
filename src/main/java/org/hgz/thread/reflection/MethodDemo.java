package org.hgz.thread.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/12/15 16:52
 */
public class MethodDemo {

  public static void main(String[] args)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Class<ReflectionObject> reflectionObjectClass = ReflectionObject.class;

    Method[] methods = reflectionObjectClass.getMethods ();

    Method getName = reflectionObjectClass.getMethod ("getName", null);
    Class<?>[] parameterTypes = getName.getParameterTypes ();

    System.out.println (parameterTypes.length);

    Class<?> returnType = getName.getReturnType ();
    System.out.println (returnType);

    Method sayHello = reflectionObjectClass.getMethod ("sayHello", String.class);

    sayHello.invoke (null, "hello");

  }
}