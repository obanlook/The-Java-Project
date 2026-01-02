import java.util.HashSet;
import java.util.Set;

/**
 * The Player class represents the player character in the game.
 * <p>
 * The player has a current location, limited time, an inventory,
 * and a set of languages they can understand.
 * </p>
 */
public class Player {

    /**
     * The remaining time available to the player.
     */
    private int timeRemaining;

    /**
     * The set of languages the player can understand.
     */
    private final Set<Language> languages = new HashSet<>();

    /**
     * The current location of the player.
     */
    private Location currentLocation;

    /**
     * The player's inventory.
     */
    private final Inventory inventory;

    /**
     * Constructs a Player with a starting location.
     * <p>
     * The player starts with a fixed amount of time and
     * understands English and Spanish by default.
     * </p>
     *
     * @param startLocation the starting location of the player
     */
    public Player(Location startLocation) {
        this.currentLocation = startLocation;
        this.timeRemaining = 30;

        //player can only interact with people knowing English and Spanish
        languages.add(Language.ENGLISH);
        languages.add(Language.SPANISH);

        this.inventory = new Inventory();
    }

    // Time management

    /**
     * Decreases the remaining time by a given amount.
     *
     * @param amount the amount of time to subtract
     */
    public void decrementTime(int amount) {
        timeRemaining -= amount;
    }

    /**
     * Checks whether the player has run out of time.
     *
     * @return {@code true} if no time remains, {@code false} otherwise
     */
    public boolean isOutOfTime() {
        return timeRemaining <= 0;
    }

    // Movement (used by MoveCommand)

    /**
     * Moves the player to a new location.
     * <p>
     * If the player leaves a location that was unlocked temporarily,
     * that location will be re-locked automatically.
     * </p>
     *
     * @param next the next location to move to
     */

    public void moveTo(Location next) {

        // If leaving a temporarily unlocked location, re-lock it
        if (currentLocation != null && currentLocation.isTemporarilyUnlocked()) {
            currentLocation.relock();
            System.out.println("The door locks behind you.");
        }

        this.currentLocation = next;
    }

    // Language Management

    /**
     * Checks whether the player can understand a given language.
     *
     * @param language the language to check
     * @return {@code true} if the player understands the language,
     *         {@code false} otherwise
     */
    public boolean canUnderstand(Language language) {
        return languages.contains(language);
    }

    // Inventory helper for quicker access

    /**
     * Checks whether the player has an item with the given name
     * in their inventory.
     *
     * @param itemName the name of the item
     * @return {@code true} if the item exists, {@code false} otherwise
     */
    public boolean hasItemByName(String itemName) {
        return inventory.hasItemByName(itemName);
    }

    // Getters

    /**
     * Returns the player's current location.
     *
     * @return the current location
     */
    public Location getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Returns the player's remaining time.
     *
     * @return the remaining time
     */
    public int getTimeRemaining() {
        return timeRemaining;
    }

    /**
     * Returns a copy of the languages the player understands.
     *
     * @return a set of languages
     */
    public Set<Language> getLanguages() {
        return new HashSet<>(languages);//return copy
    }

    /**
     * Returns the player's inventory.
     *
     * @return the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    // Setters

    /**
     * Sets the player's remaining time.
     *
     * @param timeRemaining the new remaining time
     */
    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }
}
