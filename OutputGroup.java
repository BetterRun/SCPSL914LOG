
/**
 * Write a description of class OutputGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.List;

public class OutputGroup extends OutputItem
{
    private List<OutputItem> groupedItems;

    // Constructor for multiple items with a shared chance
    public OutputGroup(List<OutputItem> items, double chance) {
        super("Group", 0, chance); // Use a placeholder name and ID
        this.groupedItems = items;
    }

    public List<OutputItem> getGroupedItems() {
        return groupedItems;
    }

    @Override
    public String toString() {
        String result = "Multiple Items (";
        for (OutputItem outputItem : groupedItems) {
            if (!(outputItem.getRounds() == 0)) {
                // Cast the outputItem to AmmoItem to access AmmoItem-specific properties.
                result += outputItem.getName() + " (" + outputItem.getRounds() + " rounds)";       
            } else {
                result += (outputItem.toString());
            }
            if (!(groupedItems.indexOf(outputItem) == groupedItems.size() - 1)) {
                result += ", ";
            }
        }
        double percentage = super.getChance() * 100;
        result += ") (" + String.format("%.2f", percentage) + "%)";
        return result;
    }
}
