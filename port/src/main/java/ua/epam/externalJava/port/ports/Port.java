package ua.epam.externalJava.port.ports;

import java.util.HashMap;

public class Port {
    private String name;
    private int containersCapacity;
    private int containersQuantity;
    private boolean isWorked=false;
    private boolean isFree=false;
    private HashMap<String,Mooring> moorings = new HashMap<>();

    public Port() {
    }

    public Port( String name,boolean isWorked) {
        this.name = name;
        this.isWorked = isWorked;
    }

    class Mooring {
        private MooringInfo mooringInfo = new MooringInfo();
        private MooringCondition mooringCondition = new MooringCondition();

        public Mooring() {
        }

        public Mooring(String name, int containersCapacity,boolean isWorked) {
            if (!isExisted(name)) {
                mooringInfo.setName(name);
                mooringInfo.setContainersCapacity(containersCapacity);
                mooringCondition.setWorked(isWorked);
                if (isWorked) mooringCondition.setFree(true);
            } else {
                StringBuilder str = new StringBuilder("The mooring with name ").
                        append(name).append(" already exist.");
                System.out.println(str.toString());
            }

        }

        private boolean isExisted(String name) {
            return moorings.containsKey(name);
        }

        public MooringCondition getMooringCondition() {
            return mooringCondition;
        }

        public MooringInfo getMooringInfo() {
            return mooringInfo;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Mooring ");
            builder.append(mooringInfo.getName());
            builder.append(" can contain ");
            builder.append(mooringInfo.getContainersCapacity());
            builder.append(". Now it contains ");
            builder.append(mooringInfo.getContainersQuantity());
            builder.append(" containers");
            return builder.toString();
        }
    }

    public HashMap<String, Mooring> getMoorings() {
        return moorings;
    }

    public void addMoorings(Mooring mooring) {
        moorings.put(mooring.getMooringInfo().getName(), mooring);
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
}
