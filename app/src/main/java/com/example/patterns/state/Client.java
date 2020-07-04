package com.example.patterns.state;

public class Client {

    public static void main(String[] args) {
        ElevatorControllerImpl controller = new ElevatorControllerImpl();
        controller.powerOn();
        controller.openDoor();
        controller.goToFloor(10);
        controller.closeDoor();
        controller.openDoor();
        controller.powerOff();
        controller.openDoor();
        controller.goToFloor(5);
    }
}
