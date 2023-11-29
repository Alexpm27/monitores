package com.example.terminal.threads;

import com.almasb.fxgl.entity.Entity;
import com.example.terminal.monitor.Terminal;

public class Passenger implements Runnable {
    private final Entity person;
    private String name;
    private Terminal terminal;

    public Passenger(String name, Terminal terminal, Entity person){
        this.name = name;
        this.terminal = terminal;
        this.person = person;
    }

    @Override
    public void run() {
        try {
            terminal.provideTicket(name, person);
            terminal.validateTicket(name, person);
            terminal.boardBus(name, person);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}