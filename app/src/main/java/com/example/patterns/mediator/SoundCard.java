package com.example.patterns.mediator;

/**
 * 零部件——声卡
 */
public class SoundCard extends Component {

    public SoundCard(Mediator mediator) {
        super(mediator);
    }

    /**
     * 播放声音
     * @param sound 音频数据
     */
    public void playSound(String sound) {
        System.out.println("播放声音：" + sound);
    }
}
