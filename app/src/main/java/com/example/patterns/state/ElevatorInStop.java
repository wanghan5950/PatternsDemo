package com.example.patterns.state;

/**
 * 状态实现类——电梯停运中
 */
public class ElevatorInStop implements ElevatorState {

    private ElevatorInStop() {
    }

    public static ElevatorInStop getInstance() {
        return InstanceHolder.instance;
    }

    @Override
    public void openDoor() {
        System.out.println("can not open the door in stop!");
    }

    @Override
    public void closeDoor() {
        System.out.println("can not close the door in stop!");
    }

    @Override
    public void goToFloor(int floor) {
        System.out.println("can not add floor in stop!");
    }

    private static class InstanceHolder {
        private static ElevatorInStop instance = new ElevatorInStop();
    }
}
