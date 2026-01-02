import java.util.HashSet;
import java.util.Set;

public class Player {


    private int timeRemaining;
    private final Set<Language> languages = new HashSet<>();
    private Location currentLocation;
    private final Inventory inventory;

    public Player(Location startLocation) {
        this.currentLocation = startLocation;
        this.timeRemaining = 30;

        //player can only interact with people knowing English and Spanish
        languages.add(Language.ENGLISH);
        languages.add(Language.SPANISH);

        this.inventory = new Inventory();
    }

    // Time management
    public void decrementTime(int amount) {
        timeRemaining -= amount;
    }

    public boolean isOutOfTime() {
        return timeRemaining <= 0;
    }

    // Movement (used by MoveCommand)
    public void moveTo(Location next) {
        this.currentLocation = next;
    }

    // Language Management
    public boolean canUnderstand(Language language) {
        return languages.contains(language);
    }

    // Inventory helper for quicker access
    public boolean hasItemByName(String itemName) {
        return inventory.hasItemByName(itemName);
    }

    // Getters
    public Location getCurrentLocation() {
        return currentLocation;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public Set<Language> getLanguages() {
        return new HashSet<>(languages);//return copy
    }

    public Inventory getInventory() {
        return inventory;
    }

    // Setters
    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

}
