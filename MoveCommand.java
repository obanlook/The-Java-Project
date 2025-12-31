public class MoveCommand implements Command {

    private final Direction direction;
    private static final int COST = 1;

    public MoveCommand(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Player player, Game game) {

        // Wall directions
        if (direction == Direction.EAST || direction == Direction.WEST) {
            System.out.println("There is a wall. You can't go that way.");
            game.handleActionCost(COST);
            return;
        }

        Location current = player.getCurrentLocation();
        Location next = current.getExit(direction);

        // No exit
        if (next == null) {
            System.out.println("You can't move in that direction.");
            game.handleActionCost(COST);
            return;
        }

        // if the next coach is locked
        if (next.isLocked()&& !player.hasItemByName("AccessCard")) {
            System.out.println("This coach is locked. You need Access Card to enter");
            game.handleActionCost(COST);
            return;
        }

        // Successful movement
        player.moveTo(next);
        game.handleActionCost(COST);

        System.out.println("You moved " + direction.name() + " and arrive at: " + next.getName());
        System.out.println(next.getDescription());
    }
}
