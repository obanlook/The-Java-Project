import java.util.Scanner;

/**
 * The Game class represents the main controller of the game.
 * <p>
 * It is responsible for initializing the game world, handling the game loop,
 * processing player commands, and managing win/lose conditions.
 * </p>
 */
public class Game {

    /**
     * The player currently playing the game.
     */
    private Player player;

    /**
     * The command parser responsible for interpreting user input.
     */
    private CommandParser commandParser;

    /**
     * The win condition that determines when the game is won.
     */
    private WinCondition winCondition;

    /**
     * The current state of the game.
     */
    private GameState gameState;

    /**
     * Constructs a new Game instance and initializes the game world.
     */
    public Game() {
        setupWorld();//initialize the locations, items, characters and player
        commandParser = new CommandParser(this);
        gameState = GameState.PLAYING;
    }

    /**
     * Starts the game by displaying the introduction and entering the game loop.
     */
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

    /**
     * Runs the main game loop.
     * <p>
     * The loop continues while the game state is PLAYING.
     * Player commands are read, executed, and checked for win or loss conditions.
     * </p>
     */
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
            //https://docs.oracle.com/en/java/javase/14/language/switch-expressions.html#GUID-BA4F63E3-4823-43C6-A5F3-BAA4A2EF3ADC
            case WON  -> System.out.println("You Won!");
            case LOST -> System.out.println("You Lost!\nTime is over!");
            case QUIT -> System.out.println("You Quit!\nDo you want to try again?");
        }
    }

    /**
     * Sets up the game world.
     * <p>
     * This includes creating locations, connecting them,
     * placing items and characters, and initializing the player.
     * </p>
     */
    public void setupWorld() {

        // Create locations
        EconomyCoach economyCoach = new EconomyCoach();
        FamilyCoach familyCoach = new FamilyCoach();
        CafeCoach cafeCoach = new CafeCoach();
        ServiceCoach serviceCoach = new ServiceCoach();
        EngineCoach engineCoach = new EngineCoach();

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
        player = new Player(economyCoach); // starting point

        // game changer location
        this.winCondition = engineCoach;// since the player will win here
    }

    /**
     * Sets the current state of the game.
     *
     * @param gameState the new game state
     */
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * Processes a raw command string entered by the player.
     *
     * @param stringCommand the raw command input
     * @return the parsed Command object
     */
    public Command processCommand(String stringCommand) {
        return commandParser.parse(stringCommand);
    }

    /**
     * Updates the player's remaining time based on an action cost.
     *
     * @param cost the time cost of the action
     */
    public void handleActionCost(int cost) {
        player.setTimeRemaining(player.getTimeRemaining() - cost);
    }

    /**
     * Checks whether the win condition has been satisfied.
     * If so, the game state is set to WON.
     */
    public void checkWin() {
        boolean win = winCondition.isSatisfied();
        if (win) {
            gameState = GameState.WON;
        }
    }

    /**
     * Checks whether the player has lost the game.
     * <p>
     * The player loses if the remaining time is zero or less.
     * </p>
     */
    public void checkLose() {
        int time = player.getTimeRemaining();
        if (time <= 0) {
            gameState = GameState.LOST;
        }
    }
}
