package main.co.instea.commands;

import main.co.instea.Main;
import main.co.instea.Settings;

public class SetCommand extends Command {
    public SetCommand(String keyword, MySwitch [] mySwitches) {
        super(keyword, mySwitches);
    }


    @Override
    public void execute(String[] commandParts) {
        Settings newSettings = setMethod(commandParts);
        Main.getCurrentSettings().mergeSettings(newSettings);
    }

    @Override
    public String help() {
        return "write 'set -r file -w console' to read from file into console ";
    }

    public Settings setMethod (String[] setMode) {
        String inputType=new String();
        String outputType=new String();
        String sWitch;
        String value;

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
                for (int j=0;j<mySwitches.length;j++){
                    if (sWitch.equals(mySwitches[j].getKey())){
                        matchOccurred=true;
                        for(int k=0;k<mySwitches[j].getAllowedValues().length;k++){
                            matchOccurred=true;
                        }
                    }
                }
                if(!matchOccurred) {
                    throw new Exception("go to catch - NoSwitch or NoValue Error");
                }
                if(sWitch.equals(mySwitches[0].getKey())){
                    if(value.equals(mySwitches[0].getAllowedValues()[0])){
                        inputType=mySwitches[0].getAllowedValues()[0];
                    }
                    else if(value.equals(mySwitches[0].getAllowedValues()[1])){
                        inputType=mySwitches[0].getAllowedValues()[1];
                    }
                }
                else if(sWitch.equals(mySwitches[1].getKey())){
                    if(value.equals(mySwitches[1].getAllowedValues()[0])){
                        outputType=mySwitches[1].getAllowedValues()[0];
                    }
                    else if(value.equals(mySwitches[1].getAllowedValues()[1])){
                        outputType=mySwitches[1].getAllowedValues()[1];
                    }
                }
                /*

                else if(sWitch.equals(switchArray[1])){
                    if(value.equals(valueArray[0])){
                        outputType="console";
                    }
                    else if(value.equals(valueArray[1])){
                        outputType="file";
                    }
                }*/
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
