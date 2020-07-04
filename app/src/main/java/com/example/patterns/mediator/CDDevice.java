package com.example.patterns.mediator;

/**
 * 零部件——CD
 */
public class CDDevice extends Component {

    //CD中的数据
    private String data ;

    public CDDevice(Mediator mediator) {
        super(mediator);
    }

    /**
     * 获取CD中的数据
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     * 加载CD中的数据
     */
    public void load() {
        data = "视频数据";
        //通知中介者状态改变
        mediator.changed(this);
    }
}
