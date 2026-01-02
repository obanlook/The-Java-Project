/**
 * The StatusCommand class represents a command that displays
 * the current status of the player.
 * <p>
 * This includes the player's location, remaining time,
 * and the languages the player can communicate with.
 * </p>
 */
public class StatusCommand implements Command {

    /**
     * The action cost associated with executing this command.
     */
    private static final int COST = 0;

    /**
     * Executes the status command.
     * <p>
     * This method prints information about the player's current
     * state, including location, remaining time, and known languages.
     * </p>
     *
     * @param player the player executing the command
     * @param game the current game instance
     */
    @Override
    public void execute(Player player, Game game) {

        Location loc = player.getCurrentLocation();

        System.out.println("\n===== PLAYER STATUS =====");
        System.out.println("current Location: " + loc.getName());
        System.out.println("Time Remaining: " + player.getTimeRemaining());

        // Languages player knows
        System.out.print("Languages you can communicate with: ");
        //just in case :)
        if (player.getLanguages().isEmpty()) {
            System.out.println("(none)");
        } else {
            System.out.print("[ ");
            for (Language lang : player.getLanguages()) {
                System.out.print(lang+" ");
            }
            System.out.print("]\n");
        }

        System.out.println("==========================");
        game.handleActionCost(COST);
    }
}
