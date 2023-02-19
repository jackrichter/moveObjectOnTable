package com.test.moveobjectontable.service.impl;

import com.test.moveobjectontable.objectpoint.TableMatrix;
import com.test.moveobjectontable.service.CommandService;
import org.junit.After;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandServiceImplTest {

    private TableMatrix matrix = new TableMatrix(4, 4, 2, 2);
    private CommandServiceImpl positionTest = new CommandServiceImpl(new ArrayList<>(),matrix, false);

    @Test
    void testSimulateWithResultWithinTable() {
        String userInput = "1,4,1,3,2,4,4,1,1,0";

        String expected = "[0, 1]";

        // Prepare commands
        String[] lines = userInput.toString().split(",");

        // Perform simulation
        CommandService service = new CommandServiceImpl(new ArrayList<>(Arrays.asList(lines)), matrix, false);
        String actual = service.simulate();

        assertEquals(expected, actual);
    }
    @Test
    void testSimulateWithResultOutsideTable() {
        String userInput = "1,3,3,3,3,3,0";

        String expected = "[-1, -1]";

        // Prepare commands
        String[] lines = userInput.toString().split(",");

        // Perform simulation
        CommandService service = new CommandServiceImpl(new ArrayList<>(Arrays.asList(lines)), matrix, false);
        String actual = service.simulate();

        assertEquals(expected, actual);
    }

    @Test
    void testMoveForward() {
        int expected = 1;
        positionTest.moveForward();
        int actual = matrix.getPositionY();

        // Test
        assertEquals(expected, actual);

        // Revert back to original value
        matrix.setPositionY(2);
    }

    @Test
    void testMoveBackwards() {
        int expected = 3;
        positionTest.moveBackwards();
        int actual = matrix.getPositionY();

        // Test
        assertEquals(expected, actual);

        // Revert back to original value
        matrix.setPositionY(2);
    }

    @Test
    void testMoveNorthEast() {
        String expected = "3,1";
        positionTest.moveNorthEast();
        String actual = matrix.getPositionX() + "," + matrix.getPositionY();

        // Test
        assertEquals(expected, actual);

        // Revert back to original value
        matrix.setPositionX(2);
        matrix.setPositionY(2);
    }

    @Test
    void testMoveSouthWest() {
        String expected = "1,3";
        positionTest.moveSouthWest();
        String actual = matrix.getPositionX() + "," + matrix.getPositionY();

        // Test
        assertEquals(expected, actual);

        // Revert back to original value
        matrix.setPositionX(2);
        matrix.setPositionY(2);
    }

    @After
    public void freeUp() {
        this.matrix = null;
    }
}