import java.util.Random;
import java.util.Scanner;


/* Represents a Room in the Dungeon, where
encounters with Monsters and Loot occur */
public class Room {
    /* Indicates whether or not this Room
    instance has been visited already */
    private boolean visited;

    //indicates wether player inputted proper input
    private boolean properInput;

    private int realInput;

    private double lootChance = 0.25;

    private int lootValue = 15;

	/* Handles encounter logic when a Player
	enters this Room. Includes combat resolution
	and obtaining loot. */
    public void enter(Player player) {
<<<<<<< HEAD
        Random random = new Random();

        //checks to see if player has visited room before
        if (!visited){
            visited = true;

            //generates loot type
            if (random.nextDouble() < lootChance ){
                System.out.println("You found...");
                if(random.nextDouble() < 0.5){
                    System.out.println("A health potion!");
                    player.setHealth(0, random.nextInt(lootValue));
                }
                else{
                    System.out.println("Gold!");
                    player.onLoot(random.nextInt(lootValue));
                }

            }
            //generates random monster
            else{
                Monster monster = new Monster();

                System.out.println("You come face to face with a " + monster.getMonsterType() + "!");
                playerCombat(player , monster);
            }
=======
        this.visited = true;

        Random rand = new Random();

        //Checks to see if the player gets loot from the room, otherwise the player goes into combat.
        if(rand.nextDouble() < lootChance){
            if(rand.nextDouble() < .5){
                player.setHealth(0, lootAmount);
            } else{
                player.onLoot(rand.nextInt(lootAmount));
            }
            
        //Combat sequence
        } else{
            Monster monster = new Monster();

            System.out.println("A " + monster.getMonsterType() + " is in this room!"); 
            doCombat(player, monster);

>>>>>>> parent of 6742a92... Implemented good chunk of DungeonMap, updated player and room classes as well.
        }

    }

    /* Accessor for the visited field */
    public boolean hasVisited() {
        return this.visited;
    }

    //runs the player combat with the monster
    private boolean playerCombat(Player player , Monster monster){
        Scanner scanner = new Scanner(System.in);

        //makes sure player inputs proper input type
        properInput = false;
        while (!properInput){
            System.out.println("What's your course of action?\n(1) Fight\n(2) Run");
            String playerInput = scanner.nextLine();

            try{
               realInput = Integer.parseInt(playerInput);
            }
            catch(NumberFormatException e){
                System.out.println("Please choose a course of action.");
            }

            if (realInput != 1 && realInput != 2){
                System.out.println("Please choose a course of action.");
            }
            else{
                properInput = true;
            }
        }

        //runs monsters attack method.
        monster.attack(player);

        //checks to see if player died
        if (player.getHealth() == 0){
            System.out.println("You died.");
            return false;
        }

        //checks wether player chose to fight or run
        if( realInput == 1){
            player.attack(monster);

            if(monster.getHealth() == 0){
                System.out.println("You won!");
                return true;
            }
        }
        else{
            System.out.println("You got away...");
            return true;
        }
    
        //prints player's new health and returns player and monster objects.
        System.out.println("Your health is now " + player.getHealth() + "\nMonster health: " + monster.getHealth());
        return playerCombat(player , monster);

    }
}
