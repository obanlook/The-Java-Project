public class ExplainCommand implements Command {

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
