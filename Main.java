public class Main {
    /* Entry point of the application */
    //sssss
    
    public static void main(String[] args) {
        // Monster monster = new Monster();
        Player player = new Player("warrior");

        // Room room = new Room();

        // room.enter(player);


        DungeonMap map = new DungeonMap(10, 20, player);

        map.print();
    }
}