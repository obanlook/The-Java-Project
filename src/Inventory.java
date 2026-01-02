import java.util.ArrayList;
import java.util.List;

/**
 * The Inventory class represents the collection of items carried by the player.
 * <p>
 * The inventory has a fixed capacity and prevents duplicate items
 * based on item names.
 * </p>
 */
public class Inventory {

    //since the items will always reference to this list, the list will change but not the reference
    //you can't make new items = new ArrayList<>(); which is good
    //the list itself will not change, but its component will

    /**
     * The list of items currently held in the inventory.
     */
    private final List<Item> items;

    /**
     * The maximum number of items the inventory can hold.
     */
    private static final int CAPACITY = 3;

    /**
     * Constructs an empty inventory with a fixed capacity.
     */
    public Inventory(){
        items = new ArrayList<>(CAPACITY);
    }

    /**
     * Adds an item to the inventory if there is available space
     * and the item is not already present.
     *
     * @param item the item to add
     * @return {@code true} if the item was successfully added,
     *         {@code false} otherwise
     */
    public boolean addItem(Item item){
        if(items.size() >= CAPACITY){
            System.out.println("you can't have more than "+CAPACITY+" items");
            return false;
        }
        if(this.hasItemByName(item.getName())){
            System.out.println("You already have this item!");
            return false;
        }
        items.add(item);
        return true;
    }

    /**
     * Removes an item from the inventory using the item object.
     *
     * @param item the item to remove
     * @return {@code true} if the item was removed,
     *         {@code false} if the item was not found
     */
    public boolean removeItem(Item item){
        if (!hasItemByName(item.getName())) {
            System.out.println("You don't have this item!");
            return false;
        }

        for (int i = 0; i < items.size(); i++) {
            Item current = items.get(i);
            if (current.getName().equalsIgnoreCase(item.getName())) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    //Getters by name

    /**
     * Returns an item from the inventory by its name.
     *
     * @param itemName the name of the item
     * @return the matching item, or {@code null} if not found
     */
    public Item getItemByName(String itemName){
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName))
                return item;
        }
        return null;
    }

    /**
     * Checks whether the inventory contains an item with the given name.
     *
     * @param name the name of the item
     * @return {@code true} if the item exists in the inventory,
     *         {@code false} otherwise
     */
    //Since the identifier of items is their names
    public boolean hasItemByName(String name) {
        return getItemByName(name) != null;
    }

    //=================================================
    //get copy of the field(s)

    /**
     * Returns a copy of the list of items in the inventory.
     * <p>
     * This prevents external modification of the internal list.
     * </p>
     *
     * @return a copy of the inventory items
     */
    public List<Item> getItems() {
        return new ArrayList<>(items);//https://stackoverflow.com/questions/8441664/how-do-i-copy-the-contents-of-one-arraylist-into-another
    }

    /**
     * Returns the maximum capacity of the inventory.
     *
     * @return the inventory capacity
     */
    public int getCapacity() {
        return CAPACITY;
    }
}
