public class OldMan extends NPC {

    public OldMan() {
        super("OldMan");
        addLanguage(Language.SPANISH);
    }

    @Override
    public String talk(Player player) {
        return "The engine coach is at the end of the train";
    }

}
