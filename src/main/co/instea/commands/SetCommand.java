package main.co.instea.commands;

import main.co.instea.CommandExecution;
import main.co.instea.Settings;

public class SetCommand extends Command {
    public SetCommand(String keyword, String[] allowedSwitches, String[] allowedValues) {
        super(keyword, allowedSwitches, allowedValues);
    }
    private String inputType="";
    private String outputType="";
    public Settings currentSettings = new Settings("console","console");

    @Override
    public void execute(String[] commandParts) {
        Settings newSettings = setMethod(commandParts);
//        if (newSettings != null) {
            setCurrentSettings(newSettings);
    }

    public void setCurrentSettings(Settings settings) {
        if (settings == null) return;
        currentSettings = settings;
    }

    public Settings getCurrentSettings() {
        return currentSettings;
    }

    @Override
    public String help() {
        return "write 'set -r file -w console' to read from file into console ";
    }

    public Settings setMethod (String[] setMode) {

        String sWitch;
        String value;
        String[] switchArray= {"-r","-w"};
        String[] valueArray= {"console","file"};

        //loop to separate all setModeCommands into array of size two: switch and value
        try{
            if(setMode.length==1) {
                throw new Exception("caught error - not a full command");
            }

            for(int i=1;i<setMode.length;i+=2){
                sWitch=setMode[i];
                if(i>=0 && (i+1)<setMode.length){
                    value=setMode[i+1];
                }
                else {
                    throw new Exception("caught error - value was out of Array Bounds");
                }

                boolean matchOccurred=false;
                for (int j=0;j<switchArray.length;j++){
                    if (sWitch.equals(switchArray[j])){
                        matchOccurred=true;
                    }
                }
                if(!matchOccurred) {
                    throw new Exception("go to catch - NoSwitch Error");
                }

                matchOccurred=false;
                for (int j=0;j<valueArray.length;j++){
                    if (value.equals(valueArray[j])){
                        matchOccurred=true;
                    }
                }
                if(!matchOccurred) {
                    throw new Exception("go to catch - NoValue Error");
                }

                if(sWitch.equals(switchArray[0])){
                    if(value.equals(valueArray[0])){
                        inputType="console";
                    }
                    else if(value.equals(valueArray[1])){
                        inputType="file";
                    }
                }
                else if(sWitch.equals(switchArray[1])){
                    if(value.equals(valueArray[0])){
                        outputType="console";
                    }
                    else if(value.equals(valueArray[1])){
                        outputType="file";
                    }
                }
            }
            Settings settings = new Settings(inputType,outputType);

            return settings;

        }
        catch(Exception e){
            System.out.println("error in set command");
            //e.printStackTrace();
            return null;
        }
    }

}
