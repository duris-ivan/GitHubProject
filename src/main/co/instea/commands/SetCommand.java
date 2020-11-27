package main.co.instea.commands;

public class SetCommand extends Command {
    public SetCommand(String keyword, String[] allowedSwitches, String[] allowedValues) {
        super(keyword, allowedSwitches, allowedValues);
    }

    @Override
    public void execute() {

    }

    @Override
    public String help() {
        return "write 'set -r file -w console' to read from file into console ";
    }
}
