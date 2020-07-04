package com.example.patterns.responsibilityChain;

/**
 * 具体处理者2
 */
public class Handler2 extends AbstractHandler {

    private static final int HANDLER_LEVEL = 2;

    @Override
    public int getHandleLevel() {
        return HANDLER_LEVEL;
    }

    @Override
    protected void handle(AbstractRequest request) {
        System.out.println("Handler" +
                HANDLER_LEVEL +
                " handle this request, level: " +
                request.getRequestLevel() +
                " content: " +
                request.getContent());
    }
}
