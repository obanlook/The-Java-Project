/**
 * The ExplainCommand class represents a command that explains the
 * game’s storyline and objectives to the player.
 * <p>
 * When executed, this command prints an overview of the game scenario,
 * the player's goal, and the conditions required to win.
 * </p>
 */
public class ExplainCommand implements Command {

    /**
     * Executes the explain command.
     * <p>
     * This method displays the game background, objectives, and
     * success conditions to the player.
     * </p>
     *
     * @param player the player executing the command
     * @param game the current game instance
     */
    @Override
    public void execute(Player player, Game game) {
        System.out.println("\n===== GAME EXPLANATION =====\n");

        System.out.println("You are on a train heading to a life-changing job interview.");
        System.out.println("Suddenly, the train stops due to an engine failure.");
        System.out.println("The mechanic is trying to fix the engine, but he needs help.");
        System.out.println();
        System.out.println("Your goal:");
        System.out.println("- Find useful tool(s).");
        System.out.println("- Move to the Engine Coach and help the mechanic fix the engine.");
        System.out.println("- Complete this before your time runs out!");
        System.out.println();
        System.out.println("Fix the engine before time expires… Good luck!");
        System.out.println("\n============================\n");
    }
}
