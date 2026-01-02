/**
 * The Candle class represents an item that can be used to remove darkness
 * from dark coaches.
 * <p>
 * When used, the candle is removed from the player's inventory, placed
 * in the current location, and may illuminate the coach if it is dark.
 * </p>
 */
public class Candle extends Item {

    /**
     * Constructs a Candle item with a predefined name and description.
     * The description indicates that the candle helps the player see
     * in dark coaches.
     */
    public Candle() {
        super("Candle", "A candle that helps you see in dark coaches.");
    }

    /**
     * Uses the candle in the player's current location.
     * <p>
     * The candle is removed from the player's inventory and added to the
     * current location. If the location is dark, it is illuminated and
     * the location description is displayed.
     * </p>
     *
     * @param player the player using the candle
     * @return {@code true} if the location was dark and successfully illuminated,
     *         {@code false} if the location was not dark
     */
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
