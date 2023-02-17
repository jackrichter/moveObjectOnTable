package com.test.moveobjectontable;

import com.test.moveobjectontable.menu.ConsoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoveObjectOnTableApplication implements CommandLineRunner {

    @Autowired
    ConsoleMenu consoleMenu;
    public static void main(String[] args) {
        SpringApplication.run(MoveObjectOnTableApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        consoleMenu.run();
    }
}
