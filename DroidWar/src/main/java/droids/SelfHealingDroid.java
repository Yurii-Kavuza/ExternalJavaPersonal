package droids;


import droids.behavior.Repairable;

public class SelfHealingDroid extends Droid implements Repairable {
    private double recoveryRatio;

    public SelfHealingDroid(int health, int protectiveEnergy, int damage, String name, double recoveryRatio) {
        super((int) (health * recoveryRatio),protectiveEnergy, damage,name);
        this.recoveryRatio = recoveryRatio;
    }

    public SelfHealingDroid(int health, int protectiveEnergy, int damage, String name)
    {
        super(health, protectiveEnergy, damage, name);
        this.recoveryRatio = 1;
    }

    public double getRecoveryRatio() {
        return recoveryRatio;
    }

    public void setRecoveryRatio(double recoveryRatio) {
        this.recoveryRatio = recoveryRatio;
    }

    public String toString() {
        return super.toString() + ", recoveryRatio=" + recoveryRatio;
    }
}
