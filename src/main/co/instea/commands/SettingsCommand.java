package main.co.instea.commands;

import main.co.instea.CommandExecution;
import main.co.instea.Settings;

public class SettingsCommand extends Command{

    public SettingsCommand(String keyword, String[] allowedSwitches, String[] allowedValues) {
        super(keyword, allowedSwitches, allowedValues);
    }

    @Override
    public void execute(String[] commandParts) {
        SetCommand setCommand = new SetCommand("set", new String[] {"-r", "-w"}, new String[] {"file","console"});
        Settings actualSettings = setCommand.getCurrentSettings();
        System.out.println("Input: " + actualSettings.getInputType());
        System.out.println("Output: " + actualSettings.getOutputType());
    }

    @Override
    public String help() {
        return "Press 'settings' to view current settings";
    }
}
