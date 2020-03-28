package ua.epam.externalJava.port.ships;

public class Ship {
    private String name;
    private int containersCapacity;
    private int containersQuantity;

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
        this.containersCapacity = Math.max(containersCapacity, 0);
    }

    public int getContainersQuantity() {
        return containersQuantity;
    }

    public void setContainersQuantity(int containersQuantity) {
        this.containersQuantity = containersQuantity;
    }
}
