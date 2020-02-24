package droids;

import droids.behavior.DamageBehavior;
import droids.behavior.ProtectiveEnergyBehavior;

public abstract class Droid {
    private int MAX_VALUE=100;
    private String name;
    private int health;
    DamageBehavior damageBehavior;
    ProtectiveEnergyBehavior protectiveEnergyBehavior;

    private boolean alive = true;
    private String resultAfterFight;

    public Droid() {
    }

    public Droid(Droid droid) {
        this.name = droid.getName();
        this.health = droid.getHealth();
        this.protectiveEnergyBehavior = droid.protectiveEnergyBehavior;
        this.damageBehavior = droid.damageBehavior;
        this.alive = true;
        droid=null;
    }

    public Droid(int health, int protectiveEnergy, int damage, String name) {
        if((health + protectiveEnergy + damage)>MAX_VALUE || ((health + protectiveEnergy + damage)<1 && health<1)) {
            this.setHealth(0);
            this.protectiveEnergyBehavior.setProtectiveEnergy(0);
            this.damageBehavior.setDamage(damage);
            this.alive =false;
            this.name="Broken droid";
            System.out.println("Pay attention! Sum of health's, protectiveEnergy's and damage's points must be " + MAX_VALUE +
                    ". You have created broken droid and it can not fight because it is not alive.");
        }else if(protectiveEnergy<1 && damage<1){
            this.health = health;
            this.protectiveEnergyBehavior.setProtectiveEnergy(protectiveEnergy);
            this.damageBehavior.setDamage(damage);
            this.name=name;
            System.out.println("Pay attention! You have created droid that can not fight and protect itself.");
        }else if(protectiveEnergy<1){
            this.health = health;
            this.protectiveEnergyBehavior.setProtectiveEnergy(protectiveEnergy);
            this.damageBehavior.setDamage(damage);
            this.name=name;
            System.out.println("Pay attention! You have created droid that can not protect itself.");
        }else if(damage<1){
            this.health = health;
            this.protectiveEnergyBehavior.setProtectiveEnergy(protectiveEnergy);
            this.damageBehavior.setDamage(damage);
            this.name=name;
            System.out.println("Pay attention! You have created droid that can not fight.");
        }else{
            this.health = health;
            this.protectiveEnergyBehavior.setProtectiveEnergy(protectiveEnergy);
            this.damageBehavior.setDamage(damage);
            this.name=name;
        }
    }

    public void setDamageBehavior(DamageBehavior damageBehavior) {
        this.damageBehavior = damageBehavior;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int performEnergy(){
        return protectiveEnergyBehavior.getProtectiveEnergy();
    }

    public void modifyEnergy(int value){
        protectiveEnergyBehavior.setProtectiveEnergy(value);
    }

    public void modifyEnergy(){
        protectiveEnergyBehavior.setProtectiveEnergy();
    }

    public int performDamage(){
        return damageBehavior.getDamage();
    }

    public void modifyDamage(int value){
        damageBehavior.setDamage(value);
    }

    public void modifyDamage(){
        damageBehavior.setDamage();
    }

    public boolean getAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getResultAfterFight() {
        return resultAfterFight;
    }

    public void setResultAfterFight(String resultAfterFight) {
        this.resultAfterFight = resultAfterFight;
    }

    public int attempts (Droid droid){
        int attempt=0;
        int delta;
        boolean haveHealth=true;

        if (this.damageBehavior.getDamage()>=droid.protectiveEnergyBehavior.getProtectiveEnergy()){
            delta=(this.damageBehavior.getDamage()-droid.protectiveEnergyBehavior.getProtectiveEnergy())*2+1;
        }else {
            delta=(droid.protectiveEnergyBehavior.getProtectiveEnergy()-this.damageBehavior.getDamage())/2;
        }
        while(haveHealth){
            droid.setHealth(droid.getHealth()-delta);
            if (droid.getHealth()<=0){
                attempt++;
                haveHealth=false;
            }else {
                attempt++;
            }
        }
        return attempt;
    }

    public void fight(Droid droid){
        int healthDroidFirstBefore=this.getHealth();
        int healthDroidSecondBefore=droid.getHealth();

        if (this.attempts(droid)>droid.attempts(this)){
            this.setHealth(healthDroidFirstBefore);
            droid.setAlive(false);
            this.setResultAfterFight("" + this.getName() + " " + this.getClass().getSimpleName() + " has won " +
                    "fight against " + droid.getName() + " " + droid.getClass().getSimpleName() + " making " +
                    this.attempts(droid) + " attempts.");
        }else if(this.attempts(droid)<droid.attempts(this)){
            droid.setHealth(healthDroidFirstBefore);
            this.setAlive(false);
            droid.setResultAfterFight("" + droid.getName() + " " + droid.getClass().getSimpleName() + " has won " +
                    "fight against " + this.getName() + " " + this.getClass().getSimpleName() + " making " +
                    droid.attempts(this) + " attempts.");
        }else {
            this.setHealth(healthDroidFirstBefore);
            droid.setHealth(healthDroidFirstBefore);
            this.setResultAfterFight("Nobody has won in fight between " + this.getName() + " "
                    + this.getClass().getSimpleName() + " and " + droid.getName() + " " +
                    droid.getClass().getSimpleName());
            droid.setResultAfterFight("Nobody has won in fight between " + droid.getName() + " "
                    + droid.getClass().getSimpleName() + " and " + this.getName() + " " +
                    this.getClass().getSimpleName());
        }
    }

    @Override
    public String toString() {
        return "" + this.getClass().getSimpleName() +
                " name is " + name +
                ", health=" + health +
                ", energy=" + protectiveEnergyBehavior.getProtectiveEnergy() +
                ", damage=" + damageBehavior.getDamage();
    }
}
