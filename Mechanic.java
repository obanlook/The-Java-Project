public class Mechanic extends NPC {

    public Mechanic() {
        super("Mechanic");
        addLanguage(Language.FRENCH);
    }

    @Override
    public String talk(Player player) {
        return "The engine is broken! If you have a wrench, you can fix it.";
    }

}
