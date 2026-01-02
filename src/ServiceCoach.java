import java.util.List;
import java.util.Map;

/**
 * The ServiceCoach class represents the service coach location in the game.
 * <p>
 * This coach starts locked and contains useful tools that can help
 * the player progress in the game.
 * </p>
 */
public class ServiceCoach extends Location {

    /**
     * Constructs the Service Coach location with a predefined name,
     * description, and initial state.
     * <p>
     * The service coach is initialized as locked but not dark.
     * </p>
     */
    public ServiceCoach() {
        super(
                "Service Coach",
                "This is the service coach.\nYou can find some tools here!",
                true,   // locked?
                false   // dark?
        );

    }
}
