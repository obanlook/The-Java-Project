/**
 * The WinCondition interface represents a condition that determines
 * whether the player has won the game.
 * <p>
 * Classes implementing this interface define their own logic
 * for deciding when the game is considered successfully completed.
 * </p>
 */
public interface WinCondition {

    /**
     * Checks whether the win condition has been satisfied.
     *
     * @return {@code true} if the win condition is met,
     *         {@code false} otherwise
     */
    public boolean isSatisfied();
}
