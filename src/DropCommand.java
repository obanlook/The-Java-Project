/**
 * The DropCommand class represents a command that allows the player
 * to drop an item from their inventory into the current location.
 * <p>
 * This command safely removes the specified item from the player's
 * inventory and places it in the current location.
 * </p>
 */
public class DropCommand implements Command {

    /**
     * The action cost associated with executing this command.
     */
    private static final int COST = 0;

    /**
     * The name of the item to be dropped.
     */
    private final String itemName;

    /**
     * Constructs a DropCommand for a specific item.
     *
     * @param itemName the name of the item to drop
     */
    public DropCommand(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Executes the drop command.
     * <p>
     * The method attempts to locate the specified item in the player's
     * inventory, remove it, and add it to the current location.
     * </p>
     *
     * @param player the player executing the command
     * @param game the current game instance
     */
    @Override
    public void execute(Player player, Game game) {

        Location location = player.getCurrentLocation();

        // Find item safely using Location API
        Item targetItem = player.getInventory().getItemByName(itemName);

        if (targetItem == null) {
            System.out.println("There is no item '" + itemName + "' in this location.");
            game.handleActionCost(COST);
            return;
        }

        // Try removing from inventory
        boolean dropped = player.getInventory().removeItem(targetItem);
        if (!dropped) {
            System.out.println("Item is still in your inventory, try again");
            game.handleActionCost(COST);
            return;
        }

        // Return item SAFELY using Location API (not list returned by getter!)
        location.addItem(targetItem);

        System.out.println("You dropped the " + targetItem.getName() + ".");
        game.handleActionCost(COST);
    }
}
