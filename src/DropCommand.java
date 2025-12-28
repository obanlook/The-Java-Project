public class DropCommand implements Command {

    private static final int COST = 0;
    private final String itemName;

    public DropCommand(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public void execute(Player player, Game game) {

        Location location = player.getCurrentLocation();

        // Find item safely using Location API
        Item targetItem = player.getInventory().getItem(itemName);

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
