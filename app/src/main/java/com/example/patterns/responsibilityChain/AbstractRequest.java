package com.example.patterns.responsibilityChain;

/**
 * 责任链模式——抽象请求者
 */
public abstract class AbstractRequest {

    //要处理的事件对象
    private String content;

    public AbstractRequest(String content) {
        this.content = content;
    }

    /**
     * 获取要处理的事件对象
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * 获取请求级别
     * @return
     */
    public abstract int getRequestLevel();
}
