import java.util.ArrayList;
import java.util.List;

/**
 * The Character class represents a non-player character (NPC) in the game.
 * <p>
 * Characters can speak, be examined, hold items, know languages, and optionally
 * trade items with the player. This class serves as a base class for all
 * specific character types.
 * </p>
 */
public abstract class Character {

    /**
     * The name of the character.
     */
    private final String name;

    /**
     * Indicates whether the character is allowed to trade items.
     */
    private final boolean canTrade;

    /**
     * The list of languages the character can speak.
     */
    private List<Language> languages = new ArrayList<>();

    /**
     * The list of items currently held by the character.
     */
    private final List<Item> heldItems = new ArrayList<>();

    /**
     * Constructs a Character with a name and trade capability.
     *
     * @param name the name of the character
     * @param canTrade whether the character is allowed to trade items
     */
    public Character(String name, boolean canTrade) {
        this.name = name;
        this.canTrade = canTrade;
    }

    /**
     * Defines how the character talks to the player.
     * This behavior must be implemented by subclasses.
     *
     * @param player the player interacting with the character
     * @return a dialogue string spoken by the character
     */
    public abstract String talk(Player player);

    /**
     * Defines how the character reacts when examined by the player.
     * This behavior must be implemented by subclasses.
     *
     * @param player the player examining the character
     * @return a description or response shown to the player
     */
    public abstract String examine(Player player);

    /**
     * Returns the name of the character.
     *
     * @return the character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Checks whether the character can speak a given language.
     *
     * @param lang the language to check
     * @return {@code true} if the character can speak the language,
     *         {@code false} otherwise
     */
    public boolean canSpeak(Language lang) {
        return languages.contains(lang);
    }

    /**
     * Indicates whether the character is allowed to trade items.
     *
     * @return {@code true} if the character can trade, {@code false} otherwise
     */
    public boolean canTrade() {
        return canTrade;
    }

    /**
     * Returns a copy of the list of languages spoken by the character.
     *
     * @return a list of languages
     */
    public List<Language> getLanguages() {
        return new ArrayList<>(languages);
    }

    /**
     * Adds a new language to the character's known languages.
     *
     * @param lang the language to add
     */
    public void addLanguage(Language lang) {
        languages.add(lang);
    }

    /**
     * Checks whether the character currently holds an item with the given name.
     *
     * @param itemName the name of the item to check
     * @return {@code true} if the item is held by the character,
     *         {@code false} otherwise
     */
    public boolean hasItem(String itemName) {
        for (Item item : heldItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds an item to the character's inventory.
     *
     * @param item the item to add
     */
    public void addItem(Item item) {
        heldItems.add(item);
    }

    /**
     * Gives an item to the player if the character is allowed to trade.
     * <p>
     * The item is removed from the character's inventory if found.
     * </p>
     *
     * @param itemName the name of the item to give
     * @return the item if trading is allowed and the item exists,
     *         or {@code null} otherwise
     */
    public Item giveItem(String itemName) {
        if (!canTrade) return null;

        for (Item item : heldItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                heldItems.remove(item);
                return item;
            }
        }
        return null;
    }
}
