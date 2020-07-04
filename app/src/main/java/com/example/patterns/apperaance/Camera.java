package com.example.patterns.apperaance;

/**
 * 外观模式——Camera接口
 */
public interface Camera {

    //打开相机
    void open();

    //拍照
    void takePhoto();

    //关闭相机
    void close();
}
