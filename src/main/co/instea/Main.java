package main.co.instea;

import main.co.instea.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Command> listOfCommands;

    static {
        listOfCommands = new ArrayList<>();
        listOfCommands.add(new QuitCommand("q", new String[] {}, new String[] {}));
        listOfCommands.add(new HelpCommand("h", new String[] {}, new String[] {}));
        listOfCommands.add(new SetCommand("set", new MySwitch[] {"-r", new String[] {"file", "console"}}));
        listOfCommands.add(new SettingsCommand("settings", new String[] {}, new String[] {}));
    }

    private static Settings currentSettings = new Settings("console", "console");

    public static void setCurrentSettings(Settings settings) {
        if (settings == null) return;
        currentSettings = settings;
    }

    public static Settings getCurrentSettings() {
        return currentSettings;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to my console app, type 'h' to learn more.");
        Scanner input = new Scanner(System.in);

        String inputCommand;
        String inputCommandTrim;

        //command line with never-ending loop unless 'q' pressed for quit
        outerLoop: while(true) {
            System.out.println();
            inputCommand = input.nextLine(); //scanning input
            inputCommandTrim = inputCommand.trim(); //trims unnecessary white spaces of command line
            String[] commandParts = inputCommandTrim.split("\\s"); //splits the string based on whitespace
            for (Command command: listOfCommands) {
                if (command.shouldBeExecuted(commandParts[0])) {
                    command.execute(commandParts);
                    continue outerLoop;
                }
            }
            System.out.println("Unknown command.");
        }



    }
}
