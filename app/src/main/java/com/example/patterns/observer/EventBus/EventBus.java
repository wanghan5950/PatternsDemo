package com.example.patterns.observer.EventBus;

import com.example.patterns.observer.EventBus.handler.AsyncEventHandler;
import com.example.patterns.observer.EventBus.handler.EventHandler;
import com.example.patterns.observer.EventBus.handler.MainEventHandler;
import com.example.patterns.observer.EventBus.handler.PostEventHandler;
import com.example.patterns.observer.EventBus.matchStrategy.DefaultMatchStrategy;
import com.example.patterns.observer.EventBus.matchStrategy.MatchStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public final class EventBus {

    /**
     * 默认描述符
     */
    private static final String DESCRIPTOR = EventBus.class.getSimpleName();
    /**
     * 事件总线描述符
     */
    private String mDescriptor = DESCRIPTOR;
    /**
     * 订阅对象Map
     */
    private final Map<EventType, CopyOnWriteArrayList<Subscription>> mSubscriberMap;
    /**
     * sticky事件类型列表
     */
    private List<EventType> mStickyEvents = Collections.synchronizedList(new LinkedList<>());
    /**
     * 事件分发器
     */
    private EventDispatcher mDispatcher;

    private SubscriberMethodHunter mSubscriberMethodHunter;

    private ThreadLocal<Queue<EventType>> mLocalEvents;

    /**
     * 构建默认描述的事件总线
     */
    private EventBus() {
        this(DESCRIPTOR);
    }

    /**
     * 构建自定义描述的事件总线
     * @param desc
     */
    public EventBus(String desc) {
        this.mDescriptor = desc;
        this.mSubscriberMap = new ConcurrentHashMap<>();
        this.mDispatcher = new EventDispatcher();
        this.mSubscriberMethodHunter = new SubscriberMethodHunter(mSubscriberMap);
        this.mLocalEvents = new ThreadLocal<Queue<EventType>>() {
            @Override
            protected Queue<EventType> initialValue() {
                return new ConcurrentLinkedQueue<>();
            }
        };
    }

    public static EventBus getDefault() {
        return EventBusHolder.mDefaultEventBus;
    }

    private static class EventBusHolder {
        //默认描述事件总线
        private static EventBus mDefaultEventBus = new EventBus();
    }

    /**
     * 注册订阅对象
     * @param subscriber 订阅者
     */
    public void register(Object subscriber) {
        if (subscriber == null) {
            return;
        }
        synchronized (this) {
            mSubscriberMethodHunter.findSubscribeMethods(subscriber);
        }
    }

    /**
     * 以sticky的形式注册，会在注册成功后迭代所有sticky事件
     * @param subscriber
     */
    public void registerSticky(Object subscriber) {
        this.register(subscriber);
        //处理sticky事件
        mDispatcher.dispatchStickyEvents(subscriber);
    }

    /**
     * 取消注册
     * @param subscriber
     */
    public void unRegister(Object subscriber) {
        if (subscriber == null) {
            return;
        }
        synchronized (this) {
            mSubscriberMethodHunter.removeMethodsFromMap(subscriber);
        }
    }

    /**
     * 发布默认tag事件
     * @param event
     */
    public void post(Object event) {
        post(event, EventType.DEFAULT_TAG);
    }

    /**
     * 发布事件
     * @param event
     * @param tag
     */
    public void post(Object event, String tag) {
        if (event == null) {
            return;
        }
        mLocalEvents.get().offer(new EventType(event.getClass(), tag));
        mDispatcher.dispatchEvent(event);
    }

    /**
     * 发布默认tag的Sticky事件
     * @param event
     */
    public void postSticky(Object event) {
        postSticky(event, EventType.DEFAULT_TAG);
    }

    /**
     * 发布Sticky事件
     * @param event
     * @param tag
     */
    public void postSticky(Object event, String tag) {
        if (event == null) {
            return;
        }
        EventType eventType = new EventType(event.getClass(), tag);
        eventType.event = event;
        mStickyEvents.add(eventType);
    }

    /**
     * 移除Sticky事件
     * @param eventClass
     * @param tag
     */
    public void removeStickyEvent(Class<?> eventClass, String tag) {
        Iterator<EventType> iterator = mStickyEvents.iterator();
        while (iterator.hasNext()) {
            EventType eventType = iterator.next();
            if (eventType.paramClass.equals(eventClass) && eventType.tag.equals(tag)) {
                iterator.remove();
            }
        }
    }

    /**
     * 获取Sticky事件列表
     * @return
     */
    public List<EventType> getStickyEvents() {
        return mStickyEvents;
    }

    /**
     * 设置订阅方法的匹配策略
     * @param strategy 匹配策略
     */
    public void setMatchStrategy(MatchStrategy strategy) {
        mDispatcher.mMatchStrategy = strategy;
    }

    /**
     * 设置执行在主线程的事件处理器
     * @param handler
     */
    public void setMainThreadEventHandler(EventHandler handler) {
        mDispatcher.mMainEventHandler = handler;
    }

    /**
     * 设置执行在事件发布线程的事件处理器
     * @param handler
     */
    public void setPostThreadEventHandler(EventHandler handler) {
        mDispatcher.mPostEventHandler = handler;
    }

    /**
     * 设置执行在子线程的事件处理器
     * @param handler
     */
    public void setAsyncEventHandler(EventHandler handler) {
        mDispatcher.mAsyncEventHandler = handler;
    }

    /**
     * 获取订阅对象Map
     * @return
     */
    public Map<EventType, CopyOnWriteArrayList<Subscription>> getSubscriberMap() {
        return mSubscriberMap;
    }

    /**
     * 获取等待处理的事件队列
     * @return
     */
    public Queue<EventType> getEventQueue() {
        return mLocalEvents.get();
    }

    /**
     * 获取事件总线描述符
     * @return
     */
    public String getDescriptor() {
        return mDescriptor;
    }

    /**
     * 获取事件分发器
     * @return
     */
    public EventDispatcher getDispatcher() {
        return mDispatcher;
    }

    /**
     * 清空订阅对象和事件队列
     */
    public synchronized void clear() {
        mLocalEvents.get().clear();
        mSubscriberMap.clear();
    }

    /**
     * 事件分发器
     */
    private class EventDispatcher {
        //在主线程执行事件
        private EventHandler mMainEventHandler = new MainEventHandler();
        //在发布事件的线程执行事件
        private EventHandler mPostEventHandler = new PostEventHandler();
        //在子线程执行事件
        private EventHandler mAsyncEventHandler = new AsyncEventHandler();
        //缓存事件类型Map
        private Map<EventType, List<EventType>> mCacheEventType = new ConcurrentHashMap<>();
        //事件匹配策略
        private MatchStrategy mMatchStrategy = new DefaultMatchStrategy();

        /**
         * 处理事件
         * @param event 事件
         */
        private void dispatchEvent(Object event) {
            Queue<EventType> eventTypeQueue = mLocalEvents.get();
            while (eventTypeQueue.size() > 0) {
                deliverEvent(eventTypeQueue.poll(), event);
            }
        }

        private void dispatchStickyEvents(Object subscriber) {
            for (EventType eventType : mStickyEvents) {
                handleStickyEvent(eventType, subscriber);
            }
        }

        /**
         * 根据event查找所有匹配的集合，然后处理事件
         * @param eventType 事件类型
         * @param event 事件
         */
        private void deliverEvent(EventType eventType, Object event) {
            //如果有缓存，直接从从缓存中取
            List<EventType> eventTypes = getMatchedEventType(eventType, event);
            //遍历所有匹配的事件，并分发给订阅者
            for (EventType type : eventTypes) {
                handleEvent(type, event);
            }
        }

        /**
         * 处理单个事件
         * @param eventType
         * @param event
         */
        private void handleEvent(EventType eventType, Object event) {
            List<Subscription> subscriptions = mSubscriberMap.get(eventType);
            if (subscriptions == null) {
                return;
            }
            for (Subscription subscription : subscriptions) {
                final ThreadMode mode = subscription.threadMode;
                EventHandler eventHandler = getEventHandler(mode);
                //处理事件
                eventHandler.handEvent(subscription, event);
            }
        }

        /**
         * 处理单个sticky事件
         * @param eventType
         * @param subscriber
         */
        private void handleStickyEvent(EventType eventType, Object subscriber) {
            Object event = eventType.event;
            List<EventType> eventTypes = getMatchedEventType(eventType, event);
            for (EventType foundEventType : eventTypes) {
                final List<Subscription> subscriptions = mSubscriberMap.get(foundEventType);
                if (subscriptions == null) {
                    continue;
                }
                for (Subscription subscription : subscriptions) {
                    final ThreadMode mode = subscription.threadMode;
                    EventHandler eventHandler = getEventHandler(mode);
                    //如果订阅者为空，就把该sticky事件分发给所有其他订阅者，否则只分发给此事件的订阅者
                    if (isTarget(subscription, subscriber) &&
                            (subscription.eventType.equals(foundEventType) ||
                                    subscription.eventType.paramClass.isAssignableFrom(foundEventType.paramClass))) {
                        eventHandler.handEvent(subscription, event);
                    }
                }
            }
        }

        private List<EventType> getMatchedEventType(EventType eventType, Object event) {
            List<EventType> eventTypes;
            //如果有缓存，直接从从缓存中取
            if (mCacheEventType.containsKey(eventType)) {
                eventTypes = mCacheEventType.get(eventType);
            } else {
                eventTypes = mMatchStrategy.findMatchEventType(eventType, event);
                mCacheEventType.put(eventType, eventTypes);
            }
            return eventTypes != null ? eventTypes : new ArrayList<>();
        }

        private EventHandler getEventHandler(ThreadMode mode) {
            switch (mode) {
                case POST:
                    return mPostEventHandler;
                case ASYNC:
                    return mAsyncEventHandler;
                default:
                    return mMainEventHandler;
            }
        }

        private boolean isTarget(Subscription subscription, Object subscriber) {
            Object cacheObject = null;
            if (subscription.subscriber != null) {
                cacheObject = subscription.subscriber.get();
            }
            return subscriber == null || cacheObject != null && cacheObject.equals(subscriber);
        }
    }
}
