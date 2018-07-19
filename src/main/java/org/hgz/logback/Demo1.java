package org.hgz.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Demo1 {


    private static final Logger LOG = LoggerFactory.getLogger("HELLO");


    private static final Logger LOG1 = LoggerFactory.getLogger(Demo1.class);

    public static void main(String[] args) {
        LOG.info("hello");

        LOG1.error("hello1");
//        try {
//            TimeUnit.SECONDS.sleep(15);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        LOG.debug("hello");
    }

}
