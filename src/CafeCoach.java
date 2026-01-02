import java.util.List;
import java.util.Map;

/**
 * The CafeCoach class represents a specific type of location in the game.
 * <p>
 * This coach functions as a cafe area that the player can access.
 * It is neither locked nor dark when the game starts.
 * </p>
 */
public class CafeCoach extends Location {

    /**
     * Constructs the Cafe Coach location with a predefined name,
     * description, and initial state.
     * <p>
     * The cafe coach is initialized as unlocked and not dark.
     * </p>
     */
    public CafeCoach() {
        super(
                "Cafe Coach",
                "This is the cafe coach.",
                false,   // locked?
                false   // dark?
        );

    }
}
