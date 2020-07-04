package com.example.patterns.apperaance;

/**
 * 外观模式
 * 提供统一操作接口，隐藏具体实现
 */
public class MobilePhone {

    private Phone phone = new PhoneImpl();
    private Camera camera = new CameraImpl();

    public void call() {
        phone.call();
    }

    public void videoChat() {
        camera.open();
        phone.call();
    }

    public void hangup() {
        phone.hangup();
    }

    public void takePhoto() {
        camera.open();
        camera.takePhoto();
    }

    public void closeCamera() {
        camera.close();
    }
}
