// https://www.baeldung.com/java-enum-values
public enum Direction {
    NORTH("north"), SOUTH("south"), EAST("east"),//wall
    WEST("west");//wall
    public final String name;

    private Direction(String name) {
        this.name = name;
    }

    public static Direction fromString(String name) {
        if (name == null) return null;
        name = name.trim().toLowerCase();
        for (Direction d : Direction.values()) {
            if (d.name.equals(name)) return d;
        }
        return null;
    }


}
