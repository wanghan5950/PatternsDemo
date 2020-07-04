package com.example.patterns.observer.EventBus.handler;

import android.os.Handler;
import android.os.Looper;
import com.example.patterns.observer.EventBus.Subscription;

/**
 * 在主线程执行事件，通过Handler将事件post到主线程的消息队列
 */
public class MainEventHandler implements EventHandler {

    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    private PostEventHandler mEventHandler = new PostEventHandler();

    @Override
    public void handEvent(Subscription subscription, Object event) {
        mMainHandler.post(() -> mEventHandler.handEvent(subscription, event));
    }
}
