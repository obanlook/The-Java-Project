/**
 * The QuitCommand class represents a command that allows the player
 * to exit the game.
 * <p>
 * When executed, this command changes the game state to QUIT,
 * causing the game loop to terminate.
 * </p>
 */
public class QuitCommand implements Command {

    /**
     * Executes the quit command.
     * <p>
     * This method updates the game state to indicate that the
     * player has chosen to quit.
     * </p>
     *
     * @param player the player executing the command
     * @param game the current game instance
     */
    @Override
    public void execute(Player player, Game game) {
        game.setGameState(GameState.QUIT);
    }
}
