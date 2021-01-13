package TextAdventure.entities;
import TextAdventure.*;
import java.util.*;
public class enemy extends entity {

  String[] asciiArt;
  String enemyName;
  double chance;
  int health;

  public enemy(String name, int hp, double hitChance, String[] art, String drop) {
    asciiArt = art;
    enemyName = name;
    chance = hitChance;
    health = hp;
  }

  static public void printArt(enemy obj) {
    for (String artline : obj.asciiArt) {
      System.out.println(artline);
    }
  }

  public static int totalMonsters = room.findTypeCount("M");

  public static final String[][] enemyASCII = { 
      {"_________", "| '80s  |", "|_______|", " /_____\\ " }, // rad'puter
      {"/-------------(/=","|<<<<<<<<<<<<<(}","\\-------------(\\="}, // sandworm
      {"[============]/","| # :+::+: # |","[============]"}, // boombox
      {"[=]","[=][=][=]"}, // ltetrimino
      /* '80s > Normal */
      {"\\/\\/\\/", " @\\/@ ", " /--\\ ", " /||\\ " }, // twiglet
      {"\\|^^|/", "|:)|", "|  |", "/--\\"}, // branchlet
      {"\\\\/||\\//"," ||;)||"," ||  ||"," /\\/\\/\\"}, // tree
      {"    [_______]","^/==+|&`~`&|+==\\^","||  [‾/|||\\‾]  ||","\\/     | |     \\/","       ∆ ∆"} // Metal Killer

  };

  public static int monstersFought = 0;
  public static void monsterfight(enemy obj) {
    boolean enemyDead = false;
    boolean blocking = false;
    if (game.eightiesMode) {
    while (!enemyDead) {
    System.out.println("You have encountered a gnarly " + obj.enemyName + "!");
    printArt(obj);
    double chance = Math.random();
    if (chance < (obj.chance - (player.df*0.025))) {
      if (blocking == false) {
      player.hp = player.hp - 1;
      System.out.println(obj.enemyName + " gagged you with a spoon-ed you! -1 HP!");
      } else {
        player.hp = player.hp - 0.5;
        blocking = false;
        System.out.println(obj.enemyName + " semi-gagged you with a spoon-ed you! -0.8 HP!");
      }
      if (player.hp <= 0) {
        room.lose();
      }
    } else {
      System.out.println(obj.enemyName + " missed you! Rad!");
    }
    Scanner keyboard = new Scanner(System.in);
        System.out.println("<||||||||||||||||||||||||||||||||>");
        System.out.println("You are on " + player.hp + " HP yo!");
        System.out.println("[1]: Attack");
        System.out.println("[2]: Block");
        System.out.println("<||||||||||||||||||||||||||||||||>");
        System.out.print("Which one yo: ");
        String answer = keyboard.nextLine();
      if (answer.equals("1")) {
      chance = Math.random();
      if (chance < player.chanceToHit) {
        obj.health = obj.health - 1;
        System.out.println("You whacked it! -1 HP for the " + obj.enemyName);
        if (obj.health <= 0) {
          System.out.println("You killed the " + obj.enemyName + "! +0 XP!");
          enemyDead = true;
        }
      } else {
        System.out.println("You missed! That's un-rad yo!");
      }
      } else if (answer.equals("2")) {
        blocking = true;
      } else if (answer.equals("0")) {
        System.out.println("Quiting");
        System.exit(1);
      }
    }
    } else {
      while (!enemyDead) {
        System.out.println("You have encountered a wild " + obj.enemyName + "!");
        printArt(obj);
        double chance = Math.random();
        if (chance < (obj.chance - (player.df * 0.025))) {
          if (blocking == false) {
            player.hp = player.hp - 1;
            System.out.println(obj.enemyName + " whacked you! -1 HP!");
          } else {
            player.hp = player.hp - 0.5;
            blocking = false;
            System.out.println(obj.enemyName + " whacked you, but you blocked! -0.5 HP!");
          }
          if (player.hp <= 0) {
            room.lose();
          }
        } else {
          System.out.println(obj.enemyName + " missed you!");
        }
        Scanner keyboard = new Scanner(System.in);
        System.out.println("<-------------------------------->");
        System.out.println("You are on " + player.hp + " HP.");
        System.out.println("[1]: Attack");
        System.out.println("[2]: Block");
        System.out.println("<-------------------------------->");
        System.out.print("Which one: ");
        String answer = keyboard.nextLine();
      if (answer.equals("1")) {
      chance = Math.random();
      if (chance < player.chanceToHit) {
        obj.health = obj.health - 1;
        System.out.println("You whacked it! -1 HP for the " + obj.enemyName);
        if (obj.health <= 0) {
          System.out.println("You killed the " + obj.enemyName + "! +0 XP!");
          enemyDead = true;
        }
      } else {
        System.out.println("You missed!");
      }
      } else if (answer.equals("2")) {
        blocking = true;
      } else if (answer.equals("0")) {
        System.out.println("Quiting");
        System.exit(1);
      }
      }
    }
  }
}
