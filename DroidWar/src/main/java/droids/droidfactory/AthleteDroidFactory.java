package droids.droidfactory;


import droids.Droid;
import droids.AthleteDroid;

public class AthleteDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name)
    {
        return new AthleteDroid(health, energy, damage, name);
    }

    public Droid createDroid(int health, int energy, int damage, String name, double multiplyPower)
    {
        return new AthleteDroid(health, energy, damage, name, multiplyPower);
    }
}
