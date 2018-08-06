package org.hgz;

import org.apache.commons.codec.binary.Hex;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author guozhong h
 * @date 2018/8/3 下午2:55
 */
public class MainTest {
    public static void main(String[] args) throws IOException {


        int a = -1;


        byte[] buf = new byte[1024];
        byte[] bytes = int2bytes(-1);


        System.arraycopy(bytes, 0, buf, 0, 4);


        int b = 0B00000000000000000000000001000000;

        System.out.println(b);
        byte[] bytes1 = int2bytes(b);


        String s = Hex.encodeHexString(bytes1);

        System.out.println(s);


    }


    public static byte[] int2bytes(int num) {
        byte[] result = new byte[4];
        result[0] = (byte) ((num >>> 24) & 0xff);//说明一
        result[1] = (byte) ((num >>> 16) & 0xff);
        result[2] = (byte) ((num >>> 8) & 0xff);
        result[3] = (byte) ((num >>> 0) & 0xff);
        return result;
    }


}
