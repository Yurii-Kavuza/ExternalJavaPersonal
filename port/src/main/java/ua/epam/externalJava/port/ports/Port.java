package ua.epam.externalJava.port.ports;

import java.util.HashMap;

public class Port {
    private String name;
    private int containersCapacity;
    private int containersQuantity;
    private boolean isWorked;
    private boolean isFree;
    private HashMap<Integer,Mooring> moorings = new HashMap<>();

    public Port() {
    }

    public Port( String name, int containersCapacity) {
        this.name = name;
        this.containersCapacity = containersCapacity;
    }

    class Mooring {
        private int number;
        private boolean isWorked;
        private boolean isFree;


        public Mooring() {
            setNumber(getMooringsQuantity()+1);
            setWorked(true);
            setFree(true);
        }

        private int getMooringsQuantity(){
            return moorings.size();
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public boolean isWorked() {
            return isWorked;
        }

        public void setWorked(boolean worked) {
            isWorked = worked;
        }

        public boolean isFree() {
            return isFree;
        }

        public void setFree(boolean free) {
            isFree = free;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Mooring ");
            builder.append(getNumber());
            if(isWorked()){
                builder.append(" is working now. ");
                if (isFree()){
                    builder.append("It is free now.");
                }else {
                    builder.append("But it is busy now.");
                }
            }else {
                builder.append(" is not working now.");
            }
            return builder.toString();
        }
    }

    public HashMap<Integer, Mooring> getMoorings() {
        return moorings;
    }

    public void addMoorings(Mooring mooring) {
        moorings.put(mooring.getNumber(), mooring);
        this.setWorked(true);
        this.setFree(true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isWorked() {
        return isWorked;
    }

    public void setWorked(boolean worked) {
        isWorked = worked;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "Port{" +
                "name='" + name + '\'' +
                ", containersCapacity=" + containersCapacity +
                ", containersQuantity=" + containersQuantity +
                ", isWorked=" + isWorked +
                ", isFree=" + isFree +
                ", moorings=" + moorings +
                '}';
    }
}
