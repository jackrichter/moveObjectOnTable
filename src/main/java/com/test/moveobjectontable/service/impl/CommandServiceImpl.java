package com.test.moveobjectontable.service.impl;

import com.test.moveobjectontable.object.TableMatrix;
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

    @Override
    public void moveForward() {

    }

    @Override
    public void moveBackwards() {

    }

    @Override
    public void moveNorthEast() {

    }

    @Override
    public void moveSouthWest() {

    }

    @Override
    public String getResult() {
        return null;
    }
}
