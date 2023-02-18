package com.test.moveobjectontable.menu;

import com.test.moveobjectontable.object.TableMatrix;
import com.test.moveobjectontable.service.CommandService;
import com.test.moveobjectontable.service.impl.CommandServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ConsoleMenu {

    private static final String HEADER_MATRIX = "- The size of the table as two integers [width, height]";
    private static final String HEADER_XY = "- The objects starting position as two integers [x, y]";
    private static final String SUCCESS_RESULT = "The simulation succeeded: ";
    private static final String FAILURE_RESULT = "Failed. Object falls off the table: ";
    private static final String COMMAND_QUIT = "quit simulation and print results to stdout";
    private static final String COMMAND_FORWARD = "move forward one step";
    private static final String COMMAND_BACKWARDS = "move backwards one step";
    private static final String COMMAND_NORTH_EAST = "rotate clockwise 90 degrees (eg north to east)";
    private static final String COMMAND_SOUTH_WEST = "rotate counterclockwise 90 degrees (eg west to south)";
    private static final String SEPARATOR = "-------------------------------------------------------";

    private List<String> commandList = Arrays.asList(COMMAND_QUIT, COMMAND_FORWARD, COMMAND_BACKWARDS, COMMAND_NORTH_EAST, COMMAND_SOUTH_WEST);
    private Scanner scanner = new Scanner(System.in);
    private TableMatrix matrix;
    private CommandService service;

    /**
     * Simulation start point
     */
    public void run() {
        showMenu();
    }

    private void showMenu() {
        showHeader();
        boolean proceed = inputHeader();
        if (proceed) {
            showCommands();
            inputCommands();
            showResult();
        }
    }

    /**
     * Reads the matrix size and the initial point's position.
     *
     * @return True if 4 comma separated digits where inputted, otherwise false.
     */
    private boolean inputHeader() {
        // Get matrix input
        String headerInput = scanner.next();
        String[] coords = headerInput.split(",");
        if (coords.length != 4) {
            System.out.println();
            System.out.println("Invalid number of arguments for the header.");
            return false;
        }
        // Build the table matrix
        matrix = new TableMatrix(Integer.valueOf(coords[0]), Integer.valueOf(coords[1]), Integer.valueOf(coords[2]), Integer.valueOf(coords[3]));

        return true;
    }

    private void showCommands() {
        System.out.println(SEPARATOR);
        final int[] i = {0};
        commandList.forEach(name -> {
            System.out.println(i[0] + " = " + name);
            i[0]++;
        });

    }

    private void inputCommands() {
        String input = this.scanner.next();
        String[] commandValues = input.split(",");
         service = new CommandServiceImpl(Arrays.asList(commandValues), this.matrix, true);
    }

    private void showHeader() {
        System.out.println(SEPARATOR);
        System.out.println(HEADER_MATRIX);
        System.out.println(HEADER_XY);
        System.out.println();
    }

    /**
     * Performs the simulation and display the result.
     */
    private void showResult() {
        String result = service.simulate();

        System.out.println(SEPARATOR);
        if (service.isFailure()){
            System.out.println(FAILURE_RESULT + result);
        } else {
            System.out.println(SUCCESS_RESULT + result);
        }
    }
}
