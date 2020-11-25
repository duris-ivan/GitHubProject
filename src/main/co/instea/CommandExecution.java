package main.co.instea;

public class CommandExecution {
        public static String inputType="console";
        public static String outputType="console";


        public static Settings setMethod (String[] setMode) {

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
