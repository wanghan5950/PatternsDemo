package com.example.patterns.singleton;

/**
 * 单例模式——Double Check Lock模式
 */
public class DLCInstance {

    private static DLCInstance instance;

    private DLCInstance() {
    }

    /**
     * 只有第一次初始化时才会同步锁，初始化后就不进行同步锁
     * @return
     */
    public static DLCInstance getInstance() {
        if (instance == null) {
            synchronized (DLCInstance.class) {
                if (instance == null) {
                    instance = new DLCInstance();
                }
            }
        }
        return instance;
    }
}
