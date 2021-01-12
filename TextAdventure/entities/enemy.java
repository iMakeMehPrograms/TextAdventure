package TextAdventure.entities;
import TextAdventure.*;
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
    if (game.eightiesMode) {
    while (!enemyDead) {
    System.out.println("You have encountered a gnarly " + obj.enemyName + "!");
    printArt(obj);
    double chance = Math.random();
    if (chance < (obj.chance - (player.df*0.025))) {
      player.hp = player.hp - 1;
      if (player.hp <= 0) {
        room.lose();
      }
    }
    chance = Math.random();
    if (chance < player.chanceToHit) {
      obj.health = obj.health - 1;
      if (obj.health <= 0) {
        System.out.println("yay");
      }
    }
  }
    } else {
      while (!enemyDead) {
        System.out.println("You have encountered a gnarly " + obj.enemyName + "!");
        printArt(obj);
        double chance = Math.random();
        if (chance < (obj.chance - (player.df * 0.025))) {
          player.hp = player.hp - 1;
          if (player.hp <= 0) {
            room.lose();
          }
        }
      chance = Math.random();
      if (chance < player.chanceToHit) {
        obj.health = obj.health - 1;
        if (obj.health <= 0) {
          System.out.println("yay");
        }
      }
      }
    }
  }
}
