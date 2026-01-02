import java.util.List;
import java.util.Map;

/**
 * The FamilyCoach class represents the family coach location in the game.
 * <p>
 * This coach is accessible to the player and is neither locked nor dark
 * when the game begins.
 * </p>
 */
public class FamilyCoach extends Location {

    /**
     * Constructs the Family Coach location with a predefined name,
     * description, and initial state.
     * <p>
     * The family coach is initialized as unlocked and well-lit.
     * </p>
     */
    public FamilyCoach() {
        super(
                "Family Coach",
                "This is the family coach.",
                false,   // locked?
                false   // dark?
        );

    }
}
