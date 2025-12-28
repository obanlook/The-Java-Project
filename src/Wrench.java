public class Wrench extends Item {

    public Wrench() {
        super("Wrench", "A sturdy tool used to tighten bolts and repair machinery.");
    }

    @Override
    public String examine() {
        return "A heavy wrench. The mechanic could probably use this to fix the engine.";
    }

    @Override
    public boolean use(Player player) {
        Location location = player.getCurrentLocation();

        // Only works in Engine Coach
        if (location instanceof EngineCoach engineCoach) {

//            if (engineCoach.isFixed()) {
//                System.out.println("The engine is already fixed.");
//                return false;
//            }

            // Fix the engine
            engineCoach.fixEngine();
            System.out.println("You tighten the bolts carefully with the wrench...");
            System.out.println("The engine rumbles back to life! You fixed it!");

            return true;
        }

        System.out.println("There is nothing here that you can fix with a wrench.");
        return false;
    }
}
