/**
 * Represents different refinement settings that determine item upgrade outcomes.
 */
import java.util.Map;
import java.util.HashMap;

public class RefineSetting
{
    private String name; // Name of the refinement setting.

    /**
     * Creates a refinement setting with a given name.
     * @param name The name of the setting.
     */
    public RefineSetting(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        // put your code here
        return name;
    }
    @Override
    public String toString() {
        return name;
    }

    // Predefined refinement settings available in the game.
    public static final RefineSetting ROUGH = new RefineSetting("Rough");
    public static final RefineSetting COARSE = new RefineSetting("Coarse");
    public static final RefineSetting ONE_TO_ONE = new RefineSetting("1:1");
    public static final RefineSetting FINE = new RefineSetting("Fine");
    public static final RefineSetting VERY_FINE = new RefineSetting("Very Fine");

    /**
     * Retrieves an array of all available refinement settings.
     * @return Array of refinement settings.
     */
    public static RefineSetting[] getSettings() {
        return new RefineSetting[]{
            ROUGH, COARSE, ONE_TO_ONE, FINE, VERY_FINE
        };
    }

    // Maps setting names to RefineSetting objects for easy retrieval.
    private static Map<String, RefineSetting> settingMap;
    static {
        settingMap = new HashMap<>();
        for (RefineSetting setting : getSettings()) {
            settingMap.put(setting.getName().toLowerCase(), setting);
        }
    }

    /**
     * Retrieves a refinement setting by name.
     * @param input The name of the setting.
     * @return The corresponding RefineSetting object, or null if not found.
     */
    public static RefineSetting getSetting(String input) {
        return settingMap.get(input.toLowerCase());
    }
}
