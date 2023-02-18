package com.test.moveobjectontable.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The Object on which the simulation is done.
 * An instance of this object represents a table with a point occupying a cell.
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableMatrix {
    private int width;
    private int height;
    private int positionX;
    private int positionY;
}
