package main.co.instea;

import java.util.Scanner;

public class BasicCommands_01 {

    public static void main(String[] args)  {
        System.out.println("Welcome to my console app, type 'h' to learn more.");
        Scanner input = new Scanner(System.in);
        Settings settings=new Settings("console", "console");
        String oldInput = "console";
        String oldOutput = "console";

        String inputCommand;
        String inputCommandTrim;
         //current set configuration for Read/Write

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
                if (settings!=null){ //saving the parameters
                    oldInput = settings.getInputType();
                    oldOutput = settings.getOutputType();
                }
            }
            else if (setMode[0].equals("settings")) {
                System.out.println("Input Type: " + oldInput);
                System.out.println("Output Type: " + oldOutput);
            }
            else
                System.out.println("This is not a valid command");
                continue;
        }
    }
}
