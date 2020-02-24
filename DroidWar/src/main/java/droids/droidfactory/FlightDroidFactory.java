package droids.droidfactory;

import droids.Droid;
import droids.FlightDroid;

public class FlightDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name)
    {
        return new FlightDroid(health, energy, damage, name);
    }
}
