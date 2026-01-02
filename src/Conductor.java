/**
 * The Conductor class represents a specific non-player character (NPC)
 * in the game.
 * <p>
 * The conductor can communicate with the player and provides guidance
 * about the location of other characters in the train.
 * </p>
 */
public class Conductor extends NPC {

    /**
     * Constructs a Conductor character with a predefined name.
     * <p>
     * The conductor is able to speak French.
     * </p>
     */
    public Conductor() {
        super("Conductor");
        addLanguage(Language.FRENCH);

    }

    /**
     * Returns the dialogue spoken by the conductor when the player talks
     * to them.
     *
     * @param player the player interacting with the conductor
     * @return a message guiding the player further into the game
     */
    @Override
    public String talk(Player player) {
        return "Welcome. The mechanic is ahead in the engine coach.";
    }

}
