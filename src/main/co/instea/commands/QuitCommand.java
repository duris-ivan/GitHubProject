package main.co.instea.commands;

public class QuitCommand extends Command{


    public QuitCommand(String keyword, MySwitch [] mySwitches) {
        super(keyword,mySwitches);
    }

    @Override
    public void execute(String[] commandParts) {
        System.exit(0);
    }

    @Override
    public String help() {
        return "press 'q' to quit";
    }
}
