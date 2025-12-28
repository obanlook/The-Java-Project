public class HelpCommand implements Command {

    private static final int COST = 0;

    @Override
    public void execute(Player player, Game game) {

        System.out.println("\n========== HELP ==========");
        System.out.println("Available commands:\n");

        System.out.println("• go <direction>");
        System.out.println("      Move to another location (north / south).");
        System.out.println("• look");
        System.out.println("      See the description of your surroundings.");
        System.out.println("• status");
        System.out.println("      Show your current state (time, inventory, location).");
        System.out.println("• take <item>");
        System.out.println("      Pick up an item from the ground.");
        System.out.println("• drop <item>");
        System.out.println("      Drop an item to the ground.");
        System.out.println("• use <item>");
        System.out.println("      Use an item from your inventory.");
        System.out.println("• talk <character>");
        System.out.println("      Speak with someone in the location.");
        System.out.println("• inventory");
        System.out.println("      Shows all items you're carrying.");
        System.out.println("• quit");
        System.out.println("      Exit the game.");
        System.out.println("• help");
        System.out.println("      Show this help menu again.");

        System.out.println("===========================\n");

        game.handleActionCost(COST);
    }
}
