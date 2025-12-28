import java.util.List;

public class Dictionary extends Item {

    public Dictionary() {
        super("Dictionary", "A French to English dictionary.\nIt will cost you 2 turns but you can talk to any french person.");
    }

    @Override
    public String examine() {
        return "A precise dictionary. It will cost you 2 turns but you can talk to any french person.";
    }

    @Override
    public boolean use(Player player) {
        Location location = player.getCurrentLocation();
        List<Character> characters = location.getCharacters();
        for(Character character : characters) {
            if(character.canSpeak(Language.FRENCH)){
                character.addLanguage(Language.ENGLISH);
                System.out.println("Character '"+character.getName()+"' can understand English now!");
                return true;
            }

        }
        System.out.println("No one here speaks French to use the dictionary!");
        return false;//no effect
    }
}
