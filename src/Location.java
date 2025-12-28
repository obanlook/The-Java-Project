import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public abstract class Location {

    private final String name;
    private final String description;
    private Map<Direction, Location> exits = new HashMap<>();
    private List<Item> groundItems = new ArrayList<>();
    private List<Character> characters = new ArrayList<>();
    private boolean locked;
    private boolean dark;
    private boolean light = false;//if there is something like flashlight or candle

    public Location(String name, String description, boolean locked, boolean dark) {
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.dark = dark;
    }

    // Core actions


    public void addItem(Item item) {
        groundItems.add(item);
    }

    public void removeItem(Item item) {
        groundItems.remove(item);
    }

    public Item getItemByName(String itemName) {
        for (Item item : groundItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public boolean removeItemByName(String itemName) {
        Item target = getItemByName(itemName);
        if (target != null) {
            groundItems.remove(target);
            return true;
        }
        return false;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void removeCharacter(Character character) {
        characters.remove(character);
    }

    public void removeCharacterByName(String characterName) {
        for(Character character : characters) {
            if (character.getName().equalsIgnoreCase(characterName)) {
                characters.remove(character);
            }
        }
    }

    public void enlighten(){
        light = true;
    }
    //player can see whether the coach is not dark or at least has a light
    public boolean canSee(){
      return (!dark || light);
    }

    public void unlock(){
        locked = false;
    }



    public void setExit(Direction direction, Location location) {
        exits.put(direction, location);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Location getExit(Direction direction) {
        return exits.get(direction);
    }

    public List<Item> getGroundItems() {
        return new ArrayList<>(groundItems); // return copy
    }

    public List<Character> getCharacters() {
        return new ArrayList<>(characters); // return copy
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isDark() {
        return dark;
    }

    // Display helpers
    public String showGroundItems() {
        StringBuilder ans = new StringBuilder();
        for (Item item : groundItems) {
            ans.append(item.getName()).append("\n");
        }
        return ans.toString();
    }

    public String showCharacters() {
        StringBuilder ans = new StringBuilder();
        for (Character character : characters) {
            ans.append(character.getName()).append("\n");
        }
        return ans.toString();
    }

    public String showExits() {
        StringBuilder ans = new StringBuilder();
        for (Direction direction : exits.keySet()) {
            ans.append(direction.name()).append(" -> ").append(exits.get(direction).getName()).append("\n");
        }
        return ans.toString();
    }
}
