public class Candle extends Item {

    public Candle() {
        super("Candle", "A candle that helps you see in dark coaches.");
    }


    @Override
    public boolean use(Player player) {
        Location location = player.getCurrentLocation();
        //after using candle, the candle is not in inventory
        player.getInventory().removeItem(this);
        //candle is a groundItem in that location
        location.addItem(this);
        //the effect of using candle
        if (location.isDark()) {
            location.enlighten();
            System.out.println("You turned on the Candle. The darkness fades away...");
            System.out.println(location.getDescription());
            return true;  // meaningful action performed
        }

        System.out.println("That coach was not dark!");
        return false; // no effect
    }
}
