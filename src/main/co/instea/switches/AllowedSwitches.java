package main.co.instea.switches;

public enum AllowedSwitches {
    IO_TYPE_INPUT("-r"),
    IO_TYPE_OUTPUT("-w");

    private final String value;

    AllowedSwitches(String value) {
        this.value=value;
    }

    public static AllowedSwitches getFromValue(String value){
        for(AllowedSwitches allowedSwitch : AllowedSwitches.values()){
            if(allowedSwitch.value.equals(value)){
                return allowedSwitch;
            }
        }
        return null;
    }

    public String getValue(){
        return value;
    }
}
