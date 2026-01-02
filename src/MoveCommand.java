/**
 * The MoveCommand class represents a command that allows the player
 * to move from one location to another.
 * <p>
 * Movement is restricted by walls, locked locations, and available exits.
 * Executing this command consumes time.
 * </p>
 */
public class MoveCommand implements Command {

    /**
     * The direction in which the player intends to move.
     */
    private final Direction direction;

    /**
     * The action cost associated with moving.
     */
    private static final int COST = 1;

    /**
     * Constructs a MoveCommand with a specified direction.
     *
     * @param direction the direction to move
     */
    public MoveCommand(Direction direction) {
        this.direction = direction;
    }

    /**
     * Executes the move command.
     * <p>
     * This method checks for walls, valid exits, and locked locations
     * before moving the player to the next location.
     * </p>
     *
     * @param player the player executing the command
     * @param game the current game instance
     */
    @Override
    public void execute(Player player, Game game) {
        game.handleActionCost(COST);
        // Wall directions
        if (direction == Direction.EAST || direction == Direction.WEST) {
            System.out.println("There is a wall. You can't go that way.");
            return;
        }

        Location current = player.getCurrentLocation();
        Location next = current.getExit(direction);

        // No exit
        if (next == null) {
            System.out.println("You can't move in that direction.");
            return;
        }

        // if the next coach is locked
        /*if (next.isLocked()&& !player.hasItemByName("AccessCard")){
            System.out.println("This coach is locked. You need Access Card to enter");
            return;
        }*/
        if (next.isLocked()){
            System.out.println("This coach is locked. You need Access Card to enter");
            return;
        }

        // Successful movement
        player.moveTo(next);
        System.out.println("You moved " + direction.name() + " and arrive at: " + next.getName());
        System.out.println(next.getDescription());
    }
}
