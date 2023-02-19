package com.test.moveobjectontable.service.impl;

import com.test.moveobjectontable.objectpoint.TableMatrix;
import com.test.moveobjectontable.service.CommandService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandServiceImpl implements CommandService {
    private List<String> commands;
    private TableMatrix matrix;
    private boolean failure;

    /**
     * Performs the simulation as per the inputted commands.
     * Command values outside the accepted range do not affect the simulation.
     *
     * @return The simulations result
     */
    @Override
    public String simulate() {
        String result = "Stop command hasn't been given";

        for (String s : commands) {
            switch (s) {
                case "0":
                    result = getResult();
                    break;
                case "1":
                    moveForward();
                    break;
                case "2":
                    moveBackwards();
                    break;
                case "3":
                    moveNorthEast();
                    break;
                case "4":
                    moveSouthWest();
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    @Override
    public void moveForward() {
        matrix.setPositionY(matrix.getPositionY() - 1);
    }

    @Override
    public void moveBackwards() {
        matrix.setPositionY(matrix.getPositionY() + 1);
    }

    @Override
    public void moveNorthEast() {
        matrix.setPositionY(matrix.getPositionY() - 1);
        matrix.setPositionX(matrix.getPositionX() + 1);
    }

    @Override
    public void moveSouthWest() {
        matrix.setPositionY(matrix.getPositionY() + 1);
        matrix.setPositionX(matrix.getPositionX() - 1);
    }

    public boolean isFailure() {
        return failure;
    }

    /**
     * Calculates whether the given commands cause the point fall off the matrix or not.
     *
     * @return A string indicating the point's position [x, y] or a constant [-1, -1] i case of failure.
     */
    private String getResult() {
        int x = matrix.getPositionX();
        int y = matrix.getPositionY();

        if((matrix.getWidth() - x) < 0 || (matrix.getHeight() - y) < 0) {
            failure = true;
            return "[-1, -1]";
        } else {
            failure = false;
            return "[" + x + ", " + y + "]";
        }
    }
}
