package com.test.moveobjectontable.menu;

import com.test.moveobjectontable.objectpoint.TableMatrix;
import com.test.moveobjectontable.service.CommandService;
import com.test.moveobjectontable.service.impl.CommandServiceImpl;
import org.junit.After;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleMenuTest {

    private TableMatrix matrix = new TableMatrix(4, 4, 2, 2);

    @Test
    void testHeaderLoadAndUserInput() {

        // This simulates the users input of matrix and point's coordinates
        String userInput = "4,4,2,2";
        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        String expected = "4422";

        // Setting the output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(output);
        System.setOut(printStream);

        // Handling the input to  be compared
        String out = "4,4,2,2";
        String[] lines = out.toString().split(",");
        String actual = "";
        for (String s : lines) {
            actual += s;
        }

        // Compare to determining the test result
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectCommandsUserInput() {

        // This simulates the users input of command values
        String userInput = "1,4,1,3,2,4,2,4,1,0";
        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        String expected = "1413242410";

        // Setting the output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(output);
        System.setOut(printStream);

        // Handling the input to  be compared
        String out = "1,4,1,3,2,4,2,4,1,0";
        String[] lines = out.toString().split(",");
        String actual = "";
        for (String s : lines) {
            actual += s;
        }

        // Compare to determining the test result
        assertEquals(expected, actual);
    }

    @Test
    public void testNoQuitCommandShowsError() {

        // Command input missing quit command (0)
        String userInput = "1,4,1,3,2,4,2,4,1";
        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        String expected = "Stop command hasn't been given";

        // Handling the input to  be compared
        String out = "1,4,1,3,2,4,2,4,1";
        String[] lines = out.toString().split(",");
        CommandService service = new CommandServiceImpl(new ArrayList<>(Arrays.asList(lines)), matrix, true);

        // Test simulation
        String actual = service.simulate();

        assertEquals(expected, actual);
    }

    @After
    public void freeUp() {
        this.matrix = null;
    }
}