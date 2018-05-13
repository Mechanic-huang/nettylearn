package org.hgz.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import jdk.nashorn.internal.objects.annotations.Function;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/4/4 13:38
 */
public class Demo2 {

  public static void main(String[] args) {
    List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);

    for (Integer cost : costBeforeTax) {
      double price = cost + .12*cost;
      System.out.println(price);
    }
    costBeforeTax.stream ().map ((cost) -> cost + .12 * cost).forEach (System.out::print);
    Double aDouble = costBeforeTax.stream ().map ((cost) -> cost + .12 * cost)
        .reduce ((sum, cost) -> sum + cost).get ();
    System.out.println (aDouble);


    List<String> costBeforeTax1 = Arrays.asList("abc","bcd","defg","jk");
    List<String> filtered = costBeforeTax1.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
    System.out.printf("Original List : %s, filtered list : %s %n", costBeforeTax1, filtered);


    List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");

    String a = G7.stream ().map ((x) -> x.toUpperCase ()).collect(Collectors.joining (", "));
    System.out.println (a);

    // 复制不同的值，创建一个子列表

    List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
    List<Integer> distinct = numbers.stream ().map (i -> i*i).distinct ().collect(Collectors.toList());
    System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);

    // 计算集合的最大值 最小值 总和以及平均值
    List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

    IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
    System.out.println("Highest prime number in List : " + stats.getMax());
    System.out.println("Lowest prime number in List : " + stats.getMin());
    System.out.println("Sum of all prime numbers : " + stats.getSum());
    System.out.println("Average of all prime numbers : " + stats.getAverage());




  }

}