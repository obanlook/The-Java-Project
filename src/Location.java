import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * The Location class represents a place in the game world.
 * <p>
 * A location can contain items on the ground, non-player characters (NPCs),
 * exits to other locations, and properties such as being dark or locked.
 * </p>
 */
public abstract class Location {

    /**
     * The name of the location.
     */
    private final String name;

    /**
     * The description of the location.
     */
    private final String description;

    /**
     * The exits from this location mapped to directions.
     */
    private final Map<Direction, Location> exits = new HashMap<>();

    /**
     * The list of items currently on the ground in this location.
     */
    private final List<Item> groundItems = new ArrayList<>();

    /**
     * The list of non-player characters present in this location.
     */
    private final List<NPC> npcs = new ArrayList<>();

    /**
     * Indicates whether the location is dark.
     */
    private final boolean dark;

    /**
     * Indicates whether the location is locked.
     */
    private boolean locked;

    /**
     * Indicates whether the location has been unlocked temporarily.
     * <p>
     * A temporarily unlocked location will be re-locked automatically
     * once the player leaves it.
     * </p>
     */
    private boolean temporarilyUnlocked = false;

    /**
     * Indicates whether the location currently has a light source.
     */

    private boolean light = false;//if there is something like flashlight or candle

    /**
     * Constructs a Location with the given properties.
     *
     * @param name the name of the location
     * @param description the description of the location
     * @param locked whether the location is locked
     * @param dark whether the location is dark
     */
    public Location(String name, String description, boolean locked, boolean dark) {
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.dark = dark;
    }

    // Core actions

    /**
     * Adds an item to the ground of this location.
     *
     * @param item the item to add
     */
    public void addItem(Item item) {
        groundItems.add(item);
    }

    /**
     * Removes an item from the ground by its name.
     *
     * @param itemName the name of the item to remove
     */
    public void removeItemByName(String itemName) {
        Item target = getItemByName(itemName);
        if (target != null) {
            groundItems.remove(target);
        }
    }

    /**
     * Returns an item from the ground by its name.
     * <p>
     * Item comparison is based on item names rather than object references.
     * </p>
     *
     * @param itemName the name of the item
     * @return the matching item, or {@code null} if not found
     */
    //avoid searching by the instance's address and instead search by the name of the item(item is equal to another item if they have the same name)
    public Item getItemByName(String itemName) {
        for (Item item : groundItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Adds a non-player character to this location.
     *
     * @param npc the NPC to add
     */
    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    /**
     * Illuminates the location by enabling a light source.
     */
    public void enlighten() {
        light = true;
    }

    /**
     * Checks whether the player can see in this location.
     * <p>
     * The player can see if the location is not dark or if a light source
     * is present.
     * </p>
     *
     * @return {@code true} if the player can see, {@code false} otherwise
     */
    //player can see whether the coach is not dark or at least has a light
    public boolean canSee() {
        return (!dark || light);
    }

    /**
     * Unlocks the location.
     */
    public void unlock() {
        locked = false;
    }

    /**
     * Temporarily unlocks the location.
     * <p>
     * This method unlocks the location for a single traversal.
     * Once the player leaves the location, it will be locked again.
     * </p>
     */
    public void temporarilyUnlock() {
        temporarilyUnlocked = true;
        locked = false;
    }

    /**
     * Re-locks the location after a temporary unlock.
     * <p>
     * This is typically triggered when the player exits
     * a temporarily unlocked location.
     * </p>
     */
    public void relock() {
        locked = true;
        temporarilyUnlocked = false;
    }

    /**
     * Checks whether the location is currently temporarily unlocked.
     *
     * @return {@code true} if the location was unlocked temporarily,
     *         {@code false} otherwise
     */
    public boolean isTemporarilyUnlocked() {
        return temporarilyUnlocked;
    }

    /**
     * Sets an exit from this location in a given direction.
     *
     * @param direction the direction of the exit
     * @param location the destination location
     */
    //for connecting locations
    public void setExit(Direction direction, Location location) {
        exits.put(direction, location);
    }

    // Getters

    /**
     * Returns the name of the location.
     *
     * @return the location name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the location.
     *
     * @return the location description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the exit in a given direction.
     *
     * @param direction the direction to move
     * @return the connected location, or {@code null} if no exit exists
     */
    public Location getExit(Direction direction) {
        return exits.get(direction);
    }

    /**
     * Returns a copy of the list of items on the ground.
     *
     * @return a list of ground items
     */
    public List<Item> getGroundItems() {
        return new ArrayList<>(groundItems); // return copy
    }

    /**
     * Returns a copy of the list of characters in this location.
     *
     * @return a list of NPCs
     */
    public List<NPC> getCharacters() {
        return new ArrayList<>(npcs); // return copy
    }

    /**
     * Indicates whether the location is locked.
     *
     * @return {@code true} if the location is locked, {@code false} otherwise
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Indicates whether the location is dark.
     *
     * @return {@code true} if the location is dark, {@code false} otherwise
     */
    public boolean isDark() {
        return dark;
    }

    // Display helpers

    /**
     * Returns a formatted string listing all items on the ground.
     *
     * @return a string containing ground item names
     */
    public String showGroundItems() {
        StringBuilder ans = new StringBuilder();
        for (Item item : groundItems) {
            ans.append(item.getName()).append("\n");
        }
        return ans.toString();
    }

    /**
     * Returns a formatted string listing all characters in the location.
     *
     * @return a string containing character names
     */
    public String showCharacters() {
        StringBuilder ans = new StringBuilder();
        for (NPC npc : npcs) {
            ans.append(npc.getName()).append("\n");
        }
        return ans.toString();
    }

    /**
     * Returns a formatted string listing all exits from this location.
     *
     * @return a string containing exits and their destinations
     */
    public String showExits() {
        StringBuilder ans = new StringBuilder();
        for (Direction direction : exits.keySet()) {
            ans.append(direction.name()).append(" -> ").append(exits.get(direction).getName()).append("\n");
        }
        return ans.toString();
    }
}
