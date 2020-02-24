package droids.droidfactory;


import droids.Droid;

public interface DroidFactory
{
    Droid createDroid(int health, int energy, int damage, String name);
}
