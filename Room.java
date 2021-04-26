import java.util.Random;
import java.util.Scanner;


/* Represents a Room in the Dungeon, where
encounters with Monsters and Loot occur */
public class Room {
    /* Indicates whether or not this Room
    instance has been visited already */
    private boolean visited;

    private boolean properInput;

    private int realInput;

    private double lootChance = 0.25;

    private int lootValue = 15;

	/* Handles encounter logic when a Player
	enters this Room. Includes combat resolution
	and obtaining loot. */
    public void enter(Player player) {
        Random random = new Random();

        if (!visited){
            visited = true;

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
            else{
                Monster monster = new Monster();

                System.out.println("You come face to face with a " + monster.getMonsterType() + "!");
                playerCombat(player , monster);
            }
        }

    }

    /* Accessor for the visited field */
    public boolean hasVisited() {
        return this.visited;
    }

    private boolean playerCombat(Player player , Monster monster){
        Scanner scanner = new Scanner(System.in);

        while (!properInput){
            System.out.println("What's your course of action?\n(1) Fight\n(2) Run");
            String playerInput = scanner.nextLine();

            try{
               realInput = Integer.parseInt(playerInput);
               properInput = true;
            }
            catch(NumberFormatException e){
                System.out.println("Please choose a course of action.");
            }
        }

        monster.attack(player);
        System.out.println("Your health is now " + player.getHealth() + "!");
        if (player.getHealth() == 0){
            System.out.println("You died.");
            return false;
        }

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
    
        System.out.println("Your health is now " + player.getHealth() + "\nMonster health: " + monster.getHealth());
        return playerCombat(player , monster);

    }
}
