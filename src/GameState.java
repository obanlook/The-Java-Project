/**
 * The GameState enum represents the possible states of the game.
 * <p>
 * The game transitions between these states based on player actions
 * and game conditions.
 * </p>
 */
public enum GameState {

    /**
     * The game is currently running and accepting player input.
     */
    PLAYING,

    /**
     * The player has chosen to quit the game.
     */
    QUIT,

    /**
     * The player has successfully completed the win condition.
     */
    WON,

    /**
     * The player has failed to complete the game objectives in time.
     */
    LOST
}
