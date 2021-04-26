
/* Contains the Rooms in the dungeon 
and logic for Player movement */
public class DungeonMap {
	/* Rooms in the dungeon */
    private Room[][] rooms;

    /* Reference to the Player in the dungeon */
    private Player player;

    /* Initializes the rooms and shared Player reference */
    public DungeonMap (int rows, int columns, Player player){
        this.player = player;

        this.rooms = new Room[rows][columns];

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[i].length; j++){
                this.rooms[i][j] = new Room();
            }
        }
    }

    /* Displays the dungeon's rooms, walls,
    and player's current location */
    public void print() {
        printTop();
        for(int i = 0; i < rooms.length; i++){
            System.out.print("|");
            for(int j = 0; j < rooms[0].length; j++){
                if(player.getRowPos() == i && player.getColPos() == j){
                    System.out.print("P");
                } else if(rooms[i][j].hasVisited()){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
                
            }
            System.out.println("|");
        }
        printTop();

        System.out.println("GOLD: " + player.getGold());
        System.out.println("HEALTH: " + player.getHealth());

    }

    private void printTop() {
        System.out.print("+");
        for(int i = 0; i < rooms[0].length; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
	
	//TODO: method(s) to move player
	//STILL NEED TO FINISH PRINTING ASTERIKS ON ALREADY VISITED ROOMS, AND ALSO CHECKING TO SEE IF A ROOM HAS BEEN VISITED

    public void move(Player player, int rowChange, int colChange){
        if (player.getRowPos() + rowChange < 0 || player.getColPos() + colChange < 0 || player.getRowPos() + rowChange > rooms.length || player.getColPos() + colChange > rooms[0].length){
            System.out.println("That's a wall, you cannot move there!");
        }
        else{
            Room entering = new Room();
            if (entering.hasVisited() == true){
                System.out.println("You have already visited this room.");
            }
            else{
            player.setRowPos(player.getRowPos() + rowChange);
            player.setColPos(player.getColPos() + colChange);
            entering.enter(player);
            entering.setVisited(true);
            }
        }
        }

    }

