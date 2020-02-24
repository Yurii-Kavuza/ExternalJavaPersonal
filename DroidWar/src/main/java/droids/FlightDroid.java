package droids;

public class FlightDroid extends Droid
{
	public FlightDroid(int health, int protectiveEnergy, int damage, String name)
	{
		super(health, protectiveEnergy, damage, name);
	}

	public void fly()
	{
		System.out.println("I can fly!");
	}
}
