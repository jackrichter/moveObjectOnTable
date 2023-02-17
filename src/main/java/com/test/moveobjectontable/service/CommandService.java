package com.test.moveobjectontable.service;

public interface CommandService {
    void moveForward();

    void moveBackwards();

    void moveNorthEast();

    void moveSouthWest();

    String getResult();
}
