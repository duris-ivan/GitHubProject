package co.instea;

public class SetMethod {
    public static void setMethod (String[] setMode){
        String inputType;
        String outputType;

        String oldInput = "console";
        String oldOutput = "console";

        String newInput= null;
        String newOutput = null;
        boolean errorOccurred=false;

        for (int i=1; i<setMode.length; i++){
            if (setMode[i].equals("-r")){ //reading Mode
                if (setMode.length>2){
                    if (setMode[i+1].equals("file")){
                        newInput = " file"; // reading from file
                    }
                    else if(setMode[i+1].equals("console")){
                        newInput = " console";  //reading from console
                    }
                    else{
                        errorOccurred=true;
                        break;
                    }
                }
            }
            else if (setMode[i].equals("-w")) { //writing Mode
                if (setMode.length>2){
                    if (setMode[i+1].equals("file")){ //writing into file
                        newOutput= " file, ";
                    }
                    else if(setMode[i+1].equals("console")){ ////writing into console
                        newOutput = " console, ";
                    }
                    else{
                        errorOccurred = true;
                        break;
                    }
                }
            }
            else{
                if (setMode[0].equals("set") && (setMode[1].equals("-r") || setMode[1].equals("-w")))
                    continue;
                else {
                    System.out.println("error in set command");
                    break;
                }
            }
        }

        if(!errorOccurred){
            inputType=newInput;
            if (inputType==null)
                inputType=oldInput;
            System.out.println("read from " + inputType);
            outputType=newOutput;
            if (outputType==null)
                outputType=oldOutput;
            System.out.println("write into " + outputType);
        }
        else { //error has occurred
            System.out.println("Error Reading / Writing");
            inputType = oldInput;
            System.out.println("read from " + inputType);
            outputType = oldOutput;
            System.out.println("write into " + outputType);
        }
    }
}
