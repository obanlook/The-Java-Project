import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Character {
    protected String name;
    protected Location location;
    protected List<Language> Languages = new ArrayList<>();
    protected List<Item> heldItems = new ArrayList<>();
    protected Map<String, String> dialouge = new HashMap<>();
    protected boolean canTrade = false;

    //Constructor

    public Character(String name, Location location) {
        this.name = name;
        this.location = location;
    }


//    public abstract String talk(Player player);
//    public abstract void interact(Player player);
//    public abstract boolean giveItemToPlayer(Player player, Item item);
//    public abstract String examine();





}
