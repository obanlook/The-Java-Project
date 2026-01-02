/**
 * The Command interface represents an executable action in the game.
 * <p>
 * Every command in the game must implement this interface so that it can
 * be executed by the game engine. Commands define actions that affect
 * the player or the game state.
 * </p>
 */
//all the commands needs to be executed(activated) so that the game goes on
public interface Command {

    /**
     * Executes the command.
     * <p>
     * This method defines the behavior of the command when it is triggered
     * during gameplay.
     * </p>
     *
     * @param player the player performing the command
     * @param game the game instance in which the command is executed
     */
    public void execute(Player player, Game game);

}
