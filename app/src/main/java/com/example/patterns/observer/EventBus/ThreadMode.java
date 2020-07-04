package com.example.patterns.observer.EventBus;

/**
 * 事件的线程模式枚举
 */
public enum ThreadMode {
    /**
     * 事件执行在UI线程
     */
    MAIN,
    /**
     * 事件执行在发布事件的线程
     */
    POST,
    /**
     * 事件执行在一个子线程中
     */
    ASYNC
}
