package ua.epam.externalJava.port.additionalInfo;

public abstract class Condition {
    private boolean isWorked=false;
    private boolean isFree=false;

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
