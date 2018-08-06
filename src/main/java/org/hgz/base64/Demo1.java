package org.hgz.base64;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;

public class Demo1 {
    public static void main(String[] args) {

        String content = "黄国仲1";



        byte[] encode = Base64.encodeBase64(content.getBytes());

        byte[] bytes = content.getBytes();
        byte[] result = new byte[3];
        System.arraycopy(bytes, 1, result, 0, 3);


        System.out.println(new String(result));

        System.out.println();

        try {
            System.out.println("------");
            System.out.println(content.getBytes("UTF-8").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(Hex.encodeHexString(encode));





    }


}



