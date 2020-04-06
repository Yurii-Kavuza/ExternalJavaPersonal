package ua.epam.externalJava.port.ports;

import ua.epam.externalJava.port.ships.Ship;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Port{
    private String name;
    private int containersCapacity;
    private AtomicInteger containersQuantity = new AtomicInteger(0);

    private static final int MIN_SHIPS_IN_PORT = 0;
    private int maxShipsInPort=0;
    private int shipsCounter;
    private List<Ship> ships;

    public Port(String name) {
        this.name = name;
        ships = new LinkedList<>();
    }

    public synchronized void add(Ship ship){
        try{
            if(shipsCounter<maxShipsInPort){
                notifyAll();
                ships.add(ship);
                ship.setReady(false);
                System.out.println("The ship "+ship.getName()+" is arrived in the port");
                System.out.println(ship);
                shipsCounter++;
            }else {
                System.out.println("There is not any place for the ship " +ship.getName()+
                        " in the port "+ this.name);
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Ship get(){
        try{
            if(shipsCounter>MIN_SHIPS_IN_PORT){
                notifyAll();
                for(Ship ship : ships){
                    if(ship!=null){
                        shipsCounter--;
                        ships.remove(ship);
                        System.out.println("The ship " + ship.getName() +
                                " is arrived to mooring. There are waiting " +
                                ships.size() +
                                " ships in the port.");
                        return ship;
                    }
                }

            }else {
                System.out.println("There is not waiting any ship");
                wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    public void load(int containers) {
        containersQuantity.addAndGet(containers);
    }

    public void unload(int containers) {
        containersQuantity.addAndGet(-containers);
    }

    public int getContainersCapacity() {
        return containersCapacity;
    }

    public void setContainersCapacity(int containersCapacity) {
        this.containersCapacity = containersCapacity;
    }

    public int getContainersQuantity() {
        return containersQuantity.get();
    }

    public void setContainersQuantity(int containersQuantity) {
        this.containersQuantity.lazySet(containersQuantity);
    }

    public int getFreeCapacity() {
        return getContainersCapacity() - getContainersQuantity();
    }

    public int getMaxShipsInPort() {
        return maxShipsInPort;
    }

    public void setMaxShipsInPort() {
        maxShipsInPort++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Port ");
        builder.append(name);
        builder.append(" has containers capacity ");
        builder.append(containersCapacity);
        builder.append(" and has ").append(containersQuantity);
        builder.append(" containers in the port now.");
        return builder.toString();
    }
}
