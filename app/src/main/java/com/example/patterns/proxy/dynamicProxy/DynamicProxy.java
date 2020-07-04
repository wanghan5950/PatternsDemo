package com.example.patterns.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理——实现InvocationHandler接口
 */
public class DynamicProxy implements InvocationHandler {

    //被代理对象的引用
    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用被代理对象的方法
        return method.invoke(object, args);
    }
}
