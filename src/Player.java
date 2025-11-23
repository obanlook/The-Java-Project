public class Player {
    private Game game;
    private int timeRemaining = 30;
    private Language language = Language.ENGLISH;
    private Location currentLocation = null;
    private Inventory inventory;

    public Player(Game game){
        this.game = game;

    }

    public Location getCurrentLocation() {
        return currentLocation;
    }
}
