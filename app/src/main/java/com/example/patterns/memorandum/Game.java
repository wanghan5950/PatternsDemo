package com.example.patterns.memorandum;

/**
 * 备忘录模式——游戏
 */
public class Game {

    //游戏状态
    private static final String STATE_MONSTER = "monsters"; //打怪
    private static final String STATE_PK = "pk"; //PK
    private static final String STATE_HANG_UP = "hang_up"; //挂机

    //等级
    private int level = 1;
    //血量
    private int blood = 100;
    //状态
    private String state = STATE_MONSTER;

    /**
     * 玩游戏
     */
    public void play() {
        System.out.println("正在玩游戏，" + toString());
        level += 1;
        blood -= 10;
        System.out.println("打了野怪，当前等级：" + toString());
        level += 1;
        blood -= 20;
        System.out.println("完成PK，当前等级：" + toString());
        blood = 100;
        System.out.println("挂机了一段时间，当前等级：" + toString());
    }

    /**
     * 退出游戏
     */
    public void quit() {
        System.out.println("-----------------");
        System.out.println("退出游戏，" + toString());
        System.out.println("-----------------");
    }

    /**
     * 创建备忘录
     */
    public Memo createMemo() {
        return new Memo(level, blood, state);
    }

    /**
     * 恢复游戏
     * @param memo 备忘录
     */
    public void restore(Memo memo) {
        this.level = memo.getLevel();
        this.blood = memo.getBlood();
        this.state = memo.getState();
        System.out.println("恢复游戏，" + toString());
    }

    @Override
    public String toString() {
        return "Game{" +
                "level=" + level +
                ", blood=" + blood +
                ", state='" + state + '\'' +
                '}';
    }
}
