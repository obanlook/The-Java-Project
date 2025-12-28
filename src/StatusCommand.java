public class StatusCommand implements Command {
    private static final int COST = 0;

    @Override
    public void execute(Player player, Game game) {

        Location loc = player.getCurrentLocation();

        System.out.println("\n===== PLAYER STATUS =====");
        System.out.println("current Location: " + loc.getName());
        System.out.println("Time Remaining: " + player.getTimeRemaining());

        // Languages player knows
        System.out.print("Languages you can communicate with: ");
        if (player.getLanguages().isEmpty()) {
            System.out.println("(none)");
        } else {
            for (Language lang : player.getLanguages()) {
                System.out.print(lang + " ");
            }
            System.out.println();
        }

        System.out.println("==========================\n");
        game.handleActionCost(COST);
    }
}

