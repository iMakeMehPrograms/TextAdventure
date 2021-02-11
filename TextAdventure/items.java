package TextAdventure;
import TextAdventure.entities.*;
import java.util.*;
public class items {

    String type;
    String name;
    double stat;

  public items(String itemName, double itemStat, String itemType) {
    type = itemType;
    name = itemName;
    stat = itemStat;
  }

  static public items wt = new items("Weirdthing", 0.025, "atk");
  static public items cw = new items("Cheesewheel", 0.015, "df");
  static public items map = new items("Map of Normalness", 0.0, "map");
  static public items br = new items("Broken Trap", 0.0, "jn");
  static public items hd = new items("Hard Drill", 0.04, "atk");
  static public items wmt = new items("Wormtamer", 0.048, "atk");
  static public items bc = new items("Bomb Casing", 0.05, "df");
  static public items lb = new items("L Block", 0.058, "atk");
  static public items tw = new items("Twig", 0.05, "atk");
  static public items ws = new items("Wood Shield", 0.058, "df");
  static public items pd = new items("Perseus's Sword (of Dirt)", 0.1, "atk");
  static public items ps = new items("Plasmasword Version 3.0", 0.8, "atk");

    public static int itemsPickedUp = 0;
    public static int totalItems = 8;
    
    // put all equipment in here
    public static void investigate() {
        player.inventory = correctInventory(player.inventory);
        double rand = Math.random();
        if (rand > 0.8) {
            player.hp = player.hp - 1;
            player.inventory.add(br);
            System.out.println("You found a trap! -1 HP!");
            if (player.hp <= 0) {
                room.lose();
            }
        } else if (rand < 0.8 && rand > 0.2) {
            player.inventory.add(map);
            System.out.println("You got a Map of Normalness!");
        } else if (rand > 0.1 && rand < 0.2) {
            player.inventory.add(cw);
            System.out.println("You got a Cheesewheel!");
        } else {
            if (game.eightiesMode == false) {
                player.hp = player.hp - 1;
                player.inventory.add(br);
                System.out.println("You found a trap! -1 HP!");
                if (player.hp <= 0) {
                    room.lose();
                }
            } else {
                player.inventory.add(wt);
                System.out.println("You got a Weirdthing!");
            }
        }
        player.inventory = correctInventory(player.inventory);
        changeStats();
    }

    public static void checkInventory() {
        player.inventory = correctInventory(player.inventory);
        changeStats();
        if (!game.eightiesMode) {
            if (player.inventory.size() <= 0) {
                System.out.println("You don't have anything in your inventory!");
            } else {
                String message = "In your inventory you have: ";
                for (int i = 0; i < player.inventory.size(); i++) {
                    items obj = player.inventory.get(i);
                    message = message.concat("a " +obj.name+", ");
                }
                System.out.println(message+ "and that's it!");
            }
        } else {
            if (player.inventory.size() <= 0) {
                System.out.println("You don't have anything in your rad inventory yo!");
            } else {
                String message = "In your bodacious inventory you have: ";
                for (int i = 0; i < player.inventory.size(); i++) {
                    items obj = player.inventory.get(i);
                    message = message.concat("a "+obj.name+", ");
                }
                System.out.println(message+ "and that's it!");
            }
        }
    }
    public static ArrayList<items> correctInventory(ArrayList<items> list) {
  // from https://www.geeksforgeeks.org/how-to-remove-duplicates-from-arraylist-in-java/ , slightly modified
  // Function to remove duplicates from an ArrayList
  

    // Create a new LinkedHashSet
    Set<items> set = new LinkedHashSet<>();

    // Add the elements to set
    set.addAll(list);

    // Clear the list
    list.clear();

    // add the elements of set
    // with no duplicates to the list
    list.addAll(set);

    // return the list
    return list;

    }
    public static void changeStats() {
        double atk = 1;
        double df = 0;
        for (int i = 0; i < player.inventory.size(); i++) {
            items obj = player.inventory.get(i);
            switch (obj.type) {
                case "atk":
                atk = atk + obj.stat;
                break;
                case "df":
                df = df + obj.stat;
                break;
                case "map":
                room.monOn = true;
                break;
                case "jn":
                // Does nothing
                break;
            }
        }
        player.atck = atk;
        player.df = df;
    }
}