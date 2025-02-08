/**
 * Write a description of class RefineSettings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Map;
import java.util.HashMap;

public class RefineSetting
{
    private String name;
    
    public RefineSetting(String name)
    {
        // initialise instance variables
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
    // instance variables - replace the example below with your own
    public static final RefineSetting ROUGH = new RefineSetting("Rough");
    public static final RefineSetting COARSE = new RefineSetting("Coarse");
    public static final RefineSetting ONE_TO_ONE = new RefineSetting("1:1");
    public static final RefineSetting FINE = new RefineSetting("Fine");
    public static final RefineSetting VERY_FINE = new RefineSetting("Very Fine");
    
    public static RefineSetting[] getSettings() {
        return new RefineSetting[]{
            ROUGH, COARSE, ONE_TO_ONE, FINE, VERY_FINE
        };
    }
    private static Map<String, RefineSetting> settingMap;
    static {
        settingMap = new HashMap<>();
        for (RefineSetting setting : getSettings()) {
            settingMap.put(setting.getName().toLowerCase(), setting);
        }
    }
    public static RefineSetting getSetting(String input) {
        return settingMap.get(input.toLowerCase());
    }
}
