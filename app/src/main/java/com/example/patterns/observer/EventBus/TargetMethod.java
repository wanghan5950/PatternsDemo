package com.example.patterns.observer.EventBus;

import androidx.annotation.Nullable;
import java.lang.reflect.Method;

/**
 * 订阅某个事件的方法，包含了方法的信息，参数名，执行的线程模式
 */
public class TargetMethod {

    /**
     * 对应的方法
     */
    public Method method;
    /**
     * 事件类型
     */
    public EventType eventType;
    /**
     * 线程模式
     */
    public ThreadMode threadMode;

    public TargetMethod(Method method, EventType eventType, ThreadMode threadMode) {
        this.method = method;
        this.method.setAccessible(true);
        this.eventType = eventType;
        this.threadMode = threadMode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
        result = prime * result + ((method == null) ? 0 : method.getName().hashCode());
        return result;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TargetMethod other = (TargetMethod) obj;
        if (eventType == null) {
            if (other.eventType != null) {
                return false;
            }
        } else if (!eventType.equals(other.eventType)) {
            return false;
        }
        if (method == null) {
            if (other.method != null) {
                return false;
            }
        } else if (!method.getName().equals(other.method.getName())) {
            return false;
        }
        return true;
    }
}
