public class QuitCommand implements Command {
    @Override
    public void execute(Player player, Game game) {
        game.setGameState(GameState.QUIT);

    }


}
