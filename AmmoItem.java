import javafx.scene.image.Image;

/**
 * Write a description of class AmmoItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AmmoItem extends Item
{
    // instance variables - replace the example below with your own
    private int ammoCount;

    /**
     * Constructor for objects of class AmmoItem
     */
    public AmmoItem(String name, int id, String imagePath)
    {
        // initialise instance variables
        super(name, id, imagePath);
        this.ammoCount = 15;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    @Override
    public String getName() {
        return "box of " + super.getName();
    }

    public int getRoundsInt() {
        return ammoCount;
    }
    
    public String getRounds()
    {
        return "(" + ammoCount + " cartridges)";
    }    
    
    public void setRounds(int ammoCount) {
        this.ammoCount = ammoCount;
    }
    
    @Override
    public String toString()
    {
        return super.getName() + " " + getRounds();
    }
}