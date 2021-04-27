import java.util.Random;

public class Monster {
	/* Current health of this Monster */
    private int health;

    /* Max damage this Monster inflicts */
    private int damage;

    /* Type of this Monster */
    private String monsterType;

    public static final String goblinType = "Goblin";

    public static final String zombieType = "Zombie";

    public static final String orcType = "Orc";

    public static final String denekeType = "Deneke";

    //used for random monster generation
    private String[] monsterArray = {"Goblin" , "Zombie" , "Orc" , "Deneke"};

    public Monster(){

        Random random = new Random();

        //generates random monster from array list
        monsterType = monsterArray[random.nextInt(monsterArray.length)];

        //sets monster health and damage
        if(monsterType == goblinType){
        
            damage = 10;
            health = 6;

        }
        else if (monsterType == zombieType){

            damage = 15;
            health = 12;

        }
        else if (monsterType == orcType){

            damage = 20;
            health = 18;

        }
        else{

            damage = 5;
            health = 55;

        }
    }

    //accessor for monster health
    public int getHealth(){
        return health;
    }

    //accessor for monster type
    public String getMonsterType(){
        return monsterType;
    }

    /* Hits the targeted Player */
    public void attack(Player target) {
        Random randomDamage = new Random();

        target.onHit(randomDamage.nextInt(damage + 1));

    }

    /* Removes health from this Monster
    when hit by a Player */
    public void onHit(int damage) {

        this.health = this.health - damage;
        if (health < 0 ){
            health = 0;
        }

    }
}
