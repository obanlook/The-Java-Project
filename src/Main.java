/**
 * The Main class serves as the entry point of the application.
 * <p>
 * It initializes the game and starts the gameplay loop.
 * </p>
 */
public class Main {

    /**
     * The main method that launches the game.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
