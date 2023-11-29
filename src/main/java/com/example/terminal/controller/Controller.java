package com.example.terminal.controller;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.example.terminal.factory.Factory;
import com.example.terminal.monitor.Terminal;
import com.example.terminal.threads.Passenger;
import javafx.fxml.Initializable;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.terminal.utilities.Username.generateUsername;

public class Controller implements Initializable {
    private final Terminal terminal = new Terminal();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXGL.getGameWorld().addEntityFactory(new Factory());
            FXGL.spawn("Boletos", 1, 180);
            //FXGL.spawn("Bus", 400, 225);
            FXGL.spawn("Target");
        for (int i = 0; i < 30; i++) {
            int index = i;
            String name = generateUsername();
            double delay = 3 + Math.random() * 3;
            FXGL.getGameTimer().runOnceAfter(() -> {
                Entity person = FXGL.spawn("Person", 80+(index*10), 215-(index*3));
                Passenger passenger = new Passenger(name, terminal, person);
                System.out.println(name + " llego a la terminal");
                new Thread(passenger).start();
            }, Duration.seconds(delay + i ));
        }
    }
}