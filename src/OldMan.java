/**
 * The OldMan class represents a non-player character (NPC)
 * who provides helpful information to the player.
 * <p>
 * The old man speaks Spanish and gives hints about the
 * location of the engine coach.
 * </p>
 */
public class OldMan extends NPC {

    /**
     * Constructs an OldMan character with a predefined name.
     * <p>
     * The old man initially speaks Spanish.
     * </p>
     */
    public OldMan() {
        super("OldMan");
        addLanguage(Language.SPANISH);
    }

    /**
     * Returns the dialogue spoken by the old man when the player
     * interacts with him.
     *
     * @param player the player interacting with the old man
     * @return a hint about the location of the engine coach
     */
    @Override
    public String talk(Player player) {
        return "The engine coach is at the end of the train";
    }
}
