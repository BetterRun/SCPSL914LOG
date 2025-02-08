
/**
 * Write a description of class OutputItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class OutputItem extends Item
{
    // instance variables - replace the example below with your own
    private double chance;
    private int rounds;

    /**
     * Constructor for objects of class OutputItem
     */
    public OutputItem(String name, int id, String imagePath, double chance)
    {
        // initialise instance variables
        super(name, id, imagePath);
        this.chance = chance;
    }
    
    OutputItem(String name, int id, double chance)
    {
        // initialise instance variables
        super(name, id);
        this.chance = chance;
    }
    
    OutputItem(Item item, double chance)
    {
        // initialise instance variables
        super(item.getName(), item.getId());
        this.chance = chance;
    }
    
    OutputItem(Item ammoItem, double chance, int rounds)
    {
        // initialise instance variables
        super(ammoItem.getName(), ammoItem.getId());
        this.chance = chance;
        this.rounds = rounds;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double getChance()
    {
        // put your code here
        return chance;
    }
    
    public void setChance(double chance)
    {
        this.chance = chance;
    }
    
    public int getRounds() {
        return rounds;    
    }
    
    @Override
    public String toString()
    {
        double percentage = chance * 100;
        return super.getName() + " (" + String.format("%.2f", percentage) + "%)";
    }
    
    public static OutputItem DESTROYED = new OutputItem("Destroyed", 55, 1.0);
    public static OutputItem RANDOMATTACHMENTS = new OutputItem("Randomized Attachments", 56, 1.0);
    public static OutputItem REFUELED_MICRO_HID = new OutputItem("Micro HID (Refueled)", 16, 1.0);
    public static OutputItem REFUELED_PARTICLE_DISRUPTOR = new OutputItem("3-X Particle Disruptor (Refueled)", 47, 1.0);
    public static OutputItem REFUELED_JAILBIRD = new OutputItem("Jailbird (Refueled)", 50, 1.0);
    public static OutputItem DAMAGED_JAILBIRD = new OutputItem("Jailbird (Heavily damaged)", 50, 1.0);
    public static OutputItem RECHARGED_RADIO = new OutputItem("Radio (Recharged)", 12, 1.0);
    public static OutputItem SCP_2176_ACTIVATION = new OutputItem("SCP-2176 activates", 57, 1.0);
    public static OutputItem GRENADE_HE_X2 = new OutputItem ("High-Explosive Grenade (x2)", 25, 1.0);
    public static OutputItem COINS = new OutputItem("Coin (x12)", 35, 1.0);
    public static OutputItem CANNOT_BE_REFINED = new OutputItem("Cannot be refined, remains in input", 58, 1.0);
}
