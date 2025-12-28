public class UseCommand implements Command {

    private final String itemName;
    private static final int COST = 1;

    public UseCommand(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public void execute(Player player, Game game) {
        //find the item by its name
        Item item = player.getInventory().getItem(itemName);

        if (item == null) {
            System.out.println("You don't have a/an " + itemName + ".");
            game.handleActionCost(COST);
            return;
        }
        if (item instanceof Dictionary) {
            game.handleActionCost(COST*2);
        }

        //after applying the cost now we actually use the item
        boolean success = item.use(player);

        game.handleActionCost(COST);

        if (!success) {
            System.out.println("You successfully WASTED your time!\nNothing happened!");
        }
    }
}
