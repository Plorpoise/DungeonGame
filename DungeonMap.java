
/* Contains the Rooms in the dungeon 
and logic for Player movement */
public class DungeonMap {
	/* Rooms in the dungeon */
    private Room[][] rooms;

    /* Reference to the Player in the dungeon */
    private Player player;

    /* Initializes the rooms and shared Player reference */
    public DungeonMap (int rows, int columns, Player player){

<<<<<<< HEAD
        rooms = new Room[rows][columns];

        for(int i = 0; i < rooms.length; i ++){
            for(int j = 0; j < rooms[i].length; j++){
                this.rooms[i][j] = new Room();
            }
        }
=======
>>>>>>> parent of 6742a92... Implemented good chunk of DungeonMap, updated player and room classes as well.
    }

    /* Displays the dungeon's rooms, walls,
    and player's current location */
    public void print() {
<<<<<<< HEAD
        printTopBottom();
        for(int i = 0; i < rooms.length; i++){
            System.out.print("|");
            for(int j = 0; j < rooms[0].length; j++){
                if(player.getRowPos() == i && player.getColPos() == j){
                    System.out.print(player.getClass().charAt);
                }
                else if(rooms[i][j].hasVisited()){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        printTopBottom();

        //prints player gold and health
        System.out.println("GOLD: " + player.getGold());
        System.out.println("HEALTH: " + player.getHealth());
    }

    //prints top and bottom of the map
    public void printTopBottom(){
        System.out.print("+");
        for(int i = 0; i < rooms[0].length; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
	
    //changes player position in dungeon
    public void move(Player player, int rowChange, int colChange){
        player.setRowPos(player.getRowPos() + rowChange);
        player.setColPos(player.getColPos() + colChange);

        //checks to see if player ran into a wall
        if (player.getRowPos() < 0 || player.getRowPos() > rooms.length || player.getColPos() < 0 || player.getColPos() > rooms[0].length){
            System.out.println("You run into the wall.");
            player.setRowPos(player.getRowPos() - rowChange);
            player.setColPos(player.getColPos() - colChange);
        }
        else{
            if(rooms[player.getRowPos()][player.getColPos()].hasVisited() == true){
                System.out.println("You notice this place looks familiar.");
            }
            else{
                rooms[player.getRowPos()][player.getColPos()].enter(player);
            }
        }
    }
=======

    }
	
	//TODO: method(s) to move player
>>>>>>> parent of 6742a92... Implemented good chunk of DungeonMap, updated player and room classes as well.
}
