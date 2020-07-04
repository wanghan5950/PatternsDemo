package com.example.patterns.prototype;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式——浅拷贝
 */
public class Document implements Cloneable {

    private String text;
    private List<String> imageList = new ArrayList<>();

    /**
     * 拷贝对象直接引用了原对象的字段，导致修改了其中一个对象的字段，另一个对象的字段也会变化
     * @return
     * @throws CloneNotSupportedException
     */
    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Document documentClone = (Document) super.clone();
        documentClone.text = this.text;
        documentClone.imageList = this.imageList;
        return documentClone;
    }
}
