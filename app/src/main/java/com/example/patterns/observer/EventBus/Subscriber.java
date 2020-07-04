package com.example.patterns.observer.EventBus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于注解事件接收的方法
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscriber {

    /**
     * 事件标识符tag，类似于BroadcastReceiver中的Action
     * @return
     */
    String tag() default EventType.DEFAULT_TAG;

    /**
     * 事件执行的线程，默认为UI线程
     * @return
     */
    ThreadMode mode() default ThreadMode.MAIN;
}
