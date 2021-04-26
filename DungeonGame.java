import java.util.Scanner;

public class DungeonGame {
    /* Reference to the DungeonMap the Player is in */
    private DungeonMap map;

    public DungeonMap getMap() {
        return this.map;
    }

    public void setMap(DungeonMap map) {
        this.map = map;
    }

    /* Reference to the Player in the dungeon */
    private Player player;

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    /* Initializes the size of the dungeon */
	public DungeonGame(int rows, int columns) {
	}
	
	/* Main loop of the game, which handles
	non-combat related user input. Continues
	until the Player either wins or loses. */
    public void play() {
        System.out.println("You are in a dungeon!! \nThere are monsters, bags of gold, and healing elixirs in each room. \nCan you find 100 gold pieces and pay the evil professor to let you out before the monsters kill you? \nSelect your class: \n[1] Warrior \n[2] Thief");
        Scanner input = new Scanner(System.in);
        while(true){
        int chooseClass = input.nextInt();
        if (chooseClass == 1){
            Player player = new Player("warrior");
            DungeonMap map = new DungeonMap(10, 20, player);
            while (true){
                System.out.println("==========================");
                map.print();
                String move = input.next();
                if (move.equals("w")){
                    map.move(player, -1, 0);
                }
                else if (move.equals("a")){
                    map.move(player, 0, -1);
                }
                else if (move.equals("s")){
                    map.move(player, 1, 0); 
                }
                else if (move.equals("d")){
                    map.move(player, 0, 1);
                }
                }
                }
            
         
        if (chooseClass == 2){
            Player player = new Player("thief");
            DungeonMap map = new DungeonMap(10, 20, player);
            while (true){
                System.out.println("==========================");
                map.print();
                String move = input.next();
                if (move.equals("w")){
                    map.move(player, -1, 0);
                }
                else if (move.equals("a")){
                    map.move(player, 0, -1);
                }
                else if (move.equals("s")){
                    map.move(player, 1, 0); 
                }
                else if (move.equals("d")){
                    map.move(player, 0, 1);
                }
                }
        }
        else{
            System.out.println("Please input either [1] Warrior or [2] Theif");
        }
    }
}
}    

