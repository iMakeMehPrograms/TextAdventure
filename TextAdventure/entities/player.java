package TextAdventure.entities;
import java.util.*;
import TextAdventure.items;
public class player extends entity {

    public static ArrayList<String> traits = new ArrayList<String>();
    public static ArrayList<items> inventory = new ArrayList<items>();
    public static int roomsVisited = 0;
    public static int monstersKilled = 0;
    public static double hp = 3; // Hit Points (deduce one at a time if not blocking, half if blocking)
    public static double df = 0; // Defense (chance - 0.05 per point in Normal, 0.025 in '80s)
    public static double atck = 1;
    public static double chanceToHit = 0.6;

}
