public class TalkCommand implements Command {

    private static final int COST = 1;
    private final String characterName;

    public TalkCommand(String characterName) {
        this.characterName = characterName;
    }

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
