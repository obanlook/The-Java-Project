public class Game {
    private Player player;
    private CommandParser commandParser;
    private Location currentLocation;
    private GameState gameState;
    public boolean isRunning = false;
    public Game(Player player, CommandParser commandParser) {
        this.player = player;
    }

    public void startGame() {

    }

    public void processCommand(String command) {

    }

    public void say(String message) {

    }

    public void handeActionCost(int cost) {

    }

    public boolean checkWin() {
        return false;
    }

    public boolean checkLose() {
        return false;
    }



}
