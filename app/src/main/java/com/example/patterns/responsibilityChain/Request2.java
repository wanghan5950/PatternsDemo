package com.example.patterns.responsibilityChain;

/**
 * 具体请求者2
 */
public class Request2 extends AbstractRequest {

    private static final int REQUEST_LEVEL = 2;

    public Request2(String content) {
        super(content);
    }

    @Override
    public int getRequestLevel() {
        return REQUEST_LEVEL;
    }
}
