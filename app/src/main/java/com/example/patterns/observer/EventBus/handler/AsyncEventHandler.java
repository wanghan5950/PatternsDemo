package com.example.patterns.observer.EventBus.handler;

import android.os.Handler;
import android.os.HandlerThread;
import com.example.patterns.observer.EventBus.Subscription;

/**
 * 在子线程中执行事件
 */
public class AsyncEventHandler implements EventHandler {

    /**
     * 事件分发线程
     */
    private DispatcherThread mDispatcherThread;
    /**
     * 事件处理器
     */
    private EventHandler mEventHandler = new PostEventHandler();

    public AsyncEventHandler() {
        mDispatcherThread = new DispatcherThread(AsyncEventHandler.class.getSimpleName());
        mDispatcherThread.start();
    }

    /**
     * 在异步线程中执行订阅方法
     * @param subscription 观察者对象
     * @param event 事件对象
     */
    @Override
    public void handEvent(Subscription subscription, Object event) {
        mDispatcherThread.post(() -> mEventHandler.handEvent(subscription, event));
    }

    private static class DispatcherThread extends HandlerThread {

        /**
         * 关联了AsyncExecutor消息队列的Handler
         */
        private Handler mAsyncHandler;

        public DispatcherThread(String name) {
            super(name);
        }

        public void post(Runnable runnable) {
            if (mAsyncHandler == null) {
                throw new NullPointerException("mAsyncHandler is null, please call start() first.");
            }
            mAsyncHandler.post(runnable);
        }

        @Override
        public synchronized void start() {
            super.start();
            mAsyncHandler = new Handler(this.getLooper());
        }
    }
}
