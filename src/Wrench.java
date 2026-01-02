/**
 * The Wrench class represents an item that can be used to repair machinery.
 * <p>
 * This item is specifically required to fix the engine in the Engine Coach,
 * which is necessary to satisfy the game's win condition.
 * </p>
 */
public class Wrench extends Item {

    /**
     * Constructs a Wrench item with a predefined name and description.
     */
    public Wrench() {
        super("Wrench", "A sturdy tool used to tighten bolts and repair machinery.");
    }

    /**
     * Uses the wrench in the player's current location.
     * <p>
     * The wrench can only be used effectively in the Engine Coach.
     * If used there, it fixes the engine and progresses the game
     * toward completion.
     * </p>
     *
     * @param player the player using the wrench
     * @return {@code true} if the engine was successfully fixed,
     *         {@code false} if the wrench had no effect
     */
    @Override
    public boolean use(Player player) {
        Location location = player.getCurrentLocation();

        // Only works in Engine Coach
        if (location instanceof EngineCoach engineCoach) {
            // Fix the engine
            engineCoach.fixEngine();
            System.out.println("You tighten the bolts carefully with the wrench...");
            System.out.println("The engine rumbles back to life! You fixed it!");

            return true;
        }

        System.out.println("There is nothing here that you can fix with a wrench.");
        return false;
    }
}
