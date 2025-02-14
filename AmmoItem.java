/**
 * Represents an ammo item that extends the generic Item class.
 * Ammo items contain a count of available rounds and display their name accordingly.
 */
public class AmmoItem extends Item {
    private int ammoCount; // Stores the number of rounds in this ammo item.

    /**
     * Constructs an AmmoItem with a default round count.
     * @param name Name of the ammo item.
     * @param id Unique identifier for the ammo item.
     * @param imagePath Path to the item's image.
     */
    public AmmoItem(String name, int id, String imagePath) {
        super(name, id, imagePath);
        this.ammoCount = 15; // Default ammo count.
    }

    /**
     * Overrides getName to display as "box of [Ammo Type]".
     * @return Formatted ammo item name.
     */
    @Override
    public String getName() {
        return "box of " + super.getName();
    }

    /**
     * Retrieves the number of rounds in this ammo item.
     * @return The ammo count.
     */
    public int getRoundsInt() {
        return ammoCount;
    }

    /**
     * Returns the number of rounds as a formatted string.
     * @return String representation of the ammo count.
     */
    public String getRounds() {
        return "(" + ammoCount + " cartridges)";
    }

    /**
     * Sets a new round count for the ammo item.
     * @param ammoCount New amount of rounds.
     */
    public void setRounds(int ammoCount) {
        this.ammoCount = ammoCount;
    }

    /**
     * Converts the AmmoItem into a string for display.
     * @return A formatted string with item name and round count.
     */
    @Override
    public String toString() {
        return super.getName() + " " + getRounds();
    }
}
