package co.instea;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class BasicCommands_01 {


    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to my console app, type 'h' to learn more.");
        Scanner input = new Scanner(System.in);
        Scanner console = new Scanner(System.in);
        String letter;
        String letterTrim;
        String setModeFullText = "";
        //String setMode = "";

        //command line with neverending loop unless 'q' pressed for quit
        while(true) {
            letter = input.nextLine();
            letterTrim = letter.trim();
            if (letterTrim.equals("h")){
                Settings_02.listOfCommands();
            }
            else if (letterTrim.equals("q")) {
                System.out.println("The console app will quit");
                break;
            }
            else if (letterTrim.equals("set") || letterTrim.contains("set " + "-r") || letterTrim.contains("set " + "-w")) {
                System.out.println("Set read / write mode.");
                System.out.println("E.g. command to read from console and write into file: 'set -r console -w file' ");
                setModeFullText = input.nextLine();
                String[] setMode = setModeFullText.split("\\s"); //splits the string based on whitespace
                boolean switcherRead=false;
                boolean switcherWrite=false;
                int rValue=0;
                int wValue=0;
                for (int i=0; i<setMode.length; i++){
                    if (setMode[i].equals("-r")){
                        switcherRead = true;
                        rValue=i;
                        //System.out.println("-r position: " + rValue);
                    }
                    else if (setMode[i].equals("-w")) {
                        switcherWrite = true;
                        wValue=i;
                        //System.out.println("-w position: " + wValue);
                    }
                }

                if(switcherRead==true && switcherWrite==true){
                    if(setMode[rValue+1].equals("file") && setMode[wValue+1].equals("file")){
                        System.out.println("ToDo> Setup for reading from file and writing into file");
                        continue;
                    }
                    else if(setMode[rValue+1].equals("file")&& setMode[wValue+1].equals("console")){
                        System.out.println("ToDo> Setup for reading from file and writing into console");
                        continue;
                    }
                    else if(setMode[rValue+1].equals("console")&& setMode[wValue+1].equals("file")){
                        System.out.println("ToDo> Setup for reading from console and writing into file");
                        continue;
                    }
                    else if(setMode[rValue+1].equals("console")&& setMode[wValue+1].equals("console")){
                        System.out.println("ToDo> Setup for reading from console and writing into console");
                        continue;
                    }
                    else
                        continue;
                }
                else if(switcherRead==true&& switcherWrite==false){
                    if(setMode[rValue+1].equals("file")){
                        System.out.println("ToDo> Setup for reading from file");
                        continue;
                    }
                    else if(setMode[rValue+1].equals("console")){
                        System.out.println("ToDo> Setup for reading from console");
                        continue;
                    }
                    else
                        continue;
                }
                else if(switcherRead==false&& switcherWrite==true){
                    if(setMode[wValue+1].equals("file")){
                        System.out.println("ToDo> Setup for writing into file");
                        continue;
                    }
                    else if(setMode[wValue+1].equals("console")){
                        System.out.println("ToDo> Setup for writing to console");
                        continue;
                    }
                    else
                        continue;
                }
                else
                    continue;
            }
            else
                System.out.println("This is not a valid command");
                continue;
        }

    }
}
