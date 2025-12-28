import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;
    private final int MAX = 6;

    public Inventory(){
        items = new ArrayList<>(MAX);

    }


    public boolean addItem(Item item){
        if(items.size() >= MAX){
            System.out.println("you can't have more than "+MAX+" items");
            return false;
        }
        if(this.hasItem(item.getName())){
            System.out.println("You already have this item!");
            return false;

        }
        items.add(item);
        return true;
    }

    public boolean removeItem(Item item){
        if(!this.hasItem(item.getName())){
            System.out.println("You don't have this item!");
        }
        //remove every item that has the same name with the input item
        for(Item i : items){
            if(i.getName().equalsIgnoreCase(item.getName())){
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean hasItem(String name) {
        return getItem(name) != null;
    }

    //Getter

    //get by name
    public Item getItem(String itemName){
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName))
                return item;
        }
        return null;
    }

    //get the whole items
    //does not return the actual list but the copy
    public List<Item> getItems() {
        return new ArrayList<>(items);//https://stackoverflow.com/questions/8441664/how-do-i-copy-the-contents-of-one-arraylist-into-another
    }

    public int getMAX() {
        return MAX;
    }

    public int count(){
        return items.size();
    }

    public boolean isFull(){
        return items.size() == MAX;
    }





}
