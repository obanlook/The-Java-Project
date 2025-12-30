public class UnknownCommand implements Command {
    private static final int COST = 1;
    @Override
    public void execute(Player player, Game game) {
        System.out.println("Unknown command!");
        game.handleActionCost(COST);
    }
}
