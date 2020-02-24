package droids.behavior;

public class NoProtectiveEnergy implements ProtectiveEnergyBehavior {
    int energy=0;

    @Override
    public int getProtectiveEnergy() {
        return energy;
    }

    @Override
    public void setProtectiveEnergy() {
        this.energy=0;
    }

    @Override
    public void setProtectiveEnergy(int value) {
        setProtectiveEnergy();
    }
}
