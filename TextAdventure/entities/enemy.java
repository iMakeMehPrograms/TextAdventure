package TextAdventure.entities;
import TextAdventure.*;
public class enemy extends entity {

  String[] asciiArt;

  public enemy(String name, int hp, double hitChance, String[] art, String drop) {
    asciiArt = art;

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
  public static void monsterfight() {
    
  }
}
