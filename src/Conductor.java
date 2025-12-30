public class Conductor extends NPC {

    public Conductor() {
        super("Conductor");
        addLanguage(Language.FRENCH);

    }

    @Override
    public String talk(Player player) {
        return "Welcome. The mechanic is ahead in the engine coach.";
    }

}
