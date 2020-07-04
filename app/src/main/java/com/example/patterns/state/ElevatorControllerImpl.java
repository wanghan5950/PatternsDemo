package com.example.patterns.state;

/**
 * 状态控制实现类——电梯控制实现类
 */
public class ElevatorControllerImpl implements ElevatorController {

    private ElevatorState mState;

    public void setState(ElevatorState mState) {
        this.mState = mState;
    }

    @Override
    public void powerOn() {
        setState(ElevatorInPause.getInstance());
        System.out.println("elevator is on");
    }

    @Override
    public void powerOff() {
        setState(ElevatorInStop.getInstance());
        System.out.println("elevator is off");
    }

    @Override
    public void openDoor() {
        mState.openDoor();
    }

    @Override
    public void closeDoor() {
        mState.closeDoor();
    }

    @Override
    public void goToFloor(int floor) {
        if (!(mState instanceof ElevatorInStop)) {
            setState(ElevatorInOperation.getInstance());
            System.out.println("will go to " + floor + " floor");
        }
        mState.goToFloor(floor);
    }
}
