public class Mechanic extends Character {

    public Mechanic() {
        super("Mechanic", false); // cannot trade in version 1

        // The mechanic speaks English(for version 1)
        addLanguage(Language.FRENCH);
    }

    @Override
    public String talk(Player player) {
        return "The engine is broken! If you have a wrench, you can fix it.";
    }

    @Override
    public String examine(Player player) {
        return "A hardworking mechanic covered in grease, focused on repairing the engine.";
    }
}
