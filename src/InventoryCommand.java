import java.util.List;

public class InventoryCommand implements Command {

    private static final int COST = 0;

    @Override
    public void execute(Player player, Game game) {

        Inventory inventory = player.getInventory();
        List<Item> items = inventory.getItems();

        System.out.println("\n======= INVENTORY =======");
        System.out.println("Capacity: " + items.size() + " / " + inventory.getCapacity());
        System.out.println("--------------------------");

        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (Item item : items) {
                System.out.println("• " + item.getName());
            }
        }

        System.out.println("==========================\n");

        game.handleActionCost(COST);
    }
}
