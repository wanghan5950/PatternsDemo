package com.example.patterns.mediator;

/**
 * 零部件——CPU
 */
public class CPU extends Component {

    //视频数据
    private String dataVideo;
    //音频数据
    private String dataSound;

    public CPU(Mediator mediator) {
        super(mediator);
    }

    /**
     * 获取视频数据
     * @return
     */
    public String getDataVideo() {
        return dataVideo;
    }

    /**
     * 获取音频数据
     * @return
     */
    public String getDataSound() {
        return dataSound;
    }

    /**
     * 解码数据
     * @param data 音视频数据
     */
    public void decodeData(String data) {
        //分割音视频数据
        String[] tmp = data.split(",");
        //解析音视频数据
        dataVideo = tmp[0];
        dataSound = tmp[1];
        //通知中介者状态改变
        mediator.changed(this);
    }
}
