public class Conductor extends Character {

    public Conductor() {
        super("Conductor", false);


        addLanguage(Language.FRENCH);

    }

    @Override
    public String talk(Player player) {
        return "Welcome. The mechanic is ahead in the engine coach.";
    }

    @Override
    public String examine(Player player) {
        return "A uniformed conductor checking the compartments and ensuring everything is in order.";
    }
}
