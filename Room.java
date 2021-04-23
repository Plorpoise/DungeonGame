import java.util.Random;
import java.util.Scanner;

/* Represents a Room in the Dungeon, where
encounters with Monsters and Loot occur */
public class Room {
    /* Indicates whether or not this Room
    instance has been visited already */
    private boolean visited;

    //Internal chance for loot to appear. This is here for readability as well as easy changing of the loot chance for preference or testing
    private double lootChance = .25;

    //This is the maximum amount of gold/healing a room can pay out.
    //Used in enter() to determine how much gold/healing a player should get from the room if its just loot
    private int lootAmount = 15;

	/* Handles encounter logic when a Player
	enters this Room. Includes combat resolution
	and obtaining loot. */
    public void enter(Player player) {
        if(!this.visited) {
            this.visited = true;
    
            Random rand = new Random();
    
            //Checks to see if the player gets loot from the room, otherwise the player goes into combat.
            if(rand.nextDouble() < lootChance){
                System.out.println("You found... ");
                if(rand.nextDouble() < .5){
                    System.out.println("A health potion!");
                    player.setHealth(0, rand.nextInt(lootAmount));
                } else{
                    System.out.println("Gold!");
                    player.onLoot(rand.nextInt(lootAmount));
                }
                
            //Combat sequence
            } else{
                Monster monster = new Monster();
    
                System.out.println("A " + monster.getMonsterType() + " is in this room!"); 
                doCombat(player, monster);
    
            }
        } else{
            System.out.println("You've been here already...");
        }

    }

    /* Accessor for the visited field */
    public boolean hasVisited() {
        return this.visited;
    }


    //Helper method for combat between player and monster
    //Returns true if player survives, false if they die.
    //Otherwise, this method will be called again at the end of the method so that combat continues until someone dies
    private boolean doCombat(Player player, Monster monster){
        Scanner in = new Scanner(System.in);
        
        System.out.println("What do you want to do?\n(1) Fight!!!\n (2)Run!!!");

        int choice = in.nextInt();

        monster.attack(player);
        System.out.println("Your health is now " + player.getHealth() + "!");
        if(player.getHealth() <= 0){
            System.out.println("You died!!!!!!!!!!!");
            return false;
        }

        if(choice == 1){
            player.attack(monster);

            if(monster.getHealth() <= 0){
                System.out.println("You won!");
                return true;
            }
        } else{
            System.out.println("You got away...");
            return true;
        }

        System.out.println("Your health is: " + player.getHealth() + "\nMonster health: " + monster.getHealth());
        return doCombat(player, monster);

        

    }
}
