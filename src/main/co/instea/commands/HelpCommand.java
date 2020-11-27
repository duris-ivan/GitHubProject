package main.co.instea.commands;

public class HelpCommand extends Command{

    public HelpCommand(String keyword, String[] allowedSwitches, String[] allowedValues) {
        super(keyword, allowedSwitches, allowedValues);
    }

    @Override
    public void execute() {
    }

    @Override
    public String help() {
        return "press 'h' for help";
    }
}
