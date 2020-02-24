package droids;


import droids.behavior.NoDamage;
import droids.behavior.NoProtectiveEnergy;

public class HouseworkerDroid extends Droid {
    private String responsibility;

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public HouseworkerDroid(int health, int protectiveEnergy, int damage, String name, String responsibility) {
        damageBehavior = new NoDamage();
        protectiveEnergyBehavior = new NoProtectiveEnergy();
        this.setHealth(health);
        this.setName(name);
        this.damageBehavior.setDamage(damage);
        this.protectiveEnergyBehavior.setProtectiveEnergy(protectiveEnergy);
        this.responsibility = responsibility;
    }

    public HouseworkerDroid(int health, int protectiveEnergy, int damage, String name) {
        this(health, protectiveEnergy, damage, name, "undefined");
    }

    @Override
    public String toString() {
        return super.toString() + ", responsibility is " + responsibility;
    }
}
