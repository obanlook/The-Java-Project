public class TakeCommand implements Command {

    private static final int COST = 1;
    private final String itemName;

    public TakeCommand(String itemName) {
        this.itemName = itemName;
    }

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
