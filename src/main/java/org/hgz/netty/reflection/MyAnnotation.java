package org.hgz.netty.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/12/15 18:00
 */

@Retention(RetentionPolicy.RUNTIME)     // 如果没有这个表示，注解不会保存到运行期
@Target(ElementType.TYPE)       // 这个注解用作的位置， 当前该注解只能用在类上
public @interface MyAnnotation {
  public String name();
  public String value();

}