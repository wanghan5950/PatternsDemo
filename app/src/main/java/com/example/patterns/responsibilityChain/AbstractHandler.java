package com.example.patterns.responsibilityChain;

/**
 * 责任链模式——抽象处理者
 */
public abstract class AbstractHandler {

    //下一个节点的处理者
    public AbstractHandler nextHandler;

    /**
     * 处理请求
     * @param request
     */
    public final void handleRequest(AbstractRequest request) {
        if (request.getRequestLevel() == getHandleLevel()) {
            handle(request);
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                System.out.println("All handler can not handle this request");
            }
        }
    }

    /**
     * 获取处理级别
     * @return
     */
    public abstract int getHandleLevel();

    /**
     * 此处理者处理请求
     */
    protected abstract void handle(AbstractRequest request);
}
