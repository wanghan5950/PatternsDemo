package com.example.patterns.memorandum;

/**
 * 备忘录模式——备忘录类
 */
public class Memo {

    //等级
    private int level;
    //血量
    private int blood;
    //状态
    private String state;

    public Memo(int level, int blood, String state) {
        this.level = level;
        this.blood = blood;
        this.state = state;
    }

    public int getLevel() {
        return level;
    }

    public int getBlood() {
        return blood;
    }

    public String getState() {
        return state;
    }
}
