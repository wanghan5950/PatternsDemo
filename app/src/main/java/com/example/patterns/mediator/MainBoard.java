package com.example.patterns.mediator;

/**
 * 中介者模式——中介者实现：主板
 */
public class MainBoard extends Mediator{

    //持有各种零部件
    private CDDevice cdDevice;
    private CPU cpu;
    private GraphicsCard graphicsCard;
    private SoundCard soundCard;

    @Override
    public void changed(Component component) {
        if (component == cdDevice) {
            handleCD((CDDevice) component);
        } else if (component == cpu) {
            handleCPU((CPU) cpu);
        }
    }

    /**
     * 处理CD读取数据后让CPU来处理
     * @param cdDevice CD设备
     */
    private void handleCD(CDDevice cdDevice) {
        cpu.decodeData(cdDevice.getData());
    }

    /**
     * CPU处理好的数据由显卡声卡来展示
     * @param cpu CPU
     */
    private void handleCPU(CPU cpu) {
        soundCard.playSound(cpu.getDataSound());
        graphicsCard.render(cpu.getDataVideo());
    }

    /**
     * 设置各种零部件
     */
    public void setCdDevice(CDDevice cdDevice) {
        this.cdDevice = cdDevice;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }
}
