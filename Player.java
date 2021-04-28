
public class Player {
    /* Current health of this Player */
    private int health;

    /* Current gold of this Player */
    private int gold;

    /* Damage this Player inflicts */
    private int damage;

    private int rowPos;

    private int colPos;

    /* Class of this Player */
    private String playerClass;

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public static final String warriorClass = "Warrior";

    public static final String thiefClass = "Thief";

    /* Modifer to loot obtained by this Player */
    private double lootModifier;

    //sets base settings for warrior class and thief class
    public Player(String pClass){
        rowPos = 0;
        colPos = 0;
        playerClass = pClass;

        if (playerClass == warriorClass){
            setHealth(0 , 100);
            setDamage(15);
            lootModifier = 1.00;
        }
        else{
            setHealth(0 , 70);
            setDamage(10);
            lootModifier = 1.20;
        }

        setGold(0);


    }


    /* Hits the targeted Monster */
    public void attack(Monster target) {
        target.onHit(this.damage);
    }

    // // Constructor for player class (Warrior or theif)
    // public Player(String playerClass) {
    //     this.colPos = 0;
    //     this.rowPos = 0;
    //     this.playerClass = playerClass;
        this.gold = 0;
 //
    //     if (this.playerClass.toLowerCase().equals("warrior")) {
    //         this.health = 100;
    //         this.damage = 15;
            this.lootModifier = 1.00;
// 
    //     } else {
    //         this.health = 70;
    //         this.damage = 10;
            this.lootModifier = 1.20;
 //
        }
// 
        target.onHit(damage);
 //
    }

    /*
     * Removes health from this Player when hit by a Monster
     */


        setHealth(damage , 0);

    }

	/* Adds health to this Player when healed */
    public void onHeal(int heal) {
        setHealth(0, heal);

    }

	/* Adds gold to this Player when obtained */
    public void onLoot(int goldAdded) {
        setGold((int) (goldAdded * lootModifier));
    }


    public int getHealth() {
        return this.health;
    }

    //sets player health based on damage and health conditions
    public void setHealth(int damage, int health) {

        this.health = this.health - damage;
        this.health = this.health + health;
        if(playerClass == warriorClass && (this.health >= 100)){
            this.health = 100;
        }
        else if (playerClass == warriorClass && (this.health < 0)){
            this.health = 0;
        }
        else if (playerClass == thiefClass && (this.health >= 70)){
            this.health = 70;
        }
        else if (playerClass == thiefClass && (this.health < 0)){
            this.health = 0;
        }

    }

    //accessor for player gold
    public int getGold() {
        return gold;
    }

    //sets player gold
    public void setGold(int gold) {
        this.gold += gold;
    }

    //accessor for player damage
    public int getDamage() {
        return damage;
    }

    //sets player damage
    public void setDamage(int damage) {
        this.damage += damage;
    }

    //sets player horizontal position
    public void setRowPos(int rowPosition){
        rowPos = rowPosition;
    }

    //accessor for player horizontal position
    public int getRowPos(){
        return rowPos;
    }

    //sets player vertical position
    public void setColPos(int colPosition){
        colPos = colPosition;
    }

 

    
        
}
