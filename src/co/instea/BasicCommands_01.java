package co.instea;

import java.util.Scanner;

public class BasicCommands_01 {
    public static void main(String[] args) {
        System.out.println("Enter following commands: ");
        System.out.println("* 'h' for help");
        System.out.println("* 'q' to quit the program");
        Scanner input = new Scanner(System.in);
        String letter = "";

        //command line with neverending loop unless 'q' pressed for quit
        while(true) {
            letter = input.nextLine();
            if(letter.equals("q"))
                break;
            else if (letter.equals("h"))
                System.out.println("ToBeDone> List of commands");
            else
                System.out.println("This is not a valid command");
        }
    }
}
