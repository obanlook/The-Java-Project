import java.util.List;

public class Dictionary extends Item {

    public Dictionary() {
        super("Dictionary", "A French to English dictionary.\nIt will cost you 2 turns but you can talk to any french person.");
    }

    //we assume that the NPC will learn and remember the phrase after first time using the dictionary
    // (no need to use dictionary again for saying the same sentence.)
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
