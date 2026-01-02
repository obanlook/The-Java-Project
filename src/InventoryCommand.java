import java.util.List;

/**
 * The InventoryCommand class represents a command that displays
 * the contents of the player's inventory.
 * <p>
 * When executed, this command shows the current items carried
 * by the player along with the inventory capacity.
 * </p>
 */
public class InventoryCommand implements Command {

    /**
     * The action cost associated with executing this command.
     */
    private static final int COST = 0;

    /**
     * Executes the inventory command.
     * <p>
     * This method retrieves the player's inventory and prints
     * all items currently being carried. If the inventory is empty,
     * an appropriate message is displayed.
     * </p>
     *
     * @param player the player executing the command
     * @param game the current game instance
     */
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
