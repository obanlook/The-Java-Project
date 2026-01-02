public class UseCommand implements Command {

    private final String itemName;
    private static final int COST = 1;

    public UseCommand(String itemName) {

        this.itemName = itemName;
    }

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
