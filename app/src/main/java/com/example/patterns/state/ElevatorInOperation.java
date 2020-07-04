package com.example.patterns.state;

/**
 * 状态实现类——电梯运行中
 */
public class ElevatorInOperation implements ElevatorState {

    private ElevatorInOperation() {
    }

    public static ElevatorInOperation getInstance() {
        return InstanceHolder.instance;
    }

    @Override
    public void openDoor() {
        System.out.println("can not open the door in operation!");
    }

    @Override
    public void closeDoor() {
        System.out.println("can not close the door in operation!");
    }

    @Override
    public void goToFloor(int floor) {
        System.out.println("will go to " + floor + " floor");
    }

    private static class InstanceHolder {
        private static ElevatorInOperation instance = new ElevatorInOperation();
    }
}
