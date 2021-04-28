import java.util.Scanner;

public class Main {
    /* Entry point of the application */
    
    public static void main(String[] args) {

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

            DungeonGame startGame = new DungeonGame(row, column);

            //runs game code.
            startGame.play();
        }
         
    }
}