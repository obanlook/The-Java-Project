import java.util.List;
import java.util.Map;

/**
 * The EconomyCoach class represents the economy coach location in the game.
 * <p>
 * This location is accessible to the player and is neither locked nor dark
 * when the game starts.
 * </p>
 */
public class EconomyCoach extends Location {

    /**
     * Constructs the Economy Coach location with a predefined name,
     * description, and initial state.
     * <p>
     * The economy coach is initialized as unlocked and well-lit.
     * </p>
     */
    public EconomyCoach() {
        super(
                "Economy Coach",
                "This is the economy coach.",
                false,   // locked?
                false   // dark?
        );

    }
}
