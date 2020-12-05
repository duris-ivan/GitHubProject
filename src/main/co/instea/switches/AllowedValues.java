package main.co.instea.switches;

public enum AllowedValues {
    IO_TYPE_FILE("file"),
    IO_TYPE_CONSOLE("console");

    private final String value;

    AllowedValues(String value) {
        this.value=value;
    }

    public static AllowedValues getFromValue(String value){
        for(AllowedValues allowedValue : AllowedValues.values()){
            if(allowedValue.value.equals(value)){
                return allowedValue;
            }
        }
        return null;
    }

    public String getValue(){
        return value;
    }
}
