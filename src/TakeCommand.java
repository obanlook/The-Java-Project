/**
 * The TakeCommand class represents a command that allows the player
 * to pick up an item from the current location.
 * <p>
 * When executed, this command attempts to move an item from the
 * location's ground items into the player's inventory.
 * </p>
 */
public class TakeCommand implements Command {

    /**
     * The action cost associated with executing this command.
     */
    private static final int COST = 1;

    /**
     * The name of the item to be taken.
     */
    private final String itemName;

    /**
     * Constructs a TakeCommand for a specific item.
     *
     * @param itemName the name of the item to take
     */
    public TakeCommand(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Executes the take command.
     * <p>
     * This method checks whether the specified item exists in the current
     * location, attempts to add it to the player's inventory, and removes
     * it from the location if successful.
     * </p>
     *
     * @param player the player executing the command
     * @param game the current game instance
     */
    @Override
    public void execute(Player player, Game game) {

        Location location = player.getCurrentLocation();

        // Find item safely using Location API
        Item targetItem = location.getItemByName(itemName);

        if (targetItem == null) {
            System.out.println("There is no item '" + itemName + "' in this location.");
            game.handleActionCost(COST);
            return;
        }

        // Try adding to inventory
        boolean added = player.getInventory().addItem(targetItem);
        if (!added) {
            System.out.println("Your inventory is full. You cannot take '" + targetItem.getName() + "'.");
            game.handleActionCost(COST);
            return;
        }

        // Remove item SAFELY using Location API (not list returned by getter!)
        location.removeItemByName(itemName);

        System.out.println("You picked up the " + targetItem.getName() + ".");
        game.handleActionCost(COST);
    }
}
