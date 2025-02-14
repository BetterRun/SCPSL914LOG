/**
 * Represents a general item in the game, including keycards, weapons, and ammo.
 * Each item has a name, ID, and optionally an image.
 */
import java.util.Map;
import java.util.HashMap;
import javafx.scene.image.Image;

public class Item
{
    private String name;
    private int id;
    private Image image; // Image representation of the item.

    /**
     * Constructs an item with an image.
     * @param name Name of the item.
     * @param id Unique identifier for the item.
     * @param imagePath Path to the image file.
     */
    public Item(String name, int id, String imagePath)
    {
        this.name=name;
        this.id=id;
        try {
            if (imagePath != null && getClass().getResourceAsStream(imagePath) != null) {
                this.image = new Image(getClass().getResourceAsStream(imagePath));
            } else {
                throw new IllegalArgumentException("Image not found: " + imagePath);
            }
        } catch (Exception e) {
            System.err.println("Failed to load image for item: " + name + ". " + e.getMessage());
            this.image = null; // Image set to null if not found.
        }
    }

    /**
     * Constructs an item without an image.
     * @param name Name of the item.
     * @param id Unique identifier for the item.
     */
    public Item(String name, int id)
    {
        this.name=name;
        this.id=id;
        this.image = null;
    }

    public String getName() { return name; }
    public int getId()
    {
        return id;
    }
    public Image getImage() { return image; }

    /**
     * Returns a formatted name for ammo items.
     */
    @Override
    public String toString() {
        if (this instanceof AmmoItem) {
            // Cast to subclass to access its specific fields or methods
            AmmoItem ammoItemInstance = (AmmoItem) this;
            return name + ammoItemInstance.getRounds();
        }
        // Default behavior for the base class
        return name;
    }
    
    public static Item KEYCARD_JANITOR = new Item("Janitor Keycard", 0, "janitor.png");
    public static Item KEYCARD_SCIENTIST = new Item("Scientist Keycard", 1, "scientist.png");
    public static Item KEYCARD_RESEARCH_SUPERVISOR = new Item("Research Supervisor Keycard", 2, "supervisor.png");
    public static Item KEYCARD_ZONE_MANAGER = new Item("Zone Manager Keycard", 3, "zone manager.png");
    public static Item KEYCARD_GUARD = new Item("Guard Keycard", 4, "guard.png");
    public static Item KEYCARD_MTF_PRIVATE = new Item("Private Keycard", 5, "private.png");
    public static Item KEYCARD_CONTAINMENT_ENGINEER = new Item("Containment Engineer Keycard", 6, "engineer.png");
    public static Item KEYCARD_MTF_OPERATIVE = new Item("Operative Keycard", 7, "operative.png");
    public static Item KEYCARD_MTF_CAPTAIN = new Item("Captain Keycard", 8, "captain.png");
    public static Item KEYCARD_FACILITY_MANAGER = new Item("Facility Manager Keycard", 9, "facility manager.png");
    public static Item KEYCARD_CHAOS_INSURGENCY = new Item("CI Access Device", 10, "ci.png");
    public static Item KEYCARD_O5 = new Item("O5 Keycard", 11, "o5.png");
    public static Item RADIO = new Item("Radio", 12, "radio.png");
    public static Item GUN_COM15 = new Item("Compact Object Modifier-15 (COM-15)", 13, "foundationlogo.png");
    public static Item MEDKIT = new Item("First Aid Kit", 14, "medkit.png");
    public static Item FLASHLIGHT = new Item("Flashlight", 15, "flashlight.png");
    public static Item MICRO_HID = new Item("Micro H.I.D.", 16, "micro.png");
    public static Item SCP_500 = new Item("SCP-500", 17, "500.png");
    public static Item SCP_207 = new Item("SCP-207", 18, "207.png");
    public static Item AMMO_12GAUGE = new AmmoItem("Spatial Pulse Emitters (SPE-12)", 19, "chaoslogo.png");
    public static Item GUN_E11_SR = new Item("Mobile Task Force Epsilon-11 Subatomic Resonator (MTF-E11-SR)", 20, "foundationlogo.png");
    public static Item GUN_CROSSVEC = new Item("Cross-Vector Analyzer (Crossvec)", 21, "foundationlogo.png");
    public static Item AMMO_556x45 = new AmmoItem("Stabilizer Resonance Beacons (SRB-556)",22, "foundationlogo.png");
    public static Item GUN_FSP9 = new Item("Field Stabilization Probe-9 (FSP-9)", 23, "foundationlogo.png");
    public static Item GUN_LOGICER = new Item("Logical Matrix Stabilizer (Logicer)", 24, "chaoslogo.png");
    public static Item GRENADE_HE = new Item("High-Explosive Grenade", 25, "grenadehe.png");
    public static Item GRENADE_FLASH = new Item("Flashbang Grenade", 26, "grenadeflash.png");
    public static Item AMMO_44CAL = new AmmoItem("Resonance Amplifier Capsules (RAC-44)", 27, "chaoslogo.png");
    public static Item AMMO_762x39 = new AmmoItem("Kinetic Resonance Capsules (KRC-762)", 28, "chaoslogo.png");
    public static Item AMMO_9x19 = new AmmoItem("Micro Energy Modules (MEM-919)", 29, "foundationlogo.png");
    public static Item GUN_COM18 = new Item("Compact Object Modifier-18 (COM-18)", 30, "foundationlogo.png");
    public static Item SCP_018 = new Item("SCP-018", 31, "018.png");
    public static Item SCP_268 = new Item("SCP-268", 32, "268.png");
    public static Item ADRENALINE = new Item("Adrenaline", 33, "adrenaline.png");
    public static Item PAINKILLERS = new Item("Painkillers", 34, "painkillers.png");
    public static Item COIN = new Item("Coin", 35, "coin.png");
    public static Item ARMOR_LIGHT = new Item("Light Armor", 36, "light.png");
    public static Item ARMOR_COMBAT = new Item("Combat Armor", 37, "combat.png");
    public static Item ARMOR_HEAVY = new Item("Heavy Armor ", 38, "heavy.png");
    public static Item GUN_REVOLVER = new Item("Revolving Vector Locator for Vertex Resonance (RVLVR-44)", 39, "chaoslogo.png");
    public static Item GUN_AK = new Item("Anomaly Kinetograph (AK)", 40, "chaoslogo.png");
    public static Item GUN_SHOTGUN = new Item("Spatial Generator (SG-12)", 41, "chaoslogo.png");
    public static Item SCP_330 = new Item("SCP-330", 42, "330.png");
    public static Item SCP_2176 = new Item("SCP-2176", 43, "2176.png");
    public static Item SCP_244A = new Item("SCP-244-A", 44, "244a.png");
    public static Item SCP_244B = new Item("SCP-244-B", 45, "244b.png");
    public static Item SCP_1853 = new Item("SCP-1853", 46, "1853.png");
    public static Item PARTICLE_DISRUPTOR = new Item("3-X Particle Disruptor", 47, "foundationlogo.png");
    public static Item GUN_COM45 = new Item("Compact Object Modifier-45 (COM-45)", 48, "foundationlogo.png");
    public static Item SCP_1576 = new Item("SCP-1576", 49, "1576.png");
    public static Item JAILBIRD = new Item("Jailbird", 50, "jailbird.png");
    public static Item ANTI_SCP_207 = new Item("SCP-207?", 51, "anti207.png");
    public static Item GUN_FRMG0 = new Item("Facility Recovery Molecular Generator-0 (FR-MG-0)", 52, "foundationlogo.png");
    public static Item GUN_A7 = new Item("Anomaly Kinetograph Prototype (A7)", 53, "chaoslogo.png");
    public static Item LANTERN = new Item("Lantern", 54, "lantern.png");
    
    public static Item[] getAllItems() {
        return new Item[]{
                    KEYCARD_JANITOR, KEYCARD_SCIENTIST, KEYCARD_RESEARCH_SUPERVISOR,
                    KEYCARD_GUARD, KEYCARD_MTF_OPERATIVE, KEYCARD_MTF_CAPTAIN,
                    KEYCARD_ZONE_MANAGER, KEYCARD_FACILITY_MANAGER, KEYCARD_CHAOS_INSURGENCY, KEYCARD_O5,
                    GUN_COM15, GUN_COM18, GUN_COM45, GUN_FSP9, GUN_CROSSVEC, GUN_E11_SR, GUN_FRMG0,
                    GUN_AK, GUN_A7, GUN_REVOLVER, GUN_SHOTGUN,  GUN_LOGICER, GRENADE_HE, GRENADE_FLASH,
                    PARTICLE_DISRUPTOR, JAILBIRD, MICRO_HID,
                    AMMO_9x19, AMMO_556x45, AMMO_762x39, AMMO_12GAUGE, AMMO_44CAL,
                    PAINKILLERS, MEDKIT, ADRENALINE,
                    SCP_018, SCP_207, ANTI_SCP_207, SCP_244A, SCP_244B, SCP_268, SCP_330, SCP_500, SCP_1576, SCP_1853, SCP_2176, 
                    ARMOR_LIGHT, ARMOR_COMBAT, ARMOR_HEAVY, COIN, FLASHLIGHT, RADIO, 
                    KEYCARD_CONTAINMENT_ENGINEER,  KEYCARD_MTF_PRIVATE, LANTERN,
        };
    }
    private static Map<String, Item> itemMap;
    static {
        itemMap = new HashMap<>();
        for (Item item : getAllItems()) {
            itemMap.put(item.getName().toLowerCase(), item);
            itemMap.put(String.valueOf(item.getId()), item);
        }
    }
    public static Item getItem(String input) {
        return itemMap.get(input.toLowerCase());
    }
}
