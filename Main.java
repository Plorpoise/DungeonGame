import java.util.Scanner;

public class Main {
    /* Entry point of the application */
    //sssss
    
    public static void main(String[] args) {
        String consoleInput;
        boolean correctDSInput = false;

        //TODO: change to non-default
        DungeonGame dungeonSize = new DungeonGame(10, 10);

        //System.out.println(args[0]);

        //calls DungeonGame overloaded constructor
        dungeonSize.play();
         
    }
}