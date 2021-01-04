package TextAdventure.entities;
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

  public static final String[][] enemyASCII = { 
    {"_________", "| '80s  |", "|_______|", " /_____\\ " }, // rad'puter
      /* '80s > Normal */
      {"\\/\\/\\/", " @\\/@ ", " /--\\ ", " /||\\ " }, // twiglet
      {"\\|^^|/", "|:)|", "|  |", "/--\\"}, // branchlet
      {"\\\\/||\\//","||;)||","||  ||","/\\/\\/\\"} // tree

  };

  public static int monstersFought = 0;
  public static final String[] enemyChances = {"1/3", /* '80s > Normal */ "1/4"}; // same order as ASCII art
  public static void monsterfight(int element) {
    
  }
}
