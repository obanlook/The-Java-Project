import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html

/**
 * The CommandParser class is responsible for parsing raw user input
 * and converting it into executable Command objects.
 * <p>
 * It validates commands, extracts command keywords and arguments,
 * and returns the appropriate Command instance. If the input is invalid
 * or unrecognized, an UnknownCommand is returned.
 * </p>
 */
public class CommandParser {

    /**
     * Reference to the game instance.
     * This allows commands to interact with the current game state.
     */
    private final Game game;

    /**
     * A set of all valid command keywords recognized by the parser.
     */
    private static final Set<String> VALID = new HashSet<>(
            Arrays.asList("go", "look", "inventory", "help", "take","drop", "talk", "use", "quit", "status","explain")
    );

    /**
     * Constructs a CommandParser with a reference to the game.
     *
     * @param game the current game instance
     */
    public CommandParser(Game game) {
        this.game = game;
    }

    /**
     * Parses a full input line entered by the player.
     * <p>
     * The input is trimmed, converted to lowercase, and split into parts.
     * The first part is treated as the command verb, while subsequent parts
     * may act as arguments depending on the command.
     * </p>
     * <p>
     * This method always returns a Command object. If the input is invalid,
     * empty, or unrecognized, an UnknownCommand is returned.
     * </p>
     *
     * @param input the raw input string entered by the player
     * @return a Command corresponding to the parsed input
     */
    public Command parse(String input) {
        //if the input was space or enter only with no actual character
        if (input == null || input.isBlank())
            return new UnknownCommand();

        // to delete the redundant spaces from the beginning and last
        input = input.trim().toLowerCase();

        String[] parts = input.split("\\s+");// split the input into two parts by space(s) e.g: "go north" and "go      north" -> part[0] = go, part[1] = north
        String verb = parts[0];

        if (!VALID.contains(verb))//check if the first part is valid
            return new UnknownCommand();

        switch (verb) {
            //commands with only one part and no need of object
            case "look":
                return new LookCommand();

            case "inventory":
                return new InventoryCommand();

            case "help":
                return new HelpCommand();

            case "status":
                return new StatusCommand();

            case "quit":
                return new QuitCommand();

            case "explain":
                return new ExplainCommand();

            //commands with two parts like go north, take Wrench
            case "go":
                if (parts.length < 2) return new UnknownCommand();
                Direction dir = Direction.fromString(parts[1]);// fromString("north") -> Direction.NORTH
                if (dir == null) return new UnknownCommand();// if dir was not direction but also not null, fromString will give null
                return new MoveCommand(dir);

            case "take":
                if (parts.length < 2) return new UnknownCommand();
                return new TakeCommand(parts[1]);

            case "use":
                if (parts.length < 2) return new UnknownCommand();
                return new UseCommand(parts[1]);

            case "talk":
                if (parts.length < 2) return new UnknownCommand();
                return new TalkCommand(parts[1]);

            case "drop":
                if (parts.length < 2) return new UnknownCommand();
                return new DropCommand(parts[1]);
        }

        // fallback
        return new UnknownCommand();
    }
}
