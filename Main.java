import java.util.Scanner;

public class Main {
    /* Entry point of the application */
    
    public static void main(String[] args) {
<<<<<<< HEAD

        //checks to see if there is a console input for the dungeon size
        if(args.length != 2){

            //sets dungeon size to default size
            DungeonGame startGame = new DungeonGame(10, 10);

            //runs game code
            startGame.play();
        }
        else{

            //sets dungeon size to console arguments
            int row = Integer.parseInt(args[0]);
            int column = Integer.parseInt(args[1]);
            if(row < 1 || column < 1){
                System.out.println("No negative space dungeons, we will assume you wanted a 1x1 dungeon :)");
                row = 1;
                column = 1;
            }

            DungeonGame startGame = new DungeonGame(row, column);

            //runs game code.
            startGame.play();
        }
       
         
=======
        Monster monster = new Monster();
        Player player = new Player("warrior");

        Room room = new Room();

        room.enter(player);
>>>>>>> parent of 6742a92... Implemented good chunk of DungeonMap, updated player and room classes as well.
    }
}