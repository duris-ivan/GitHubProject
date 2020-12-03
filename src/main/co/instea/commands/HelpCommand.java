package main.co.instea.commands;

import main.co.instea.Main;

public class HelpCommand extends Command{

    public HelpCommand(String keyword, MySwitch[] mySwitches) {
        super(keyword,mySwitches);
    }

    @Override
    public void execute(String[] commandParts) {
        System.out.println("List of commands:");
        for (Command c: Main.listOfCommands) {
            System.out.println(c.help());
        }
    }

    @Override
    public String help() {
        return "press 'h' for help";
    }
}
