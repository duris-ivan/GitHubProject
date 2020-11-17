package co.instea;

public class SetMethod {
    public static void setMethod (String[] setMode){
        String oldInput = "console";
        String oldOutput = "console";

        String inputType;
        String outputType;

        String newInput= null;
        String newOutput = null;
        boolean errorOccurred=false;
        boolean errorOccurred2=false;
        boolean[] errorArray = new boolean[setMode.length];

        //little for-loop to find out, if command line contains valid commands
        for(int i=1; i<setMode.length;i++){
            // if :contains valid commands --> no error occurred
            if (setMode[i].equals("-r") || setMode[i].equals("-w") ||
                setMode[i].equals("file") || setMode[i].equals("console") ||
                setMode[i].equals("-cs")){ //-cs stands for current settings
                errorOccurred2=false;
            }
            else // else: for invalid command occurrence -->  error occurred
                errorOccurred2=true;
            errorArray[i]=errorOccurred2;
        }
        //boolean array vyhodnotenie
        for(int i=0;i<errorArray.length;i++){
            if(errorArray[i]==true)
                errorOccurred2=true;
        }

        //System.out.println("--- error Occured 2: " + errorOccurred2);
        if(!errorOccurred2){
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
                    if (setMode[0].equals("set") && (setMode[1].equals("-r")
                            || setMode[1].equals("-w") || setMode[1].equals("-cs")))
                        continue;
                    else {
                        System.out.println("error in set command");
                        break;
                    }
                }
            }
        }
        else{
            System.out.println("! error in set command");
        }


        if(!errorOccurred){
            inputType=newInput;
            if (inputType==null)
                inputType=oldInput;
            // System.out.println("read from " + inputType);
            outputType=newOutput;
            if (outputType==null)
                outputType=oldOutput;
            // System.out.println("write into " + outputType);
        }
        else { //error has occurred
            System.out.println("Error Reading / Writing");
            inputType = oldInput;
            outputType = oldOutput;
        }

        //for-loop for -cs command
        for(int i=1; i<setMode.length;i++){
            if (setMode[i].equals("-cs")){
                System.out.println("read from " + inputType);
                System.out.println("write into " + outputType);
            }
        }




    }
}
