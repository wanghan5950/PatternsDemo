package com.example.patterns.singleton;

/**
 * 单例模式——枚举模式
 */
public enum EnumInstance {

    /**
     * 默认的枚举实例是线程安全的，而且可以保证在任何情况下都是一个单例
     * 其他单例模式可以在反序列化的情况下重建对象，必须加入readResolve()方法才能避免
     */
    INSTANCE;

    private String word = "word";

    public void doSomething() {
        System.out.println("do something");
    }
}
