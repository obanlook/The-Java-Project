import java.util.HashMap;
import java.util.Map;

public class CommandParser {
    private Game game;
    private static Map<String, Command> validCommands;
    private static Map<String, Integer> commandCosts;


    public CommandParser(Game game){
        this.game = game;
        validCommands = new HashMap<>(Map.of(
                "go", new MoveCommand(),
                "talk", new TalkCommand()
        ));
        commandCosts = new HashMap<>();
    }


    public Command pareCommand(String commandName) {
        return validCommands.get(commandName);
    }

    public String executeCommand(String commandName) {
        Command cmd = validCommands.get(commandName);
        return "a sarcastic message!";
    }

    public int getCostForCommand(String commandName) {
        return commandCosts.get(commandName);
    }

    public String getHelp(){
        return "hint:";
    }

}
