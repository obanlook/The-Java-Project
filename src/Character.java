import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    private final String name;
    private final boolean canTrade;
    private List<Language> languages = new ArrayList<>();
    private final List<Item> heldItems = new ArrayList<>();

    public Character(String name, boolean canTrade) {
        this.name = name;
        this.canTrade = canTrade;
    }

    // Abstract behavior implemented by subclasses
    public abstract String talk(Player player);
    public abstract String examine(Player player);

    // Getters
    public String getName() {
        return name;
    }

    public boolean canSpeak(Language lang) {
        return languages.contains(lang);
    }

    public boolean canTrade() {
        return canTrade;
    }

    public List<Language> getLanguages() {
        return new ArrayList<>(languages);
    }

    public void addLanguage(Language lang) {
        languages.add(lang);
    }



    // Inventory logic for NPC
    public boolean hasItem(String itemName) {
        for (Item item : heldItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public void addItem(Item item) {
        heldItems.add(item);
    }

    // Returns an item only if NPC is allowed to trade
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
