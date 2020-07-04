package com.example.patterns.responsibilityChain;

/**
 * 具体请求者1
 */
public class Request1 extends AbstractRequest {

    //此请求者的请求级别
    private static final int REQUEST_LEVEL = 1;

    public Request1(String content) {
        super(content);
    }

    @Override
    public int getRequestLevel() {
        return REQUEST_LEVEL;
    }
}
