package com.example.patterns.state;

/**
 * 状态模式——电梯状态接口
 * 定义所有的操作，根据不同的状态，在实现类中对方法有不同的具体实现
 */
public interface ElevatorState {

    void openDoor();

    void closeDoor();

    void goToFloor(int floor);
}
