import java.util.Random;

public class Monster {
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
    
    Random randMonster = new Random();

    int monsterSelection = randMonster.nextInt(3);
    
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

    /* Hits the targeted Player */
    public void attack(Player target) {
        target.onHit(this.damage);    
    }

    /* Removes health from this Monster
    when hit by a Player */
    public void onHit(int damage) {
        this.health = this.health - damage;
    }
}
