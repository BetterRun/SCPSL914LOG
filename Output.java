
/**
 * Write a description of class Outputs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Output
{
    // instance variables - replace the example below with your own
    private Item inputItem;
    private RefineSetting setting;
    private List<OutputItem> possibleOutputs;

    /**
     * Constructor for objects of class Outputs
     */
    public Output(Item inputItem, RefineSetting setting, List<OutputItem> possibleOutputs)
    {
        // initialise instance variables
        this.inputItem = inputItem;
        this.setting = setting;
        this.possibleOutputs = possibleOutputs;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Item getInputItem()
    {
        // put your code here
        return inputItem;
    }
    
    public RefineSetting getSetting()
    {
        // put your code here
        return setting;
    }
    
    public String getFormula()
    {
        // put your code here
        return "Input: " + inputItem.getName() + " (setting: " + setting;
    }
    
    public static String getFormula(Item inputItem, RefineSetting setting)
    {
        // put your code here
        return "Input: " + inputItem.getName() + " (setting: " + setting;
    }
    
    public List<OutputItem>  getPossibleOutputs()
    {
        return possibleOutputs;
    }
        
    public String getOutputItems()
    {
        // put your code here
        String outputItemsString = "";
        for (OutputItem outputItem : possibleOutputs) {
            if (!(outputItem.getRounds() == 0)) {
                // Cast the outputItem to AmmoItem to access AmmoItem-specific properties.
                outputItemsString += outputItem.getName() + " (" + outputItem.getRounds() + " rounds)" +
                " (" + outputItem.getChance() * 100 + "%)";       
            } else {
                outputItemsString += outputItem;
            }
            //lmao
            if (!(possibleOutputs.indexOf(outputItem) == possibleOutputs.size() - 1)) {
                outputItemsString += ", "; //yeah
            }
        }
        return ")\nOutput: " + outputItemsString + "\n";
    }
    
    @Override
    public String toString() {
        String toString = "";
        if (inputItem instanceof AmmoItem) {
            toString += "Input: " + inputItem.toString() + " (setting: " + setting;
        } else {
            toString += getFormula();
        }
        toString += getOutputItems();
        return toString;
    }
}