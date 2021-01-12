package TextAdventure.entities;
import java.util.*;
public class player extends entity {

    public static ArrayList<String> traits = new ArrayList<String>();
    public static int roomsVisited = 0;
    public static int monstersKilled = 0;
    public static int hp = 3; // Hit Points (deduce one at a time)
    public static int df = 0; // Defense (chance - 0.05 per point in Normal, 0.025 in '80s)
    public static double chanceToHit = 0.6;

}
