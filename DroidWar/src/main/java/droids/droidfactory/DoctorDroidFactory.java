package droids.droidfactory;


import droids.DoctorDroid;
import droids.Droid;

public class DoctorDroidFactory implements DroidFactory
{
    @Override
    public Droid createDroid(int health, int energy, int damage, String name)
    {
        return new DoctorDroid(health, energy, damage, name);
    }
}
