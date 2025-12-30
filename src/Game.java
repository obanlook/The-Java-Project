import java.util.Scanner;

public class Game {
    private Player player;
    private CommandParser commandParser;
    //since the state of the game depends on here
    private EngineCoach engineCoach;
    private GameState gameState;

    public Game() {
        setupWorld();//initialize the locations, items, characters and player
        commandParser = new CommandParser(this);
        gameState = GameState.PLAYING;


    }

    public void startGame() {

        //Game introduction
        System.out.println("Welcome to the Subway Survival Game!");

        System.out.println("Press enter to continue...");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        //explain the game
        Command explainCommand = new ExplainCommand();
        explainCommand.execute(player, this);
        //Commands introduction
        System.out.println("Press enter to see the valid commands...");
        input.nextLine();
        Command help = new HelpCommand();
        help.execute(player, this);
        //going to gameLoop to actually play the game
        gameLoop();

    }

    public void gameLoop() {
        Scanner input = new Scanner(System.in);
        while (gameState == GameState.PLAYING) {
            String stringCommand = input.nextLine();
            Command command = processCommand(stringCommand);
            command.execute(player, this);
            checkWin();
            checkLose();
        }
        switch (gameState) {
            case WON  -> System.out.println("You Won!");
            case LOST -> System.out.println("You Lost!\nTime is over!");
            case QUIT -> System.out.println("You Quit!\nDo you want to try again?");
        }


    }

    public void setupWorld() {

        // Create locations
        EconomyCoach economyCoach = new EconomyCoach();
        FamilyCoach familyCoach = new FamilyCoach();
        CafeCoach cafeCoach = new CafeCoach();
        ServiceCoach serviceCoach = new ServiceCoach();
        engineCoach = new EngineCoach();

        // Connect exits
        // cafe-economy-family-service-engine
        cafeCoach.setExit(Direction.NORTH, economyCoach);
        economyCoach.setExit(Direction.SOUTH, cafeCoach);
        economyCoach.setExit(Direction.NORTH, familyCoach);
        familyCoach.setExit(Direction.SOUTH, economyCoach);
        familyCoach.setExit(Direction.NORTH, serviceCoach);
        serviceCoach.setExit(Direction.SOUTH, familyCoach);
        serviceCoach.setExit(Direction.NORTH, engineCoach);
        engineCoach.setExit(Direction.SOUTH, serviceCoach);
        // Items
        //Cafe
        cafeCoach.addItem(new AccessCard());
        //Economy
        economyCoach.addItem(new Candle());
        //family
        familyCoach.addItem(new Dictionary());
        //Service
        serviceCoach.addItem(new Wrench());

        // Characters
        //Economy
        economyCoach.addNPC(new OldMan());
        //Service
        serviceCoach.addNPC(new Conductor());
        //Engine
        engineCoach.addNPC(new Mechanic());

        // Player setup
        player = new Player(this, economyCoach); // starting point

    }

    //for quitting to set the state into QUIT
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }


    public Command processCommand(String stringCommand) {
        return commandParser.parse(stringCommand);


    }

    //update time according to the actions
    public void handleActionCost(int cost) {

        player.setTimeRemaining(player.getTimeRemaining() - cost);
    }

    public void checkWin() {
        boolean win = engineCoach.isFixed();
        if (win) {
            gameState = GameState.WON;
        }

    }

    public void checkLose() {
        int time = player.getTimeRemaining();
        if (time <= 0) {
            gameState = GameState.LOST;
        }

    }


}
