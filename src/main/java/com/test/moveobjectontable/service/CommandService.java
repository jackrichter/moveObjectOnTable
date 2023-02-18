package com.test.moveobjectontable.service;

public interface CommandService {
    String simulate();

    void moveForward();

    void moveBackwards();

    void moveNorthEast();

    void moveSouthWest();

    boolean isFailure();
}
