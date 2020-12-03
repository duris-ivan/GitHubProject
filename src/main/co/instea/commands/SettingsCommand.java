package main.co.instea.commands;

import main.co.instea.CommandExecution;
import main.co.instea.Settings;
import main.co.instea.Main;

public class SettingsCommand extends Command{

    public SettingsCommand(String keyword, MySwitch[] mySwitches) {
        super(keyword,mySwitches);
    }

    @Override
    public void execute(String[] commandParts) {
        Settings actualSettings = Main.getCurrentSettings();
        System.out.println("Input: " + actualSettings.getInputType());
        System.out.println("Output: " + actualSettings.getOutputType());
    }

    @Override
    public String help() {
        return "Press 'settings' to view current settings";
    }
}
