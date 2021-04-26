
public class Player {
	/* Current health of this Player */
    private int health;

    /* Current gold of this Player */
    private int gold;

    /* Damage this Player inflicts */
    private int damage;

    /* Class of this Player */
    private String playerClass;

    public static final String warriorClass = "Warrior";

    public static final String thiefClass = "Thief";

    /* Modifer to loot obtained by this Player */
    private double lootModifier;

    public Player(String pClass){
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

    //TODO: attack monster
    /* Hits the targeted Monster */
    public void attack(Monster target) {

        target.onHit(damage);

    }

	/* Removes health from this Player
    when hit by a Monster */
    public void onHit(int damage) {

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
        return health;
    }

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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold += gold;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage += damage;
    }
}
