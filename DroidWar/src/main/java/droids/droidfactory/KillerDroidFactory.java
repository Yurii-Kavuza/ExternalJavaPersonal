package droids.droidfactory;

import droids.Droid;
import droids.KillerDroid;

public class KillerDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name) {
        return new KillerDroid(health, energy, damage, name);
    }
}
