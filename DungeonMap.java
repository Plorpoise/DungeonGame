
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

        rooms = new Room[rows][columns];

        for(int i = 0; i < rooms.length; i ++){
            for(int j = 0; j < rooms[i].length; j++){
                this.rooms[i][j] = new Room();
            }
        }
    }

    /* Displays the dungeon's rooms, walls,
    and player's current location */
    public void print() {
        printTopBottom();
        for(int i = 0; i < rooms.length; i++){
            System.out.print("|");
            for(int j = 0; j < rooms[0].length; j++){
                if(player.getRowPos() == i && player.getColPos() == j){
                    System.out.print("P");
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

        System.out.println("GOLD: " + player.getGold());
        System.out.println("HEALTH: " + player.getHealth());
    }

    public void printTopBottom(){
        System.out.print("+");
        for(int i = 0; i < rooms[0].length; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
	
    public void move(Player player, int rowChange, int colChange){
        player.setRowPos(player.getRowPos() + rowChange);
        player.setColPos(player.getColPos() + colChange);

        if (player.getRowPos() < 0 || player.getRowPos() > rooms.length || player.getColPos() < 0 || player.getColPos > rooms[0].length){
            System.out.println("You run into the wall.");
            player.setRowPos(player.getRowPos() - rowChange);
            player.setColPos(player.getColPos() - colChange);
        }
        else{
            if(rooms[player.getRowPos()][player.getColPos()].hasVisited() == true){
                System.out.println("You notice this place looks familiar.");
            }
            else{
                player.setRowPos(player.getRowPos() + rowChange);
                player.setColPos(player.getColPos() + colChange);
                rooms[player.getRowPos()][player.getColPos()].enter(player);
            }
        }
    }
}
