package ua.epam.externalJava.port.queue;

import ua.epam.externalJava.port.ships.Ship;

import java.util.HashMap;

public class PortQueue {
//    private HashMap<Integer, Ship> mooringsBusy = new HashMap<>();
//    private HashMap<Integer, Boolean> mooringsFree = new HashMap<>();
//    private boolean isPortFree=false;
    private int visit;
    private boolean valueSet = false;

    public synchronized int get () {
        while(!valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valueSet = false;
        notify();
        return visit;
    }

    public synchronized void put (int visit){
        while(valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.visit = visit;
        valueSet = true;
        notify();
    }
}
