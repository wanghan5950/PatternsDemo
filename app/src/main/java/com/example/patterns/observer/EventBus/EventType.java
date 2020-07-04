package com.example.patterns.observer.EventBus;

import androidx.annotation.Nullable;

/**
 * 用于描述一个方法的唯一性
 * 参数类型，tag两个条件确保了EventType对象的唯一性，通过EventType对象来查找注册了相应类型和tag的所有观察者，
 * 并且在接收到消息时调用所有观察者对应的方法
 */
public final class EventType {

    /**
     * 默认tag
     */
    public static final String DEFAULT_TAG = "default_tag";

    /**
     * 参数类型
     */
    Class<?> paramClass;
    /**
     * 方法的tag
     */
    public String tag = DEFAULT_TAG;

    public Object event;

    public EventType(Class<?> paramClass) {
        this(paramClass, DEFAULT_TAG);
    }

    public EventType(Class<?> paramClass, String tag) {
        this.paramClass = paramClass;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "EventType{" +
                "paramClass=" + paramClass +
                ", tag='" + tag + '\'' +
                ", event=" + event +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((paramClass == null) ? 0 : paramClass.hashCode());
        result = prime * result + ((tag == null) ? 0 : tag.hashCode());
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
        EventType other = (EventType) obj;
        if (paramClass == null) {
            if (other.paramClass != null) {
                return false;
            }
        } else if (tag == null) {
            if (other.tag != null) {
                return false;
            }
        } else if (!tag.equals(other.tag)) {
            return false;
        }
        return true;
    }
}
