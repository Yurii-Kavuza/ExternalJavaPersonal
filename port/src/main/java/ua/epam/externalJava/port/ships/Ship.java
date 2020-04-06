package ua.epam.externalJava.port.ships;

import ua.epam.externalJava.port.ports.Port;

public class Ship implements Runnable {
    private String name;
    private int containersCapacity;
    private int containersQuantity;
    private Port port;
    private boolean isReady;

    public Ship(String name, int containersCapacity) {
        this.name = name;
        this.containersCapacity = containersCapacity;
        isReady=true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public void load(int containers) {
        containersQuantity += containers;
    }

    public void unload(int containers) {
        containersQuantity -= containers;
    }

    public int getContainersCapacity() {
        return containersCapacity;
    }

    public int getFreeCapacity() {
        return getContainersCapacity() - getContainersQuantity();
    }

    public int getContainersQuantity() {
        return containersQuantity;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public void swim() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            if(isReady){
                if (port.getFreeCapacity() >= this.getContainersQuantity()) {
                    port.add(this);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Ship ");
        builder.append(name);
        builder.append(" has containers capacity ");
        builder.append(containersCapacity);
        builder.append(" and has ").append(containersQuantity);
        builder.append(" containers on the board now.");
        return builder.toString();
    }
}