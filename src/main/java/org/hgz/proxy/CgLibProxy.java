package org.hgz.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/4/28 16:12
 */
public class CgLibProxy {

  public static void main(String[] args) {
    BookServiceImpl bookService = new BookServiceImpl ();

    BookServiceCglib cglib = new BookServiceCglib ();
    BookServiceImpl bookCglib = (BookServiceImpl) cglib.getInstance (bookService);
    bookCglib.addBook ();
  }

}


class BookServiceCglib implements MethodInterceptor {

  private Object target;//业务类对象，供代理方法中进行真正的业务方法调用

  //相当于JDK动态代理中的绑定
  public Object getInstance(Object target) {
    this.target = target;  //给业务对象赋值
    Enhancer enhancer = new Enhancer (); //创建加强器，用来创建动态代理类
    enhancer.setSuperclass (this.target.getClass ());  //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
    //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
    enhancer.setCallback (this);
    // 创建动态代理类对象并返回
    return enhancer.create ();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    System.out.println ("------before------");
    Object o1 = methodProxy.invokeSuper (o, objects);//调用业务类（父类中）的方法
    System.out.println ("------after-------");
    return o1;
  }
}


class BookServiceImpl {

  public void addBook() {
    System.out.println ("添加成功");
  }
}