/**
 * The UnknownCommand class represents an unrecognized or invalid command.
 * <p>
 * This command is executed when the player's input does not match
 * any valid command in the game.
 * </p>
 */
public class UnknownCommand implements Command {

    /**
     * The action cost associated with executing this command.
     */
    private static final int COST = 1;

    /**
     * Executes the unknown command.
     * <p>
     * This method informs the player that the command is not recognized
     * and applies the corresponding action cost.
     * </p>
     *
     * @param player the player executing the command
     * @param game the current game instance
     */
    @Override
    public void execute(Player player, Game game) {
        System.out.println("Unknown command!");
        game.handleActionCost(COST);
    }
}
