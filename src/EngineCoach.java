import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The EngineCoach class represents the engine coach location in the game.
 * <p>
 * This location starts as dark and contains the main objective required
 * to satisfy the game's win condition.
 * </p>
 */
public class EngineCoach extends Location implements WinCondition {

    /**
     * Indicates whether the engine has been fixed.
     */
    private boolean fixed = false;

    /**
     * Constructs the Engine Coach location with a predefined name,
     * description, and initial state.
     * <p>
     * The engine coach starts unlocked but dark.
     * </p>
     */
    public EngineCoach() {
        super(
                "Engine Coach",
                "This is the engine coach. Help the mechanic fix the engine!",
                false, // locked?
                true // dark?

        );
    }

    /**
     * Marks the engine as fixed.
     */
    public void fixEngine() {
        fixed = true;
    }

    /**
     * Checks whether the win condition associated with this location
     * has been satisfied.
     *
     * @return {@code true} if the engine has been fixed,
     *         {@code false} otherwise
     */
    @Override
    public boolean isSatisfied() {
        return fixed;
    }
}
