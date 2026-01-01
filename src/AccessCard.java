public class AccessCard extends Item {

    public AccessCard() {
        super("AccessCard", "You can enter locked coaches by this card.\nif you use it you can unlock it forever.");
    }


    @Override
    public boolean use(Player player) {
        Location location = player.getCurrentLocation();

        if (location.isLocked()) {
            location.unlock();
            System.out.println("You unlocked the coach! now you have access to any item there anytime");
            System.out.println(location.getDescription());
            return true;  // meaningful action performed
        }
        return false; // no effect
    }
}
