package co.instea;

import java.util.Scanner;

public class BasicCommands_01 {
    public static void main(String[] args) {
        System.out.println("Welcome to my console app, type 'h' to learn more.");
        Scanner input = new Scanner(System.in);
        String letter = "";

        //command line with neverending loop unless 'q' pressed for quit
        while(true) {
            letter = input.nextLine();
            if (letter.equals("h")){
                System.out.println("Here is a list of commands");
                System.out.println("* 'h' for help");
                System.out.println("* 'q' to quit the program");
            }
            else if (letter.equals("q")) {
                System.out.println("The console app will quit");
                break;
            }
            else
                System.out.println("This is not a valid command");
        }

    }
}
