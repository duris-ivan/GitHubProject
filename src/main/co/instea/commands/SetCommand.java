package main.co.instea.commands;

import main.co.instea.CommandExecution;
import main.co.instea.Settings;

public class SetCommand extends Command {
    public SetCommand(String keyword, String[] allowedSwitches, String[] allowedValues) {
        super(keyword, allowedSwitches, allowedValues);
    }

    @Override
    public void execute(String[] commandParts) {
        Settings newSettings = CommandExecution.setMethod(commandParts);
        if (newSettings != null) {
            CommandExecution.setCurrentSettings(newSettings);
        }
    }

    @Override
    public String help() {
        return "write 'set -r file -w console' to read from file into console ";
    }
}
