//package Homework1git
//CHECK FOR THIS EDIT!
//oh thank christ

import java.util.Scanner;

public class DungeonGame {
    /* Reference to the DungeonMap the Player is in */
    private DungeonMap map;

    /* Reference to the Player in the dungeon */
    private Player player;

    private boolean properInput;

    private int playerClass;

    private int rows;
    
    private int columns;

    /* Initializes the size of the dungeon */
	public DungeonGame(int rows, int columns) {

        this.rows = rows;
        this.columns = columns;
		
	}
	
	/* Main loop of the game, which handles
	non-combat related user input. Continues
	until the Player either wins or loses. */
    public void play() {
        System.out.println("You are in a dungeon!!\nThere are monsters, bags of gold, and healing elixirs in each room.\nCan you find 100 gold pieces and pay the evil professor to let you out before the monsters kill you?\nSelect your class:\n[1] Warrior\n[2]Thief");
        Scanner scanner = new Scanner(System.in);
        //runs until player inputs proper input type
        while(!properInput){
            String playerInput = scanner.nextLine();
            try{
                playerClass = Integer.parseInt(playerInput);
            }
            catch(NumberFormatException e){
                System.out.println("Please choose a class:\n[1] Warrior\n[2] Thief");
            }
            if(playerClass != 1 && playerClass != 2){
                System.out.println("Please choose a class:\n[1] Warrior\n[2] Thief");
            }
            
            else{
                properInput = true;
            }
        }

        System.out.println("[w] move up, [a] move left, [s] move down, [d] move right");

        //checks which class the player chose
        if(playerClass == 1){
            player = new Player("Warrior");
            map = new DungeonMap(rows , columns, player);
            //runs until player's health = 0 or until player gains 100 gold pieces;
            while (player.getHealth() != 0 && player.getGold() < 100){
                properInput = false;
                System.out.println("=====================");
                //prints map
                map.print();
                //runs until player inputs a proper input
                while(!properInput){
                    String moveInput = scanner.nextLine();
                    if(moveInput.equals("w") || moveInput.equals("W")){
                        map.move(player, -1, 0);
                        properInput = true;
                    }
                    else if(moveInput.equals("a") || moveInput.equals("A")){
                        map.move(player, 0, -1);
                        properInput = true;
                    }
                    else if(moveInput.equals("s") || moveInput.equals("S")){
                        map.move(player, 1, 0);
                        properInput = true;
                    }
                    else if(moveInput.equals("d") || moveInput.equals("D")){
                        map.move(player, 0, 1);
                        properInput = true;
                    }
                    else{
                        System.out.println("Please select a movement, [w] move up, [a] move left, [s] move down, [d] move right");
                    }
                }
            }
            //checks to see if player has won the game
            if(player.getGold() >= 100){
                System.out.println("You got 100 gold pieces! You pay the evil professor his gold and now you're home free!");
            }
        }

        //checks which class the player chose
        if(playerClass == 2){
            player = new Player("Thief");
            map = new DungeonMap(rows , columns, player);
            //runs until players health = 0 or until player gains 100 gold pieces
            while (player.getHealth() != 0 && player.getGold() < 100){
                properInput = false;
                System.out.println("=====================");
                //prints map
                map.print();
                //runs until player inputs proper input type
                while(!properInput){
                    String moveInput = scanner.nextLine();
                    if(moveInput.equals("w") || moveInput.equals("W")){
                        map.move(player, -1, 0);
                        properInput = true;
                    }
                    else if(moveInput.equals("a") || moveInput.equals("A")){
                        map.move(player, 0, -1);
                        properInput = true;
                    }
                    else if(moveInput.equals("s") || moveInput.equals("S")){
                        map.move(player, 1, 0);
                        properInput = true;
                    }
                    else if(moveInput.equals("d") || moveInput.equals("D")){
                        map.move(player, 0, 1);
                        properInput = true;
                    }
                    else{
                        System.out.println("Please select a movement, [w] move up, [a] move left, [s] move down, [d] move right");
                    }
                }
            }
            //checks to see if player won the game.
            if(player.getGold() >= 100){
                System.out.println("You got 100 gold pieces! You pay the evil professor his gold and now you're home free!");
            }
        }
    }
}
