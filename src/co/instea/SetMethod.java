package co.instea;

public class SetMethod {
    public static void setMethod (String[] setMode){
        for (int i=0; i<setMode.length; i++){
            if (i==0){
                continue;
            }
            else if (setMode[i].equals("-r")){
                System.out.print("read: ");
                if (setMode.length>2){
                    if (setMode[i+1].equals("file"))
                        System.out.print(" from file, ");
                    else if(setMode[i+1].equals("console"))
                        System.out.print(" from console, ");
                    else
                        System.out.println("reading error");
                }
            }
            else if (setMode[i].equals("-w")) {
                System.out.print("write: ");
                if (setMode.length>2){
                    if (setMode[i+1].equals("file"))
                        System.out.print(" into file, ");
                    else if(setMode[i+1].equals("console"))
                        System.out.print(" into console, ");
                    else
                        System.out.println("writing error");
                }
            }
            else
                if (setMode[0].equals("set") && (setMode[1].equals("-r") || setMode[1].equals("-w")))
                    continue;
                else
                    System.out.println("error in set command");
        }
    }
}
