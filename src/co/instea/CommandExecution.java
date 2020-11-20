package co.instea;

import javax.swing.*;
import java.util.ArrayList;

public class CommandExecution {

    public static Settings setMethod (String[] setMode) throws Exception{
        String inputType="";
        String outputType="";


        String newInput= null;
        String newOutput = null;

        String sWitch;
        String value;
        String[] switchArray= {"-r","-w"};
        String[] valueArray= {"console","file"};


        //loop to separate all setModeCommands into array of size two: switch and value
        try{
            for(int i=1;i<setMode.length;i+=2){
                sWitch=setMode[i];
                if(i>=0 && (i+1)<setMode.length)
                    value=setMode[i+1];
                else
                    throw new Exception("caught error - value was out of Array Bounds");
                /*for (int j=0;j<switchArray.length;j++){
                    if (!sWitch.equals(switchArray[j])){

                    }
                }*/

                //if(!sWitch.equals(switchArray[0]) && !sWitch.equals(switchArray[1])){
                /*if(!sWitch.equals(switchArray[0])){
                    throw new Exception("go to catch - NoSwitch Error");
                }
                else if(!sWitch.equals(switchArray[1])){
                    throw new Exception("go to catch - NoSwitch Error");
                }
                if(!value.equals(valueArray[0])){
                    throw new Exception("go to catch - NoValue Error");
                }
                else if(!value.equals(valueArray[1])){
                    throw new Exception("go to catch - NoValue Error");
                }*/
                if(sWitch.equals(switchArray[0])){
                    if(value.equals(valueArray[0]))
                        inputType="console";
                    else if(value.equals(valueArray[1]))
                        inputType="file";
                }
                else if(sWitch.equals(switchArray[1])){
                    if(value.equals(valueArray[0]))
                        outputType="console";
                    else if(value.equals(valueArray[1]))
                        outputType="file";
                }
            }

        }
        catch(Exception e){
            System.out.println("error in set command");
            e.printStackTrace();
        }
        finally {
            System.out.println("this is always written");
        }
        Settings settings = new Settings(inputType,outputType);
        System.out.println("Input Type:"+ settings.getInputType());
        System.out.println("Output Type:"+ settings.getOutputType());
        return settings;
    }
}
