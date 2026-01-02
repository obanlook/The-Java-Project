// https://www.baeldung.com/java-enum-values

/**
 * The Direction enum represents the possible movement directions
 * available in the game.
 * <p>
 * Each direction is associated with a lowercase string name that
 * corresponds to user input.
 * </p>
 */
public enum Direction {
    NORTH("north"), SOUTH("south"), EAST("east"),//wall
    WEST("west");//wall

    /**
     * The string representation of the direction.
     */
    public final String name;

    /**
     * Constructs a Direction with the given string name.
     * <p>
     * In enums, constructors are implicitly private and can only be
     * called by the enum itself.
     * </p>
     *
     * @param name the string value associated with the direction
     */
    private Direction(String name) {
        this.name = name;
    }

    /**
     * Converts a string into a corresponding Direction value.
     * <p>
     * The input string is trimmed and converted to lowercase before
     * comparison.
     * </p>
     *
     * @param name the string representation of a direction
     * @return the matching Direction, or {@code null} if no match is found
     */
    public static Direction fromString(String name) {
        if (name == null) return null;
        name = name.trim().toLowerCase();
        for (Direction d : Direction.values()) {
            if (d.name.equals(name)) return d;
        }
        return null;
    }
}
