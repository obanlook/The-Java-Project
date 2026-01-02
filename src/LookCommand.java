/**
 * The LookCommand class represents a command that allows the player
 * to observe their current location.
 * <p>
 * When executed, this command displays information about the current
 * location, including its description, visible items, characters,
 * and available exits, provided the player can see.
 * </p>
 */
public class LookCommand implements Command {

    /**
     * The action cost associated with executing this command.
     */
    private static final int COST = 0;

    /**
     * Executes the look command.
     * <p>
     * This method checks whether the player can see in the current location.
     * If visibility conditions are met, it prints detailed information
     * about the location.
     * </p>
     *
     * @param player the player executing the command
     * @param game the current game instance
     */
    @Override
    public void execute(Player player, Game game) {
        Location location = player.getCurrentLocation();
        if(!location.canSee()){
            System.out.println("this coach is dark! Maybe you need a light to see what's here!");
            return;
        }
        // if the location itself is dark only if candle is inside this location, the coach will be visible
        if(location.isDark()){
            boolean light = false;
            for(Item item: location.getGroundItems()){
                if(item.getName().equalsIgnoreCase("candle")){
                    light = true;
                    break;
                }
            }
            if(!light){
                System.out.println("You need a light to see what's here!");
                return;
            }
        }
        System.out.println("location:\n" + location.getName());
        System.out.println("Description:\n" + location.getDescription());
        System.out.println("Ground Items:\n"+ location.showGroundItems());
        System.out.println("Characters:\n"+ location.showCharacters());
        System.out.println("Exits:\n"+ location.showExits());

        game.handleActionCost(COST);
    }
}
