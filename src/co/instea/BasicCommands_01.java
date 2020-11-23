package co.instea;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class BasicCommands_01 {

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to my console app, type 'h' to learn more.");
        Scanner input = new Scanner(System.in);

        String inputCommand;
        String inputCommandTrim;
        Settings settings =new Settings(); //current set configuration for Read/Write

        //command line with never-ending loop unless 'q' pressed for quit
        while(true) {
            System.out.println();
            inputCommand = input.nextLine(); //scanning input
            inputCommandTrim = inputCommand.trim(); //trims unnecessary white spaces of command line
            String[] setMode = inputCommandTrim.split("\\s"); //splits the string based on whitespace
            if (setMode[0].equals("h")){
                FileWriter.listOfCommands();
            }
            else if (setMode[0].equals("q")) {
                System.out.println("The console app will quit");
                break;
            }
            else if (setMode[0].equals("set")) {
                settings = CommandExecution.setMethod(setMode);
            }
            else if (setMode[0].equals("settings")) {
                System.out.println("Input Type: " + settings.getInputType());
                System.out.println("Output Type: " + settings.getOutputType());
            }
            else
                System.out.println("This is not a valid command");
                continue;
        }
    }
}
