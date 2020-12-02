package main.co.instea.commands;

public abstract class Command {
    public String keyword;
    public MySwitch [] mySwitches;

    public Command(String keyword, MySwitch [] mySwitches){
        this.keyword= keyword;
        this.mySwitches= mySwitches;
    }

    public boolean shouldBeExecuted(String keyword) {
        return keyword.equals(this.keyword);
    }

    public abstract void execute(String[] commandParts);

    public abstract String help();
}
