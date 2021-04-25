import java.util.Random;

public class Monster {
	/* Current health of this Monster */
    private int health;

    /* Max damage this Monster inflicts */
    private int damage;

    /* Type of this Monster */
    private String monsterType;

    public static final String orcType = "Orc";

    public Monster(String mType){

        monsterType = mType;
        
    }

    /* Hits the targeted Player */
    public void attack(Player target) {

    }

    /* Removes health from this Monster
    when hit by a Player */
    public void onHit(int damage) {

    }
}
