/**
 * Represents a group of multiple possible output items in a single refinement.
 * Useful for cases where refining an item results in multiple different items.
 */

import java.util.List;

public class OutputGroup extends OutputItem
{
    private List<OutputItem> groupedItems; // List of grouped output items.

    /**
     * Constructs an OutputGroup with a shared probability.
     * @param items List of items in the group.
     * @param chance Probability of obtaining this group.
     */
    public OutputGroup(List<OutputItem> items, double chance) {
        super("Group", 0, chance); // Placeholder name and ID.
        this.groupedItems = items;
    }

    /**
     * Retrieves the list of grouped items.
     * @return List of OutputItem objects.
     */
    public List<OutputItem> getGroupedItems() {
        return groupedItems;
    }

    /**
     * Converts the output group into a formatted string.
     * @return A string representation of all items in the group.
     */
    @Override
    public String toString() {
        String result = "Multiple Items (";
        for (OutputItem outputItem : groupedItems) {
            if (!(outputItem.getRounds() == 0)) {
                // Cast the outputItem to AmmoItem to access AmmoItem-specific properties.
                result += outputItem.getName() + " (" + outputItem.getRounds() + " rounds)";
            } else {
                result += (outputItem.getName());
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
