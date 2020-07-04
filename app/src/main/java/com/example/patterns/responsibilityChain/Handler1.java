package com.example.patterns.responsibilityChain;

/**
 * 具体处理者1
 */
public class Handler1 extends AbstractHandler {

    //此处理者的处理级别
    private static final int HANDLER_LEVEL = 1;

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
