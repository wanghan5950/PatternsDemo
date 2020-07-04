package com.example.patterns.memorandum;

/**
 * 备忘录模式——备忘录管理类
 */
public class Caretaker {

    //备忘录
    private Memo mMemo;

    /**
     * 存档
     * @param memo
     */
    public void saveMemo(Memo memo) {
        this.mMemo = memo;
    }

    /**
     * 恢复存档
     * @return
     */
    public Memo getMemo() {
        return this.mMemo;
    }
}
