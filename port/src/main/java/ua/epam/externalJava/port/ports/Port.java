package ua.epam.externalJava.port.ports;

import ua.epam.externalJava.port.ships.Ship;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Port{
    private String name;
    private int containersCapacity;
    private volatile int containersQuantity;
    private boolean isFree;
    private int numberOfFreeMooring;
    private HashMap<Integer, Ship> moorings = new HashMap<>();

    public Port(String name, int mooringsQuantity) {
        this.name = name;
        System.out.println("The port " + name + " is started to work.");
        setMoorings(mooringsQuantity);
    }

    public synchronized void get(Ship ship){
        try{
            if(isFree()){
                notifyAll();
                moorings.put(getNumberOfFreeMooring(),ship);
                StringBuilder builder = new StringBuilder("The ship ");
                builder.append(ship.getName()).append(" is arrived in the port");
                System.out.println(builder.toString());
                System.out.println(ship);
            }else {
                StringBuilder builder = new StringBuilder("There is not any place for the ship ");
                builder.append(ship.getName()).append(" in the port ").append(this.name);
                System.out.println(builder.toString());
                wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public class Mooring implements Runnable {
        private int number;
        private Ship ship;

        public Mooring(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            while(true){
                ship=moorings.get(number);
                if(ship!=null){
                    try{
                        unloadShip(ship);
                        Thread.sleep(2000);
                        loadShip(ship);
                        Thread.sleep(2000);
                        releaseShip();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        private void unloadShip(Ship ship){
            try{
                int containers = getContainers(Port.this.getFreeCapacity(),
                        ship.getContainersQuantity());
                printMessage(containers, " containers will be unloaded from the ship ");
                for (int i = 0; i < containers; i++) {
                    ship.unload(1);
                    Port.this.load(1);
                    Thread.sleep(10);
                }
                printMessage(containers, " containers have been unloaded from the ship ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void loadShip (Ship ship){
            try{
                int containers = getContainers(Port.this.getContainersQuantity(),
                        ship.getFreeCapacity());
                printMessage(containers, " containers will be loaded to the ship ");
                for (int i = 0; i < containers; i++) {
                    Port.this.unload(1);
                    ship.load(1);
                    Thread.sleep(10);
                }
                printMessage(containers, " containers have been loaded to the ship ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private int getContainers(int portValue,int shipValue){
            return new Random().nextInt(Math.min(portValue,shipValue));
        }

        private void printMessage(int quantity, String message){
            StringBuilder builder = new StringBuilder();
            builder.append(quantity);
            builder.append(message);
            builder.append(ship.getName());
            System.out.println(builder.toString());
            System.out.println(ship.toString());
            System.out.println(Port.this.toString());
        }

        private void releaseShip(){
            moorings.replace(number,ship,null);
            ship=null;
            StringBuilder builder = new StringBuilder("The mooring ");
            builder.append(number).append(" is free.");
            System.out.println(builder.toString());
            notifyAll();
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setContainersCapacity(int containersCapacity) {
        this.containersCapacity = containersCapacity;
    }

    public int getContainersQuantity() {
        return containersQuantity;
    }

    public void setContainersQuantity(int containersQuantity) {
        this.containersQuantity = containersQuantity;
    }

    public int getFreeCapacity() {
        return getContainersCapacity() - getContainersQuantity();
    }

    public boolean isFree() {
        boolean free = false;
        for (Map.Entry<Integer, Ship> mooring : moorings.entrySet()) {
            if (mooring.getValue()==null) {
                free = true;
                numberOfFreeMooring = mooring.getKey();
                break;
            }
        }
        return free;
    }

    public int getNumberOfFreeMooring() {
        return numberOfFreeMooring;
    }

    private void setMoorings(int quantity) {
        for (int i = 0; i < quantity; i++) {
            addMooring();
        }
    }

    public void addMooring() {
        int number=moorings.size()+1;
        moorings.put(number, null);
        Mooring mooring = new Mooring(number);
        new Thread(mooring).start();
        isFree=true;
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
