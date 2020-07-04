package com.example.patterns.apperaance;

/**
 * 外观模式——Camera接口实现
 */
public class CameraImpl implements Camera {

    @Override
    public void open() {
        System.out.println("打开相机");
    }

    @Override
    public void takePhoto() {
        System.out.println("拍照");
    }

    @Override
    public void close() {
        System.out.println("关闭相机");
    }
}
