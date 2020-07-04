package com.example.patterns.mediator;

public class Client {

    public static void main(String[] args) {
        //构造主板对象(中介者)
        MainBoard mainBoard = new MainBoard();
        //构造零部件对象
        CDDevice cdDevice = new CDDevice(mainBoard);
        CPU cpu = new CPU(mainBoard);
        GraphicsCard graphicsCard = new GraphicsCard(mainBoard);
        SoundCard soundCard = new SoundCard(mainBoard);
        //给主板设置零部件
        mainBoard.setCdDevice(cdDevice);
        mainBoard.setCpu(cpu);
        mainBoard.setGraphicsCard(graphicsCard);
        mainBoard.setSoundCard(soundCard);
        //让CD设备开始加载数据
        cdDevice.load();
    }
}
