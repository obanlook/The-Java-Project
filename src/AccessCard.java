/**
 * The AccessCard class represents a reusable access card that allows
 * the player to temporarily unlock locked coaches.
 * <p>
 * Using the access card unlocks an adjacent locked coach, moves the
 * player into it immediately, and grants access for a single traversal.
 * Once the player exits the coach, it becomes locked again.
 * </p>
 */

public class AccessCard extends Item {

    /**
     * Constructs an AccessCard with a predefined name and description.
     * The description explains the purpose and permanent effect of the card.
     */
    public AccessCard() {
        super("AccessCard", "You can enter locked coaches by this card.\nif you use it you can unlock it forever.");
    }

    /**
     * Uses the access card to temporarily unlock a nearby locked coach.
     * <p>
     * The card can only be used when the player is not already inside
     * a locked coach. If a locked adjacent coach exists, it is unlocked
     * temporarily and the player is moved into it immediately.
     * </p>
     *
     * @param player the player using the access card
     * @return {@code true} if a locked coach was successfully unlocked
     *         and entered, {@code false} otherwise
     */
    @Override
    public boolean use(Player player) {

        Location current = player.getCurrentLocation();

        // Cannot unlock from inside
        if (current.isLocked()) {
            System.out.println("You are already inside this coach.");
            return false;
        }

        for (Direction dir : Direction.values()) {
            Location next = current.getExit(dir);

            if (next != null && next.isLocked()) {

                next.temporarilyUnlock();
                player.moveTo(next);

                System.out.println("You swipe the Access Card...");
                System.out.println("The door unlocks temporarily.");
                System.out.println("You enter: " + next.getName());
                System.out.println(next.getDescription());

                return true;
            }
        }

        System.out.println("There is no locked coach here to unlock.");
        return false;
    }



}
