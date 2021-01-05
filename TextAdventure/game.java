package TextAdventure;
import java.util.*;
import TextAdventure.entities.*;
public class game {
public static int mode = 0;
public static boolean eightiesMode = false;
public static boolean gameEnded = false;
private static boolean debugModeUnlocked = false;
public static boolean view = false;
    //public game () {} not this

    static enemy radputer = new enemy("rad\'puter", 3, 0.33, enemy.enemyASCII[0], "Hard Drill#");
    static enemy sandworm = new enemy("sandworm", 4, 0.44, enemy.enemyASCII[1], "Wormtamer#");
    static enemy boombox = new enemy("boombox", 4, 0.50, enemy.enemyASCII[2], "Bomb Casing#");
    static enemy tetrimino = new enemy("l tetrimino", 6, 0.60, enemy.enemyASCII[3], "L Block#");
    static enemy twiglet = new enemy("twiglet", 1, 0.25, enemy.enemyASCII[4], "twig#");
    static enemy branchlet = new enemy("branchlet", 2, 0.33, enemy.enemyASCII[5], "Wood Shield#");
    static enemy tree = new enemy("tree.", 3, 0.33, enemy.enemyASCII[6], "Perseus's Sword (of Dirt)#");
    static enemy metalkiller = new enemy("Metal Killer", 5, 0.50, enemy.enemyASCII[7], "Plasmasword Ver 3.0#");

    public static void run(int debugLevel) {
        if (debugLevel == 1) {
            debugModeUnlocked = true;
        }
        mode = debugLevel;
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" _____  ________  _ _____  ____  ____  _     _____ _      _____  _     ____  _____");
        System.out.println("/__ __\\/  __/\\  \\///__ __\\/  _ \\/  _ \\/ \\ |\\/  __// \\  /|/__ __\\/ \\ /\\/  __\\/  __/");
        System.out.println("  / \\  |  \\   \\  /   / \\  | / \\|| | \\|| | //|  \\  | |\\ ||  / \\  | | |||  \\/||  \\  ");
        System.out.println("  | |  |  /_  /  \\   | |  | |-||| |_/|| \\// |  /_ | | \\||  | |  | \\_/||    /|  /_ ");
        System.out.println("  \\_/  \\____\\/__/\\\\  \\_/  \\_/ \\|\\____/\\__/  \\____\\\\_/  \\|  \\_/  \\____/\\_/\\_\\\\____\\");
        System.out.println("Hello, and welcome to TextAdventure!");
        System.out.println("Select an option.");
        System.out.println("");
        System.out.println("[1]: Start Game");
        System.out.println("[2]: How to Play");
        System.out.println("[3]: Cheat Mode");
        System.out.println("[0]: Quit");
        System.out.println("");


        System.out.print("Which would you like: ");
        String option = keyboard.nextLine();
        
        System.out.println();
        switch (option) {
        case "1":
        System.out.println("Starting Game!");
        System.out.println("WARNING: If you do not press a number that is not one of the options and enter it, the game will reset. This is everywhere and is a thing I cannot fix.");
        System.out.println("You have been warned. (0 is always an anwser, but this will quit the game anyways)");
        PDS(false);
        break;
        case "2":
        System.out.println("How to play:");
        System.out.println("Press the number of the option you would like to select, then press return to confirm it!");
        System.out.println("Once you have finished the game you will unlock Cheat Mode.");
        System.out.println("Also, you can quit at any time by entering 0.");
        System.out.println("That's it!");
        System.out.println("");
        System.out.print("Press anything to go back: ");
        option = keyboard.nextLine();
        System.out.println("");
        if (option.equals("0")) {
            System.out.println("Quiting");
            System.exit(1);
        } else {
            run(debugLevel);
        }
        break;
        case "3":
        if (debugModeUnlocked) {
        System.out.println("Starting Cheat Mode!");
        System.out.println("WARNING: If you do not press a number that is not one of the options and enter it, the game will reset. This is everywhere and is a thing I cannot fix.");
        System.out.println("You have been warned. (0 is always an anwser, but this will quit the game anyways)");
        PDS(true);
        } else {
            System.out.println("I'm sorry, but you have to get a 100% first.");
            run(debugLevel);
        }
        break;
        case "0":
        System.out.println("Quiting");
        System.exit(1);
        break;
        default:
        System.out.println("I don't understand. Try again");
        run(debugLevel);
        break;
        }
    }

    public static void PDS(boolean isDebug) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Time to create your character.");
        System.out.print("Enter your name (under 24 characters): ");
        String option = keyboard.nextLine();
        System.out.println();

        if (option.length() < 24) {
        switch (option) {
        case "0":
        System.out.println("Quiting");
        System.exit(1);
        break;
        default:
        break;
        }
    } else {
        System.out.println("I'm sorry, your name is over 24 characters, try again.");
        PDS(isDebug);
    }
        player.traits.add(option);
        System.out.println("Hello " + player.traits.get(0) + ". Now, select a gender.");
        System.out.println("");
        System.out.println("[1]: Male");
        System.out.println("[2]: Female");
        System.out.println("");
        System.out.print("Which one: ");
        option = keyboard.nextLine();
        System.out.println("");
        
        switch (option) {
        case "0":
        System.out.println("Quiting");
        System.exit(1);
        break;
        case "1":
            player.traits.add("male");
        break;
        case "2":
            player.traits.add("female");
        break;
        default:
        System.out.println("I don't understand. Try again");
        run(mode);
        break;
        }
        if (player.traits.get(1).equals("male")) {
            System.out.println("Next, " + player.traits.get(0) + ", son of [UNKNOWN]. Now, select a hair color.");
        } else {
            System.out.println("Next, " + player.traits.get(0) + ", daughter of [UNKNOWN], select a hair color.");
        }


        System.out.println("");
        System.out.println("[1]: Blond");
        System.out.println("[2]: Brown");
        System.out.println("[3]: Black");
        System.out.println("");
        System.out.print("Which one: ");
        option = keyboard.nextLine();
        System.out.println("");

        switch (option) {
        case "0":
        System.out.println("Quiting");
        System.exit(1);
        break;
        case "1":
            player.traits.add("blond");
        break;
        case "2":
            player.traits.add("brown");
        break;
        case "3":
            player.traits.add("black");
        break;
        default:
        System.out.println("I don't understand. Try again");
        run(mode);
        break;
        }
        System.out.println("Now, do you have a mullet?");
        System.out.println("");
        System.out.println("[1]: Yes");
        System.out.println("[2]: No");
        System.out.println("");
        System.out.print("Y/N: ");
        option = keyboard.nextLine();
        System.out.println("");
        switch (option) {
        case "0":
        System.out.println("Quiting");
        System.exit(1);
        break;
        case "1":
            eightiesMode = true;
        break;
        case "2":
            eightiesMode = false;
        break;
        default:
        System.out.println("I don't understand. Try again");
        run(mode);
        break;
        }
        
        if (eightiesMode == true) {
        System.out.println("Are you sure?");
        System.out.println("");
        System.out.println("[1]: Yes");
        System.out.println("[2]: No");
        System.out.println("");
        System.out.print("Y/N: ");
        option = keyboard.nextLine();
        System.out.println("");
        switch (option) {
        case "0":
        System.out.println("Quiting");
        System.exit(1);
        break;
        case "1":
            startGame(true, isDebug);
        break;
        case "2":
            eightiesMode = false;
        break;
        }
    }
 if (eightiesMode == false) {
    System.out.println("Which Thing do you prefer?");
    System.out.println("");
    System.out.println("[1]: Thing 1");
    System.out.println("[2]: Thing 2");
    System.out.println("");
    System.out.print("1 or 2: ");
    option = keyboard.nextLine();
    System.out.println("");
    switch (option) {
        case "0":
            System.out.println("Quiting");
            System.exit(1);
            break;
        case "1":
            player.traits.add("thing 1");
            break;
        case "2":
            player.traits.add("thing 2");
            break;
        default:
            System.out.println("I don't understand. Try again");
            run(mode);
            break;
    }
    startGame(false, isDebug);
    }
}


    public static void startGame (boolean isEighties, boolean isDebug) {
        player.traits.add(""); // move count of rooms
        player.traits.add(""); // monsters killed
        player.traits.add("");
        Scanner keyboard = new Scanner(System.in);
        String option = "null";
        if (isEighties == true) {
            System.out.println("______________                            _________                      __________              _____     _________");
            System.out.println("__( __ )_  __ \\_______   _______ _______________  /____     ______ ________  /___(_)__   _______ __  /___________  /");
            System.out.println("_  __  |  / / /_  ___/   __  __ `__ \\  __ \\  __  /_  _ \\    _  __ `/  ___/  __/_  /__ | / /  __ `/  __/  _ \\  __  / ");
            System.out.println("/ /_/ // /_/ /_(__  )    _  / / / / / /_/ / /_/ / /  __/    / /_/ // /__ / /_ _  / __ |/ // /_/ // /_ /  __/ /_/ / ");
            System.out.println("\\____/ \\____/ /____/     /_/ /_/ /_/\\____/\\__,_/  \\___/     \\__,_/ \\___/ \\__/ /_/  _____/ \\__,_/ \\__/ \\___/\\__,_/");
            while (!gameEnded) {
               option = keyboard.nextLine();
               if (option.equals("0")) {
                   System.exit(1);
               }
            }
        } else {
            while (!gameEnded) {
                option = keyboard.nextLine();
                if (option.equals("0")) {
                    System.exit(1);
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length > 1 && args[1].equals("80smode")) {
            eightiesMode = true;
        }
        if (args.length > 0) {
            switch (args[0]) {
                case "debugmodeunlocked":
                run(1);
                break;
                case "win":
                room.win();
                break;
                case "lose":
                room.lose();
                break;
                case "asciiview":
                enemy.printArt(metalkiller);
                break;
            }
        } else {
            run(0);
        }
    }
}