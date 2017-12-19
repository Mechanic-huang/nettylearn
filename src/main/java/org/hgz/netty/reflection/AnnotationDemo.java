package org.hgz.netty.reflection;

import java.lang.annotation.Annotation;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/12/15 18:11
 */
public class AnnotationDemo {

  public static void main(String[] args) {
    Class<ReflectionObject> reflectionObjectClass = ReflectionObject.class;
    Annotation[] annotations = reflectionObjectClass.getAnnotations ();

    for(Annotation annotation : annotations){
      if(annotation instanceof MyAnnotation){
        MyAnnotation myAnnotation = (MyAnnotation) annotation;
        System.out.println("name: " + myAnnotation.name());
        System.out.println("value: " + myAnnotation.value());
      }
    }
  }
}