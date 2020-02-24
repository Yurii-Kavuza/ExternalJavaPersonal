package droids.behavior;

public class ProtectiveEnergyUsual implements ProtectiveEnergyBehavior {
    int energy=30;

    public ProtectiveEnergyUsual() {
    }

    public ProtectiveEnergyUsual(int energy) {
        this.energy = energy;
    }

    @Override
    public int getProtectiveEnergy() {
        return energy;
    }

    @Override
    public void setProtectiveEnergy() {
        this.energy=30;
    }

    @Override
    public void setProtectiveEnergy(int value) {
        this.energy=value;
    }
}
