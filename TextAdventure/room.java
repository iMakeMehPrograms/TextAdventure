package TextAdventure;
import java.util.*;
import TextAdventure.entities.*;
public class room {
    static int[] roomNumbering = {0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8};
    public static String[] roomType = {"M", "P", "G",
                                       "C", "N", "M",
                                       "M", "C", ""};
    static String[] doors = {"0:1", "1:2", "0:3", "1:4", "2:5"};
    static String roomState = "start";
    public static int currentRoom = 3;
    public static boolean monOn = false;

    public static void win() {
        if (game.eightiesMode == false) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("          _______                      _______  _        _ ");
            System.out.println("|\\     /|(  ___  )|\\     /|  |\\     /|(  ___  )( (    /|( )");
            System.out.println("( \\   / )| (   ) || )   ( |  | )   ( || (   ) ||  \\  ( || |");
            System.out.println(" \\ (_) / | |   | || |   | |  | | _ | || |   | ||   \\ | || |");
            System.out.println("  \\   /  | |   | || |   | |  | |( )| || |   | || (\\ \\) || |");
            System.out.println("   ) (   | |   | || |   | |  | || || || |   | || | \\   |(_)");
            System.out.println("   | |   | (___) || (___) |  | () () || (___) || )  \\  | _ ");
            System.out.println("   \\_/   (_______)(_______)  (_______)(_______)|/    )_)(_)");

            System.out.println("[1]: Menu");
            System.out.println("[2]: Stats");
            System.out.println("[0]: Quit");
            System.out.print("Which one: ");
            String option = keyboard.nextLine();
            System.out.println("");
            
            switch (option) {
                case "1":
                player.traits.clear();
                player.roomsVisited = 0;
                player.monstersKilled = 0;
                currentRoom = 3;
                game.run(0);
                break;
                case "2":
                    System.out.println("STATS:");
                    System.out.println("Monsters Killed: " + player.monstersKilled + "/" + enemy.totalMonsters);
                    System.out.println("Rooms Visited: " + player.roomsVisited + "/" + roomNumbering.length);
                    System.out.println("Items Unlocked: " + items.itemsPickedUp + "/" + items.totalItems);
                    System.out.println("Hard Mode On (\'80s Mode): " + game.eightiesMode);
                    int done = (player.roomsVisited + items.itemsPickedUp + player.monstersKilled);
                    int total = (roomNumbering.length + enemy.totalMonsters + items.totalItems + 1);
                    double percent = (100.0*done)/total;
                    System.out.println("Completion Rate: " + percent + "%");
                    System.out.print("Press anything to go back: ");
                    option = keyboard.nextLine();
                    System.out.println("");
                    if (option.equals("0")) {
                        System.out.println("Quiting");
                        System.exit(1);
                    } else {
                        win();
                    }
                break;
                case "0":
                System.exit(1);
                break;
                default:
                win();
                break;
            }

        } else {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("________       _________                ______   __  __                                       ______");
            System.out.println("___  __ \\_____ ______  /  _____  __________  /   _ \\/ /_________  __   ___      _________________  /");
            System.out.println("__  /_/ /  __ `/  __  /   __  / / /  __ \\_  /    __  /_  __ \\  / / /   __ | /| / /  __ \\_  __ \\_  / ");
            System.out.println("_  _, _// /_/ // /_/ /    _  /_/ // /_/ //_/     _  / / /_/ / /_/ /    __ |/ |/ // /_/ /  / / //_/  ");
            System.out.println("/_/ |_| \\__,_/ \\__,_/     _\\__, / \\____/(_)      /_/  \\____/\\__,_/     ____/|__/ \\____//_/ /_/(_)   ");

            System.out.println("[1]: Gnarly Menu!");
            System.out.println("[2]: Tubular Stats!");
            System.out.println("[0]: Gag me with a spoon!");
            System.out.print("Which one yo: ");
            String option = keyboard.nextLine();
            System.out.println("");

            switch (option) {
                case "1":
                    player.traits.clear();
                    player.roomsVisited = 0;
                    player.monstersKilled = 0;
                    game.eightiesMode = false;
                    currentRoom = 3;
                    game.run(0);
                    break;
                case "2":
                    System.out.println("TUBULAR STATS:");
                    System.out.println("Monsters Gagged with Spoons: " + player.monstersKilled + "/" + enemy.totalMonsters);
                    System.out.println("Rooms Blizted: " + player.roomsVisited + "/" + roomNumbering.length);
                    System.out.println("Items Bogarted: " + items.itemsPickedUp + "/" + items.totalItems);
                    System.out.println("Hard Mode On (\'80s Mode): " + game.eightiesMode);
                    int done = (player.roomsVisited + items.itemsPickedUp + player.monstersKilled + 1);
                    int total = (roomNumbering.length + enemy.totalMonsters + items.totalItems + 1);
                    double percent = (100.0 * done) / total;
                    System.out.println("Hotdogger Rate: " + percent + "%");
                    System.out.print("Press anything to go back: ");
                    option = keyboard.nextLine();
                    System.out.println("");
                    if (option.equals("0")) {
                        System.out.println("Gagging me with a spoon!");
                        System.exit(1);
                    } else {
                        win();
                    }
                    break;
                case "0":
                    System.out.println("Gagging me with a spoon!");
                    System.exit(1);
                    break;
                default:
                    win();
                    break;
            }
        }
    }

    
     public static void lose() {

        if (game.eightiesMode == false) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("___  _ ____  _       ____  _  _____ ____     ");
        System.out.println("\\  \\///  _ \\/ \\ /\\  /  _ \\/ \\/  __//  _ \\    ");
        System.out.println(" \\  / | / \\|| | ||  | | \\|| ||  \\  | | \\|    ");
        System.out.println(" / /  | \\_/|| \\_/|  | |_/|| ||  /_ | |_/|__  ");
        System.out.println("/_/   \\____/\\____/  \\____/\\_/\\____\\\\____/\\/  ");

        System.out.println("[1]: Menu");
        System.out.println("[0]: Quit");
        System.out.print("Which one: ");
        String option = keyboard.nextLine();
        System.out.println("");

        switch (option) {
            case "1":
            player.traits.clear();
            player.roomsVisited = 0;
            player.monstersKilled = 0;
            currentRoom = 3;
            game.run(0);
            break;
            case "0":
            System.exit(1);
            break;
            default:
            lose();
            break;
        }
    } else {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("_____.___.                              __                                            .___         .__  __  .__                                                  ._.     ");
        System.out.println("\\__  |   | ____  __ __     ____   _____/  |_     _________     ____   ____   ____   __| _/ __  _  _|__|/  |_|  |__   _____      ____________   ____   ____   ____| |     ");
        System.out.println(" /   |   |/  _ \\|  |  \\   / ___\\ /  _ \\   __\\   / ___\\__  \\   / ___\\ / ___\\_/ __ \\ / __ |  \\ \\/ \\/ /  \\   __\\  |  \\  \\__  \\    /  ___/\\____ \\ /  _ \\ /  _ \\ /    \\ |     ");
        System.out.println(" \\____   (  <_> )  |  /  / /_/  >  <_> )  |    / /_/  > __ \\_/ /_/  > /_/  >  ___// /_/ |   \\     /|  ||  | |   Y  \\  / __ \\_  \\___ \\ |  |_> >  <_> |  <_> )   |  \\|     ");
        System.out.println(" / ______|\\____/|____/   \\___  / \\____/|__|    \\___  (____  /\\___  /\\___  / \\___  >____ |   \\/\\_/ |__||__| |___|  / (____  / /____  >|   __/ \\____/ \\____/|___|  /_ /\\  ");
        System.out.println(" \\/                     /_____/               /_____/     \\//_____//_____/      \\/     \\/                        \\/       \\/       \\/ |__|                      \\/\\/ \\/  ");

        System.out.println("[1]: Gnarly Menu!");
        System.out.println("[0]: Gag me with a spoon again!");
        System.out.print("Which one yo: ");
        String option = keyboard.nextLine();
        System.out.println("");

        switch (option) {
            case "1":
            player.traits.clear();
            player.roomsVisited = 0;
            player.monstersKilled = 0;
            game.eightiesMode = false;
            currentRoom = 3;
            game.run(0);
            break;
            case "0":
            System.out.println("Gagging me with a spoon again!");
            System.exit(1);
            break;
            default:
            lose();
            break;
        }
    }
    }

    public static int findTypeCount(String type) {
    int count = 0;
    for (String roomtype : roomType) {
      if (type.equals(roomtype)) {
        count++;
      }
    }
    return count;
  }

    public static void move(int newRoom) {
        if (newRoom == currentRoom) {
            throw new IllegalArgumentException("You cannot move into a room you are already in!");
        }
        currentRoom = newRoom;
        switch(roomType[newRoom]) {
            // This is done from most likely to least likely.
            case "M":
            enemy.monsterfight(game.radputer);
            break;
            case "N":
            findAndDisplayRoomInformation(findMoveOptions(newRoom));
            break;
            case "P":
            findAndDisplayRoomInformation(findMoveOptions(newRoom));
            break;
            case "G":
            win();
            break;
            case "C":
            items.investigate();
            break;
            
        }
    };
     public static ArrayList<Integer> findMoveOptions(int currentRoom) {

        if (monOn) {
            System.out.println("");
            System.out.println("+---+---+---+");
            System.out.println("| 0 : 1 | 2 |");
            System.out.println("+-:-+-:-+-:-+");
            System.out.println("| 3 :4N | 5 |");
            System.out.println("+---+-:-+-:-+");
            System.out.println("| 6 : 7 :8N |");
            System.out.println("+---+---+---+");
            System.out.println("");
            System.out.println("N = a normal room.");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("+---+---+---+");
            System.out.println("| 0 : 1 | 2 |");
            System.out.println("+-:-+-:-+-:-+");
            System.out.println("| 3 | 4 | 5 |");
            System.out.println("+---+-:-+-:-+");
            System.out.println("| 6 : 7 : 8 |");
            System.out.println("+---+---+---+ ");
            System.out.println("");
        }

        final ArrayList<Integer> options = new ArrayList<Integer>();
        for (int i = 0; i < doors.length; i++) {
            if (doors[i].indexOf(Integer.toString(currentRoom)) > -1) {
               switch (doors[i].indexOf(Integer.toString(currentRoom))) {
                   case 0:
                   options.add(Integer.parseInt(Character.toString(doors[i].charAt(2))));
                   break;
                   case 2:
                   options.add(Integer.parseInt(Character.toString(doors[i].charAt(0))));
                   break;
                   default:
                   throw new IllegalArgumentException("String[] doors is not meant to have syntax " + doors[i]);
               } 
            } else if (doors[i].indexOf(Integer.toString(currentRoom)) == -1) {
            } else {
                throw new IllegalArgumentException("String[] doors is not meant to have syntax " + doors[i]);
            }
        }
        return options;
    }

    public static void findAndDisplayRoomInformation(ArrayList<Integer> moveOptions) {
        Scanner keyboard = new Scanner(System.in);
        int aord = 0;
        for (int idx = 0; idx < moveOptions.size(); idx++) {
            aord = idx + 1;
            System.out.println("[" + aord + "]: Move to room " + moveOptions.get(idx) + ".");
        }
        System.out.println("["+ (aord+1) + "]: Investigate the room.");
        System.out.println("["+ (aord+2) + "]: Check inventory.");
        System.out.print("What do you do: ");
        String answer = keyboard.nextLine();
        int bord = 0;
        boolean canInvestigate = true;
        for (int idx = 0; idx < moveOptions.size(); idx++)   {
            if (answer.equals(Integer.toString(idx+1))) {
                move(moveOptions.get(idx));
                canInvestigate = false;
            }
            bord = idx+2;
        }
        if (answer.equals(Integer.toString(bord))) {
            items.investigate();
        } else if (answer.equals(Integer.toString(bord+1)) && canInvestigate) {
            // add inventory check here
            items.checkInventory();
            } else {
                System.out.println("You don't have anything in your inventory.");
            }
        }
    }
