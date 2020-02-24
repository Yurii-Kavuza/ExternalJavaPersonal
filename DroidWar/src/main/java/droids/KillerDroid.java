package droids;

public class KillerDroid extends Droid
{
	// extra damage to kill another droid
	int extraDamage;

	public KillerDroid(int health, int protectiveEnergy, int damage, String name)
	{
		super(health, protectiveEnergy, damage, name);
	}

	public void killEnemy(Droid enemy)
	{
		extraDamage += enemy.getHealth();
		this.damageBehavior.setDamage(this.damageBehavior.getDamage() + extraDamage);

		enemy.setHealth(0);
		this.damageBehavior.setDamage(this.damageBehavior.getDamage() - enemy.getHealth());
	}

	public int getExtraDamage()
	{
		return extraDamage;
	}
}
