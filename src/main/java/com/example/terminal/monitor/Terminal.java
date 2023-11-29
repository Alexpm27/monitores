package com.example.terminal.monitor;

import com.almasb.fxgl.entity.Entity;

public class Terminal {
    private boolean ticketAreaFree = true;
    private boolean busReady = false;
    private int passengersBoarded = 0;
    private int totalPassengers = 30;

    public synchronized void provideTicket(String passengerName, Entity person) throws InterruptedException {

        while (!ticketAreaFree) {
            wait();
        }

        ticketAreaFree = false;
        System.out.println(passengerName + " en ventanilla");
        Thread.sleep(600);
        person.setPosition(15, 200);
        Thread.sleep((long) (1000 + Math.random() * 1000));
        person.setVisible(false);
        System.out.println(passengerName + " compro boleto");
        ticketAreaFree = true;
        notifyAll();
    }

    public synchronized void validateTicket(String passengerName, Entity person) throws InterruptedException {
        System.out.println(passengerName + " mostrando su boleto");
        person.setVisible(true);
        person.setPosition(420, 200);
        Thread.sleep((long) (1000 + Math.random() * 1000));
        person.setVisible(false);
    }

    public synchronized void boardBus(String passengerName, Entity person) throws InterruptedException {
        passengersBoarded++;
        Thread.sleep((long) (1000 + Math.random() * 1000));
        System.out.println(passengerName + " subio al bus");

        if (passengersBoarded == 3) {
            System.out.println("Bus se lleno. Saliendo.");
            Thread.sleep(5000);
            System.out.println("Bus llego a su destino. Las personas bajaran.");
            for (int i = 0; i < 3; i++) {
                final int passengerNumber = i + 1;
                new Thread(() -> {
                    try {
                        descendPassenger(person, passengerNumber);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
            passengersBoarded = 0;
            busReady = true;
            notifyAll();
        } else {
            while (!busReady && totalPassengers > 0) {
                wait();
            }
        }
        totalPassengers--;
        if (totalPassengers == 0) {
            busReady = false;
        }
    }

    private void descendPassenger(Entity Juan, int passengerNumber) throws InterruptedException {
        Juan.setVisible(true);
        Juan.setPosition(600, 100 + (passengerNumber*3));
        Thread.sleep((long) (1000 + Math.random() * 1000));
        Juan.setVisible(false);
        System.out.println("Pasajero " + passengerNumber + " Bajo del bus");
    }
}
