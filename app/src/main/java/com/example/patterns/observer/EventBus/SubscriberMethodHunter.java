package com.example.patterns.observer.EventBus;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 用于查找所有订阅对象中的订阅方法
 */
public class SubscriberMethodHunter {

    private Map<EventType, CopyOnWriteArrayList<Subscription>> mSubscriberMap;

    public SubscriberMethodHunter(Map<EventType, CopyOnWriteArrayList<Subscription>> mSubscriberMap) {
        this.mSubscriberMap = mSubscriberMap;
    }

    /**
     * 查找订阅对象中所有@Subscriber方法，方法的参数只能有一个，找到方法后创建订阅者对象并存储到Map中
     * @param subscriber 订阅对象
     */
    public void findSubscribeMethods(Object subscriber) {
        if (mSubscriberMap == null) {
            throw new NullPointerException("the mSubscriberMap is null.");
        }
        Class<?> clazz = subscriber.getClass();
        while (clazz != null && !isSystemClass(clazz.getName())) {
            final Method[] allMethods = clazz.getDeclaredMethods();
            for (Method method : allMethods) {
                Subscriber annotation = method.getAnnotation(Subscriber.class);
                if (annotation != null) {
                    Class<?>[] paramsTypeClass = method.getParameterTypes();
                    if (paramsTypeClass.length == 1) {
                        EventType eventType = new EventType(paramsTypeClass[0], annotation.tag());
                        TargetMethod targetMethod = new TargetMethod(method, eventType, annotation.mode());
                        subscribe(eventType, targetMethod, subscriber);
                    }
                }
            }
            //获取父类，继续查找父类中订阅的方法
            clazz = clazz.getSuperclass();
        }
    }

    /**
     * 将找到的订阅方法添加到订阅者Map中
     * @param eventType 事件类型
     * @param targetMethod 订阅方法对象
     * @param subscriber 订阅对象
     */
    private void subscribe(EventType eventType, TargetMethod targetMethod, Object subscriber) {
        CopyOnWriteArrayList<Subscription> subscriptions = mSubscriberMap.get(eventType);
        if (subscriptions == null) {
            subscriptions = new CopyOnWriteArrayList<>();
        }
        Subscription newSubscription = new Subscription(subscriber, targetMethod);
        if (subscriptions.contains(newSubscription)) {
            return;
        }
        subscriptions.add(newSubscription);
        mSubscriberMap.put(eventType, subscriptions);
    }

    /**
     * 从Map中移除订阅者方法
     * @param subscriber
     */
    public void removeMethodsFromMap(Object subscriber) {
        Iterator<CopyOnWriteArrayList<Subscription>> iterator = mSubscriberMap.values().iterator();
        while (iterator.hasNext()) {
            CopyOnWriteArrayList<Subscription> subscriptions = iterator.next();
            if (subscriptions != null) {
                List<Subscription> foundSubscriptions = new LinkedList<>();
                for (Subscription subscription : foundSubscriptions) {
                    Object cacheObject = subscription.subscriber.get();
                    if (isObjectEquals(cacheObject, subscriber) || cacheObject == null) {
                        foundSubscriptions.add(subscription);
                    }
                }
                //移除该subscriber相关的Subscription
                subscriptions.removeAll(foundSubscriptions);
            }
            //如果针对某个事件的订阅者为空，就从Map中清除
            if (subscriptions == null || subscriptions.isEmpty()) {
                iterator.remove();
            }
        }
    }

    private boolean isSystemClass(String name) {
        return name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.");
    }

    private boolean isObjectEquals(Object cacheObject, Object subscriber) {
        return cacheObject != null && cacheObject.equals(subscriber);
    }
}
