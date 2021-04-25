
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
            //TODO: change hp if needed
            setHealth(100);
            setDamage(15);
        }
        else{
            setHealth(70);
            setDamage(10);
        }

        setGold(0);

    }

    /* Hits the targeted Monster */
    public void attack(Monster target) {

    }

	/* Removes health from this Player
    when hit by a Monster */
    public void onHit(int damage) {

        if (){
            
        }
        health -= damage;

    }

	/* Adds health to this Player when healed */
    public void onHeal(int health) {

    }

	/* Adds gold to this Player when obtained */
    public void onLoot(int gold) {

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
