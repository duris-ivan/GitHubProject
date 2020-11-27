package main.co.instea.commands;

public class SettingsCommand extends Command{

    public SettingsCommand(String keyword, String[] allowedSwitches, String[] allowedValues) {
        super(keyword, allowedSwitches, allowedValues);
    }

    @Override
    public void execute() {

    }

    @Override
    public String help() {
        return "Press 'settings' to view current setup";
    }
}
