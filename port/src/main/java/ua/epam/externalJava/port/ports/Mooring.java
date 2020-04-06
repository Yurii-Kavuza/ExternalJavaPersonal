package ua.epam.externalJava.port.ports;

import ua.epam.externalJava.port.ships.Ship;
import java.util.Random;

public class Mooring implements Runnable {
    private Port port;
    private int number;

    public Mooring(Port port) {
        this.port = port;
        port.setMaxShipsInPort();
        number = port.getMaxShipsInPort();
        System.out.println(this+" is started to work");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Ship ship = port.get();
                if (ship != null) {
                    unloadShip(ship);
                    Thread.sleep(2000);
                    loadShip(ship);
                    Thread.sleep(2000);
                    String info = String.format("The mooring %s is free.", number);
                    System.out.println(info);
                    ship.setReady(true);
                    ship.swim();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void unloadShip(Ship ship) {
        try {
            System.out.println(this);
            int containers = getContainers(port.getFreeCapacity(),
                    ship.getContainersQuantity());
            printMessage(containers, " containers will be unloaded from the ship ", ship);
            for (int i = 0; i < containers; i++) {
                ship.unload(1);
                port.load(1);
                Thread.sleep(10);
            }
            printMessage(containers, " containers have been unloaded from the ship ", ship);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void loadShip(Ship ship) {
        try {
            int containers = getContainers(port.getContainersQuantity(),
                    ship.getFreeCapacity());
            printMessage(containers, " containers will be loaded to the ship ", ship);
            for (int i = 0; i < containers; i++) {
                port.unload(1);
                ship.load(1);
                Thread.sleep(10);
            }
            printMessage(containers, " containers have been loaded to the ship ", ship);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getContainers(int portValue, int shipValue) {
        return new Random().nextInt(Math.min(portValue, shipValue));
    }

    private void printMessage(int quantity, String message, Ship ship) {
        StringBuilder builder = new StringBuilder();
        builder.append(quantity);
        builder.append(message);
        builder.append(ship.getName());
        System.out.println(builder.toString());
        System.out.println(ship.toString());
        System.out.println(port.toString());
    }

    @Override
    public String toString() {
        return "Mooring " + number;
    }
}