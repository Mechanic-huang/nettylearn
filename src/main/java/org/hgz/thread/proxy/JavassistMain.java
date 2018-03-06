package org.hgz.thread.proxy;

import java.util.ArrayList;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/1/10 16:58
 */
public class JavassistMain {


  public static void main(String[] args) throws NotFoundException, CannotCompileException {
    ClassPool pool = ClassPool.getDefault ();

    CtClass ctClass = pool.makeClass ("org.hgz.thread.proxy.StationProxy");

    CtClass interface1 = pool.get ("org.hgz.thread.proxy.TicketService");
    // 设置类实现的接口
    ctClass.setInterfaces (new CtClass[]{interface1});

    // 设置类的field
    CtField field = CtField.make ("private org.hgz.thread.proxy.Station station;", ctClass);

    ctClass.addField (field);

    CtClass stationClass = pool.get("com.foo.proxy.Station");
    CtClass[] arrays = new CtClass[]{stationClass};


    ArrayList a = new ArrayList<String> (3);


  }

}