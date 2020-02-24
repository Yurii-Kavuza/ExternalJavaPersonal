package droids.droidfactory;

import droids.Droid;
import droids.SelfHealingDroid;

public class SelfHealingDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name)
    {
        return new SelfHealingDroid(health, energy, damage, name);
    }

    public Droid createDroid(int health, int energy, int damage, String name, double recoveryRatio)
    {
        return new SelfHealingDroid(health, energy, damage, name, recoveryRatio);
    }
}
