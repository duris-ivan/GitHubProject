package co.instea;

import javax.swing.*;
import java.util.ArrayList;

public class CommandExecution {


    public static void setMethod (String[] setMode)throws Exception{
        String oldInput = "console";
        String oldOutput = "console";

        String inputType;
        String outputType;
        String valueSet;

        String newInput= null;
        String newOutput = null;
        boolean errorOccurred=false;

        int j=0;
        String[] sWitch= new String[setMode.length]; //ToDo Jozef mentoring: size of Array
        String[] value= new String[setMode.length];
        String[] switchArray= {"-r","-w"};
        String[] valueArray= {"console","file"};

        boolean flagNotR=false;
        boolean flagNotW=false;
        boolean flagNotCons=false;
        boolean flagNotFile=false;



        //loop to separate all setModeCommands into array of size two: switch and value
        try{
            for(int i=1;i<setMode.length;i+=2){
                sWitch[j]=setMode[i];
                value[j]=setMode[i+1];
                if(value!=null)
                    errorOccurred= true;
                if(sWitch[j]!=(switchArray[0])){
                    flagNotR=true;
                }
                if(sWitch[j]!=switchArray[1]){
                    flagNotW=true;
                }
                if(flagNotR && flagNotW){
                    throw new Exception("go to catch");
                }
                if(value[j]!=(valueArray[0])){
                    flagNotCons=true;
                }
                if(value[j]!=(valueArray[1])){
                    flagNotFile=true;
                }
                if(flagNotCons && flagNotFile){
                    throw new Exception("go to catch");
                }
                if(sWitch[j].equals(switchArray[0])){
                    inputType="read from";
                    System.out.println(inputType);
                }
                else if(sWitch[j].equals(switchArray[1])){
                    outputType="write to";
                    System.out.println(outputType);
                }
                if(value[j].equals(valueArray[0])){
                    valueSet=valueArray[0];
                    System.out.println(valueSet);
                }
                else if(value[j].equals(valueArray[1])){
                    valueSet=valueArray[1];
                    System.out.println(valueSet);
                }
                j++;
            }
        }
        catch(Exception e){
            if(errorOccurred){
                System.out.println("error in set command - possibly ArrayOutOfBoundException");
            }
        }
        finally {
            System.out.println("this is always written");
        }

    }
}
