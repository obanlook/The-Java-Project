import java.util.ArrayList;
import java.util.List;

public class Inventory {
    //since the items will always reference to this list, the list will change but not the reference
    //you can't make new items = new ArrayList<>(); which is good
    //the list itself will not change, but its component will
    private final List<Item> items;
    private static final int CAPACITY = 3;

    public Inventory(){
        items = new ArrayList<>(CAPACITY);

    }


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

    //remove Item by an object of that item not by its name
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

    //get item by name
    public Item getItemByName(String itemName){
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName))
                return item;
        }
        return null;
    }
    //Since the identifier of items is their names
    public boolean hasItemByName(String name) {
        return getItemByName(name) != null;
    }
//=================================================
    //get copy of the field(s)


    //get the whole items
    //does not return the actual list but the copy in case of encapsulation
    public List<Item> getItems() {
        return new ArrayList<>(items);//https://stackoverflow.com/questions/8441664/how-do-i-copy-the-contents-of-one-arraylist-into-another
    }

    public int getCapacity() {

        return CAPACITY;
    }






}
