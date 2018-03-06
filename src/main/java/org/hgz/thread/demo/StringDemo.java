package org.hgz.thread.demo;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/15 16:06
 */
public class StringDemo {

  public static void main(String[] args) {
    String b = new String ("abc");

    String a = "abc";
    String c = "abc";

    System.out.println (a == b);
    System.out.println (a == c);


    String a1 = "ab" + "c";
    String b1 = "abc";

    System.out.println (a1 == b1);


    String str2 = "ab";
    String str3 = "cd";
    String str4 = str2 + str3;
    String str5 = "abcd";
    System.out.println (str5 == str4);

    String objStr1 = new String ("ab");
    String str11 = "cd";

    String substring = str11.substring (1);

    String str111 = objStr1 + str11;
    String ddd = "abcd";

    System.out.println (str111 == ddd);





  }

}