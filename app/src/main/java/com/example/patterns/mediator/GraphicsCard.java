package com.example.patterns.mediator;

/**
 * 零部件——显卡
 */
public class GraphicsCard extends Component {

    public GraphicsCard(Mediator mediator) {
        super(mediator);
    }

    /**
     * 渲染画面
     */
    public void render(String content) {
        System.out.println("渲染画面：" + content);
    }
}
