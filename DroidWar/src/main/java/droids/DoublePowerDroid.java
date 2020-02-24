package droids;

public class DoublePowerDroid extends AthleteDroid{
    public DoublePowerDroid(int health, int protectiveEnergy, int damage, String name) {
        super(health, protectiveEnergy, damage, name);
        super.setMultiplyPower(2);
    }
}
