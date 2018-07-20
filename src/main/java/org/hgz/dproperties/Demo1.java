package org.hgz.dproperties;

public class Demo1 {

    /**
     * 使用 -D参数名  进行参数设置 System.getPropites来获取
     * @param args
     */
    public static void main(String[] args) {
        String hgz = System.getProperty("hgz");
        System.out.println(hgz);

        System.out.println(args[0]);

    }
}
