/**
 * The Mechanic class represents a non-player character (NPC)
 * responsible for repairing the train engine.
 * <p>
 * The mechanic provides information about the broken engine
 * and guides the player toward the required solution.
 * </p>
 */
public class Mechanic extends NPC {

    /**
     * Constructs a Mechanic character with a predefined name.
     * <p>
     * The mechanic initially speaks French.
     * </p>
     */
    public Mechanic() {
        super("Mechanic");
        addLanguage(Language.FRENCH);
    }

    /**
     * Returns the dialogue spoken by the mechanic when the player
     * interacts with them.
     *
     * @param player the player interacting with the mechanic
     * @return a message explaining the engine problem
     */
    @Override
    public String talk(Player player) {
        return "The engine is broken! If you have a wrench, you can fix it.";
    }
}
