/**
 * The Item class represents an abstract item in the game.
 * <p>
 * Items can be collected, carried in the inventory, and used by the player
 * to interact with the game world.
 * </p>
 */
public abstract class Item {

    /**
     * The name of the item.
     */
    private final String name;

    /**
     * A description of the item.
     */
    private final String description;

    /**
     * Constructs an Item with a name and description.
     *
     * @param name the name of the item
     * @param description a textual description of the item
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Uses the item.
     * <p>
     * The effect of using the item depends on the specific item type
     * and is implemented by subclasses.
     * </p>
     *
     * @param player the player using the item
     * @return {@code true} if the item had an effect,
     *         {@code false} otherwise
     */
    //abstract method(s)
    public abstract boolean use(Player player);

    /**
     * Returns the name of the item.
     *
     * @return the item's name
     */
    // Getters
    public String getName() {
        return name;
    }

    /**
     * Returns the string representation of the item.
     *
     * @return the item name
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Returns the description of the item.
     *
     * @return the item's description
     */
    public String getDescription() {
        return description;
    }
}
