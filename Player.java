
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
            lootModifier = 1.00;
        }
        else{
            setHealth(70);
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
        //TODO: move this to sethealth
        if ((health - damage) < 0){
            health = 0;
        }
        else{
            health -= damage;
        }

    }

	/* Adds health to this Player when healed */
    public void onHeal(int heal) {
        //TODO: move this to sethealth
        if(playerClass == warriorClass && health == 100){
            health = 100;
        }
        else if (playerClass == warriorClass && ((health + heal) > 100)){
            health = 100;
        }
        else if (playerClass == thiefClass && health == 70){
            health = 70;
        }
        else if (playerClass == thiefClass && ((health + heal) > 70)){
            health = 70;
        }
        else{
            health += heal;
        }

    }

	/* Adds gold to this Player when obtained */
    public void onLoot(int goldAdded) {
        //TODO: move this to setgold
        if (playerClass == warriorClass){
            gold += goldAdded;
        } 
        else{
            goldAdded += goldAdded * 0.2;
            gold += goldAdded;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health += health;
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
