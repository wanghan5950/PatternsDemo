package com.example.patterns.proxy;

import com.example.patterns.proxy.dynamicProxy.DynamicProxy;
import com.example.patterns.proxy.staticProxy.ILawsuit;
import com.example.patterns.proxy.staticProxy.Lawyer;
import com.example.patterns.proxy.staticProxy.Litigant;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        //静态代理
        ILawsuit litigant = new Litigant();
        ILawsuit lawyer = new Lawyer(litigant);
        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();

        //动态代理
        //动态代理通过一个代理类来代理N多个被代理类，使代理类和被代理类没有直接的耦合关系
        ILawsuit litigant1 = new Litigant();
        DynamicProxy dynamicProxy = new DynamicProxy(litigant1);
        ClassLoader loader = litigant1.getClass().getClassLoader();
        ILawsuit lawyer1 = (ILawsuit) Proxy.newProxyInstance(loader, new Class[]{ILawsuit.class}, dynamicProxy);
        lawyer1.submit();
        lawyer1.burden();
        lawyer1.defend();
        lawyer1.finish();
    }
}
