package co.instea;

import java.io.IOException;
import java.util.Scanner;

public class BasicCommands_01 {
    public static void listOfCommands(){
        System.out.println("Here is a list of commands");
        System.out.println("* 'h' for help");
        System.out.println("* 'q' to quit the program");
        System.out.println("* 'set' to set read/write mode");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to my console app, type 'h' to learn more.");
        Scanner input = new Scanner(System.in);
        Scanner console = new Scanner(System.in);
        String letter = "";
        String setModeFullText = "";
        //String setMode = "";

        //command line with neverending loop unless 'q' pressed for quit
        while(true) {
            letter = input.nextLine();
            if (letter.equals("h")){
                listOfCommands();
            }
            else if (letter.equals("q")) {
                System.out.println("The console app will quit");
                break;
            }
            else if (letter.equals("set")) {
                System.out.println("Set read / write mode. E.g. command to read from console and write into file  set -r 'console' -w 'file' ");
                setModeFullText = input.nextLine();
                String[] setMode = setModeFullText.split("\\s"); //splits the string based on whitespace
                /*for (String s : setMode)
                    System.out.println(s);
                 */

                // reading mode
                if (setMode[1].equals("-r") ){
                    System.out.println("--- Command for reading ");
                    System.out.println("'set -r file'    OR      'set -r console' ?");
                    setModeFullText = input.nextLine();
                    if (setModeFullText.contains("set -r console")){
                        System.out.println("Enter text to be read from");
                        setModeFullText = input.nextLine();
                        System.out.println(setModeFullText);
                    }
                    else if(setModeFullText.contains("set -r file")){
                        String[] lines = Settings_02.readFromFile("c:/Users/duris/IdeaProjects/GitHubProject/inputFile.txt");
                        System.out.println("Following text was read out of the file");
                        for (String line : lines)
                            System.out.println(line);
                    }
                }
                else if(setMode[1].equals("-w")){
                    System.out.println("--- Command for writing ");
                    System.out.println("'set -w file'    OR      'set -w console' ?");
                    setModeFullText = input.nextLine();
                    if (setModeFullText.contains("set -w console")){
                        System.out.println("Enter text to be written on console");
                        setModeFullText = input.nextLine();
                        System.out.println(setModeFullText);
                    }
                    else if(setModeFullText.contains("set -w file")){
                        System.out.println("Enter text to be written into file");
                        setModeFullText = input.nextLine();
                        Settings_02.writingIntoFile("c:/Users/duris/IdeaProjects/GitHubProject/outputFile.txt", setModeFullText);
                    }

                }
                else if (letter.equals("h")){
                    listOfCommands();
                }
                else if (letter.equals("q")) {
                    System.out.println("The console app will quit");
                    break;
                }
                else {
                    System.out.println("Wrong set command... Now you will returned to 'Set read / write' mode again");
                    continue;
                }
            }
            else
                System.out.println("This is not a valid command");
        }

    }
}
