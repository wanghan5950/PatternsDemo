package com.example.patterns.prototype;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式——深拷贝
 */
public class DeepDocument implements Cloneable {

    private String text;
    private ArrayList<String> imageList = new ArrayList<>();

    /**
     * 字段也采用拷贝的形式，而不是直接引用，从而避免了操作副本时对原始对象的影响
     * @return
     * @throws CloneNotSupportedException
     */
    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepDocument document = (DeepDocument) super.clone();
        document.text = this.text;
        document.imageList = (ArrayList<String>) this.imageList.clone();
        return document;
    }
}
