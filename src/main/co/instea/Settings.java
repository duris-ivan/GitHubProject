package main.co.instea;

public class Settings {
    private String inputType;
    private String outputType;

   /* public Settings(){
    }*/

    public Settings(String inputType, String outputType){
        this.inputType=inputType;
        this.outputType=outputType;
    }

    public String getInputType() {
        return inputType;
    }

    public String getOutputType() {
        return outputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
    }

    public void mergeSettings(Settings newSettings){
        if (newSettings == null) return;
        if(!newSettings.getInputType().isEmpty()){
            this.inputType = newSettings.getInputType();
        }
        if(!newSettings.getOutputType().isEmpty()){
            this.outputType =newSettings.getOutputType();
        }
    }
}
