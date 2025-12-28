public class OldMan extends Character {

    public OldMan() {
        super("OldMan", false);


        addLanguage(Language.FRENCH);
    }

    @Override
    public String talk(Player player) {
        return "The engine coach is at the end of the train";
    }

    @Override
    public String examine(Player player) {
        return "Gives an early hint about the mechanic, but you must use the dictionary to understand him.";
    }
}
