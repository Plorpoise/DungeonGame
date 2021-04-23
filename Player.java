
public class Player {
    /* Current health of this Player */
    private int health;

    /* Current gold of this Player */
    private int gold;

    /* Damage this Player inflicts */
    private int damage;

    /* Class of this Player */
    private String playerClass;

    /* Modifer to loot obtained by this Player */
    private double lootModifier;

    /* Hits the targeted Monster */
    public void attack(Monster target) {
        target.onHit(this.damage);
    }

    // Constructor for player class (Warrior or theif)
    public Player(String playerClass) {
        this.playerClass = playerClass;
        this.gold = 0;

        if (this.playerClass.toLowerCase().equals("warrior")) {
            this.health = 100;
            this.damage = 15;
            this.lootModifier = 1.00;

        } else {
            this.health = 70;
            this.damage = 10;
            this.lootModifier = 1.20;

        }

    }

    /*
     * Removes health from this Player when hit by a Monster
     */
    public void onHit(int damage) {
        setHealth(damage, 0);
    }

    /* Adds health to this Player when healed */
    public void onHeal(int health) {
        setHealth(0 , health);
    }

    /* Adds gold to this Player when obtained */
    public void onLoot(int gold) {
        setGold((int) (gold * lootModifier));
    }

    /*
    *
    * GETTERS
    *
    *
    */

    public int getHealth() {
        return this.health;
    }

    public int getGold() {
        return this.gold;
    }

    public int getDamage() {
        return this.damage;
    }

    public double getLootModifier(){
        return this.lootModifier;
    }

    public String getPlayerClass(){
        return this.playerClass;
    }
    
    /*
    *
    *
    * SETTERS
    *
    *
    */

    //Accepts damage/health value, subtracts/adds damage/health from current health of player
    public void setHealth(int damage, int health){
        this.health = this.health - damage;
        this.health = this.health + health;
    }

    public void setGold(int gold){
        this.gold += gold;
    }
        
}
