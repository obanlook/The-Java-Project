/**
 * The TalkCommand class represents a command that allows the player
 * to talk to a non-player character (NPC) in the current location.
 * <p>
 * Communication is only successful if the player understands at least
 * one language spoken by the target character.
 * </p>
 */
public class TalkCommand implements Command {

    /**
     * The action cost associated with executing this command.
     */
    private static final int COST = 1;

    /**
     * The name of the character the player wants to talk to.
     */
    private final String characterName;

    /**
     * Constructs a TalkCommand for a specific character.
     *
     * @param characterName the name of the character to talk to
     */
    public TalkCommand(String characterName) {
        this.characterName = characterName;
    }

    /**
     * Executes the talk command.
     * <p>
     * This method searches for a character in the current location,
     * checks whether communication is possible based on shared languages,
     * and displays the character's dialogue if successful.
     * </p>
     *
     * @param player the player executing the command
     * @param game the current game instance
     */
    @Override
    public void execute(Player player, Game game) {

        Location location = player.getCurrentLocation();

        // Find the target character
        NPC target = null;
        for (NPC c : location.getCharacters()) {
            if (c.getName().equalsIgnoreCase(characterName)) {
                target = c;
                break;
            }
        }

        if (target == null) {
            System.out.println("There is no one named '" + characterName + "' here.");
            game.handleActionCost(COST);
            return;
        }

        // Check if player understands ANY language the character can speak
        boolean canCommunicate = false;
        for (Language lang : target.getLanguages()) {
            if (player.canUnderstand(lang)) {
                canCommunicate = true;
                break;
            }
        }

        if (!canCommunicate) {
            System.out.println(target.getName() + " speaks these languages: "+target.getLanguages());
            System.out.println("You can understand these languages: "+player.getLanguages());
            game.handleActionCost(COST);
            return;
        }

        // Successful communication
        System.out.println(target.talk(player));
        game.handleActionCost(COST);
    }
}
