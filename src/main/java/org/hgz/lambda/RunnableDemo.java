package org.hgz.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/4/4 11:25
 */
public class RunnableDemo {

  public static void main(String[] args) {
    /**
     * 方法无参数
     * () -> System.out.println("Hello Lambda Expressions");
     */
    new Thread (() -> System.out.println ("hello,world lambda")).start ();

    /**
     *
     * 方法有连个参数
     * (int even, int odd) -> even + odd
     */

    /**
     * 列表迭代
     *
     */
    List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
    features.forEach (n -> System.out.println (n));

    features.forEach (System.out::println);

    /**
     * java.util.function 支持 Java 的函数式编程
     */
    List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");


//    filter (languages, (String name) -> name.startsWith ("J"));

  }

  public static void filter(List names, Predicate condition) {
    names.stream ().filter ((name) -> (condition.test (name))).forEach ((name) -> System.out
        .println (name));
  }

}