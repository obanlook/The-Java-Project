/**
 * The UseCommand class represents a command that allows the player
 * to use an item from their inventory.
 * <p>
 * The effect of using an item depends on the specific item type.
 * Executing this command consumes time.
 * </p>
 */
public class UseCommand implements Command {

    /**
     * The name of the item to be used.
     */
    private final String itemName;

    /**
     * The action cost associated with executing this command.
     */
    private static final int COST = 1;

    /**
     * Constructs a UseCommand for a specific item.
     *
     * @param itemName the name of the item to use
     */
    public UseCommand(String itemName) {

        this.itemName = itemName;
    }

    /**
     * Executes the use command.
     * <p>
     * This method attempts to locate the specified item in the player's
     * inventory and applies its effect. If the item cannot be used or
     * does not exist, appropriate feedback is shown to the player.
     * </p>
     *
     * @param player the player executing the command
     * @param game the current game instance
     */
    @Override
    public void execute(Player player, Game game) {
        //find the item by its name
        Item item = player.getInventory().getItemByName(itemName);
        game.handleActionCost(COST);
        //after applying the cost now we actually use the item
        if (item == null) {
            System.out.println("You don't have a/an " + itemName + ".");
            return;
        }

        boolean success = item.use(player);

        if (!success) {
            System.out.println("You successfully WASTED your time!\nNothing happened!");
        }
    }
}
