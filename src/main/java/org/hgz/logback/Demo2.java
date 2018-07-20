package org.hgz.logback;

public class Demo2 {

    public static void main(String[] args) {
        System.out.println("a");
        try {
            testRuntimeException();
        } catch (RuntimeException e) {
            System.out.println("ahah");
        }
    }



    public static void testRuntimeException(){
        throw new RuntimeException("aaaaa");
    }
}
