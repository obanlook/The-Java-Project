import java.util.List;

/**
 * The Dictionary class represents an item that allows communication
 * between the player and French-speaking characters.
 * <p>
 * When used, the dictionary enables a French-speaking NPC in the current
 * location to understand English.
 * </p>
 */
public class Dictionary extends Item {

    /**
     * Constructs a Dictionary item with a predefined name and description.
     * The description explains that the dictionary allows communication
     * with French-speaking characters.
     */
    public Dictionary() {
        super("Dictionary", "A French to English dictionary.\n you can talk to any french person.");
    }

    /**
     * Uses the dictionary in the player's current location.
     * <p>
     * If a French-speaking NPC is present, the NPC learns English and
     * can understand the player from that point onward.
     * </p>
     *
     * @param player the player using the dictionary
     * @return {@code true} if a French-speaking NPC learned English,
     *         {@code false} if no applicable NPC was found
     */
    @Override
    public boolean use(Player player) {
        Location location = player.getCurrentLocation();
        List<NPC> npcs = location.getCharacters();
        for(NPC npc : npcs) {
            if(npc.canSpeak(Language.FRENCH)){
                npc.addLanguage(Language.ENGLISH);
                System.out.println("NPC '"+ npc.getName()+"' can understand English now!");
                return true;//effective usage
            }

        }
        System.out.println("No one here speaks French to use the dictionary!");
        return false;//no effect
    }
}
