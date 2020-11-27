package main.co.instea.commands;

public abstract class Command {
    public String keyword;
    public String [] allowedSwitches;
    public String [] allowedValues;

    public Command(String keyword, String [] allowedSwitches, String [] allowedValues){
        this.keyword= keyword;
        this.allowedSwitches=allowedSwitches;
        this.allowedValues=allowedValues;
    }

    public boolean shouldBeExecuted(String keyword) {
        return keyword.equals(this.keyword);
    }

    public abstract void execute(String[] commandParts);

    public abstract String help();
}
