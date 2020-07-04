package com.example.patterns.state;

/**
 * 状态控制接口——电梯控制接口
 */
public interface ElevatorController {

    void powerOn();

    void powerOff();

    void openDoor();

    void closeDoor();

    void goToFloor(int floor);
}
