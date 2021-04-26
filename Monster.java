import java.util.Random;

public class Monster {

    /*String array to help with selection of monster type on generation*/
    private String[] monsterTypeArray = {"goblin", "zombie", "orc", "deneke"};

	/* Current health of this Monster */
    private int health;

    /* Max damage this Monster inflicts */
    private int damage;

    public int getHealth() {
        return this.health;
    }

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
    
    public String getMonsterType() {
        return this.monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    //Default constructor to generate a monster randomly from the classes in the array
    public Monster(){
        Random rand = new Random();


        this.monsterType = monsterTypeArray[rand.nextInt(monsterTypeArray.length)];  

        if (this.monsterType.toLowerCase().equals("goblin")) {
            this.health = 6;
            this.damage = 10;
        }
        else if (this.monsterType.toLowerCase().equals("zombie")) {
            this.health = 12;
            this.damage = 15;
        }
        else if (this.monsterType.toLowerCase().equals("orc")) {
            this.health = 18;
            this.damage = 20;
        }
        else if (this.monsterType.toLowerCase().equals("deneke")) {
            this.health = 55;
            this.damage = 5;
        }
    }

    //Overloaded constructor for when you want to select a specific monster
    public Monster(String monsterType){



        if (this.monsterType.toLowerCase().equals("goblin")) {
            this.health = 6;
            this.damage = 10;
        }
        else if (this.monsterType.toLowerCase().equals("zombie")) {
            this.health = 12;
            this.damage = 15;
        }
        else if (this.monsterType.toLowerCase().equals("orc")) {
            this.health = 18;
            this.damage = 20;
        }
        else if (this.monsterType.toLowerCase().equals("deneke")) {
            this.health = 55;
            this.damage = 5;
        }
    }

    /* Hits the targeted Player for a random amount of damage, up to the monsters max damage*/
    public void attack(Player target) {
        Random rand = new Random();

        //random damage up to monsters max damage, "this.damage + 1" is used because nextInt(int x) chooses a random int up to the number supplied, exclusive.  
        target.onHit(rand.nextInt(this.damage + 1));    
    }

    /* Removes health from this Monster
    when hit by a Player */
    public void onHit(int damage) {
        this.health = this.health - damage;
    }
}

