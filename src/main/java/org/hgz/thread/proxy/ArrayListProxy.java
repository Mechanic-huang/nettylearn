package org.hgz.thread.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ArrayListProxy {
    public static void main(String[] args) {
        final List<String> list = new ArrayList<String>();

        List<String>  o = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始执行" + method.getName());
                Object invoke = method.invoke(list, args);
                System.out.println("方法执行完成" + method.getName());
                return invoke;


            }
        });

        o.add("hgz");
        o.toString();


    }

}
