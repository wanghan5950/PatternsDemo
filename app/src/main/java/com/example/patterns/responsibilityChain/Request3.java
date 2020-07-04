package com.example.patterns.responsibilityChain;

/**
 * 具体请求者3
 */
public class Request3 extends AbstractRequest {

    private static final int REQUEST_LEVEL = 3;

    public Request3(String content) {
        super(content);
    }

    @Override
    public int getRequestLevel() {
        return REQUEST_LEVEL;
    }
}
