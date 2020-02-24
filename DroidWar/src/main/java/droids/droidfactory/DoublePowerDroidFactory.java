package droids.droidfactory;

import droids.DoublePowerDroid;
import droids.Droid;

public class DoublePowerDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name)
    {
        return new DoublePowerDroid(health, energy, damage, name);
    }
}
