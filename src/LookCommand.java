public class LookCommand implements Command {

    private static final int COST = 0;


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

