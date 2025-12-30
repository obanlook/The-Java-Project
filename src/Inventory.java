import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;
    private final int MAX = 3;

    public Inventory(){
        items = new ArrayList<>(MAX);

    }


    public boolean addItem(Item item){
        if(items.size() >= MAX){
            System.out.println("you can't have more than "+MAX+" items");
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
        if(!this.hasItemByName(item.getName())){
            System.out.println("You don't have this item!");
        }
        //remove the item if it has the same name with the input item
        for(Item i : items){
            if(i.getName().equalsIgnoreCase(item.getName())){
                items.remove(i);
                return true;
            }
        }
        return false;
    }


    //Getter

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

    //get the whole items
    //does not return the actual list but the copy in case of encapsulation
    public List<Item> getItems() {
        return new ArrayList<>(items);//https://stackoverflow.com/questions/8441664/how-do-i-copy-the-contents-of-one-arraylist-into-another
    }

    public int getMAX() {
        return MAX;
    }

//    public int count(){
//        return items.size();
//    }
//
//    public boolean isFull(){
//        return items.size() == MAX;
//    }





}
