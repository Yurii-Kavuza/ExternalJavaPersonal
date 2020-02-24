package droids;


import droids.behavior.DamageWithoutWeapon;
import droids.behavior.ProtectiveEnergyUsual;

public class AthleteDroid extends Droid{
    private double multiplyPower;

    public AthleteDroid(int health, int protectiveEnergy, int damage, String name, double multiplyPower) {
        damageBehavior = new DamageWithoutWeapon(damage);
        protectiveEnergyBehavior = new ProtectiveEnergyUsual(protectiveEnergy);
        this.setHealth(health);
        this.setName(name);
        if(multiplyPower>1){
            this.damageBehavior.setDamage((int)(this.damageBehavior.getDamage()*multiplyPower));
            this.multiplyPower=multiplyPower;
        }else {
            this.damageBehavior.setDamage((int)(this.damageBehavior.getDamage()*1));
            this.multiplyPower=multiplyPower;
        }
    }

    public AthleteDroid(int health, int prootectiveEnergy, int damage, String name) {
        this(health, prootectiveEnergy, damage, name, 1.0);
    }

    public double getMultiplyPower() {
        return multiplyPower;
    }

    public void setMultiplyPower(double multiplyPower) {
        this.multiplyPower = multiplyPower;
    }

    @Override
    public String toString() {
        return super.toString() + ", multiplyPower = " + multiplyPower;
    }
}
