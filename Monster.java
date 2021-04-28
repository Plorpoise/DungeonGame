import java.util.Random;

public class Monster {

    /*String array to help with selection of monster type on generation*/
    private String[] monsterTypeArray = {"goblin", "zombie", "orc", "deneke"};

	/* Current health of this Monster */
    private int health;

    /* Max damage this Monster inflicts */
    private int damage;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    /* Type of this Monster */
    private String monsterType;

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    //Default constructor to generate a monster randomly from the classes in the array
    // public Monster(){
    //     Random rand = new Random();


    //     this.monsterType = monsterTypeArray[rand.nextInt(monsterTypeArray.length)];  

    //     if (this.monsterType.toLowerCase().equals("goblin")) {
    //         this.health = 6;
    //         this.damage = 10;
    //     }
    //     else if (this.monsterType.toLowerCase().equals("zombie")) {
    //         this.health = 12;
    //         this.damage = 15;
    //     }
    //     else if (this.monsterType.toLowerCase().equals("orc")) {
    //         this.health = 18;
    //         this.damage = 20;
    //     }
    //     else if (this.monsterType.toLowerCase().equals("deneke")) {
    //         this.health = 55;
    //         this.damage = 5;
    //     }
    // }

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

        //random damage up to monsters max damage, "this.damage + 1" is used because nextInt(int x) chooses a random int up to the number supplied, exclusive.  
        target.onHit(randomDamage.nextInt(this.damage + 1));    
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
