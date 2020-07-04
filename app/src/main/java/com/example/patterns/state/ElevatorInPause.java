package com.example.patterns.state;

/**
 * 状态实现类——电梯暂停中
 */
public class ElevatorInPause implements ElevatorState {

    private ElevatorInPause() {
    }

    public static ElevatorInPause getInstance() {
        return InstanceHolder.instance;
    }

    @Override
    public void openDoor() {
        System.out.println("open the door successful");
    }

    @Override
    public void closeDoor() {
        System.out.println("close the door successful");
    }

    @Override
    public void goToFloor(int floor) {
        System.out.println("will go to " + floor + " floor");
    }

    private static class InstanceHolder {
        private static ElevatorInPause instance = new ElevatorInPause();
    }
}
