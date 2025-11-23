import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private final int maxCapacity = 6;


    public boolean addItem(Item item){
        if(items.size() < maxCapacity){
            items.add(item);
            return true;
        }
        return false;

    }
    public boolean removeItem(Item item){
        if(items.contains(item)){
            items.remove(item);
            return true;
        }
        return false;
    }

    public Item getItem(String ItemName){
        for(Item item : items){
            System.out.println("Item Name: " + ItemName);
            if(item.name.equals(ItemName)) return item;
        }
        System.out.println("Item does not exist");
        return null;

    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public boolean isFull(){
        return items.size() == maxCapacity;
    }

    public void showItems(){
        System.out.println("Items in Inventory:");
        for(Item item : items){
            System.out.print(item);

        }
    }



}
