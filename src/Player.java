import java.util.HashSet;
import java.util.Set;

public class Player {

    private final Game game;
    private int timeRemaining;
    private final Set<Language> languages = new HashSet<>();
    private Location currentLocation;
    private final Inventory inventory;

    public Player(Game game, Location startLocation) {
        this.game = game;
        this.currentLocation = startLocation;
        this.timeRemaining = 30;

        // Initially, player can only interact with people knowing English
        languages.add(Language.ENGLISH);

        this.inventory = new Inventory();
    }

    // Time management
    public void decrementTime(int amount) {
        timeRemaining -= amount;
    }

    public boolean isOutOfTime() {
        return timeRemaining <= 0;
    }

    // Movement (used indirectly by MoveCommand)
    public void moveTo(Location next) {
        this.currentLocation = next;
    }

    // Language Management

    //After using dictionary
    public void learnLanguage(Language language) {
        languages.add(language);
    }

    public boolean canUnderstand(Language language) {
        return languages.contains(language);
    }

    // Inventory helper for quicker access
    public boolean hasItem(String itemName) {
        return inventory.hasItem(itemName);
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
