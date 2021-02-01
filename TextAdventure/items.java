package TextAdventure;
import TextAdventure.entities.*;
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
    public static int totalItems = 7;
    
    // put all equipment in here
    public static void investigate() {
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
    }

    public static void checkInventory() {
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
    public static void correctInventory() {
        for (int i = 0; i < player.inventory.size(); i++) {
            items obj = player.inventory.get(i);
            System.out.println(obj.name);
            for (int o = i; o < player.inventory.size(); o++) {
                if (player.inventory.get(o) == obj) {
                    player.inventory.remove(o);
                    System.out.println(player.inventory.get(o).name + " was deleted at position " + o);
                }
            }
        }
        checkInventory();
    }
    public static void changeStats() {
        for (int i = 0; i < player.inventory.size(); i++) {
            items obj = player.inventory.get(i);
            switch (obj.type) {
                case "atk":
                player.atck = player.atck + obj.stat;
                break;
                case "df":
                player.df = player.df + obj.stat;
                break;
                case "map":
                room.monOn = true;
                break;
                case "jn":
                // Does nothing
                break;
            }
        }
    }
}