package droids.droidfactory;

public class DroidMaker
{
    public static DroidFactory droidMaker(String typeOfDroid)
    {
        // (int health, int energy, int damage, String name)
        switch (typeOfDroid)
        {
            case "AthleteDroid": return new AthleteDroidFactory();
            case "DoctorDroid": return new DoctorDroidFactory();
            case "DoublePowerDroid": return new DoublePowerDroidFactory();
            case "FlightDroid": return new FlightDroidFactory();
            case "HouseworkerDroid": return new HouseworkerDroidFactory();
            case "KillerDroid": return new KillerDroidFactory();
            case "SelfHealingDroid": return new SelfHealingDroidFactory();
            default: return null;

        }
    }
}
