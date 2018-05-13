package org.hgz.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/4/11 10:51
 */
public class JDKProxy {

  public static void main(String[] args) {
    UserService userService = new UserServiceImpl ();
    MyInvocationHandler myInvocationHandler = new MyInvocationHandler (userService);

    UserService proxyUserService = (UserService) Proxy
        .newProxyInstance (userService.getClass ().getClassLoader (),
            userService.getClass ().getInterfaces (), myInvocationHandler);

    proxyUserService.add ();

  }

}

class MyInvocationHandler implements InvocationHandler {

  private Object target;

  public MyInvocationHandler(Object target) {
    super ();
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println ("----- before-----");
    Object invoke = method.invoke (this.target, args);
    System.out.println ("------after -----");
    System.out.println ("------result  " + invoke + "-------");
    return invoke;
  }
}

interface UserService {

  void add();

  String get();
}

class UserServiceImpl implements UserService {

  @Override
  public void add() {
    System.out.println ("添加用户成功");
  }

  @Override
  public String get() {
    return "黄国仲";
  }


}