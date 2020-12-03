package main.co.instea.commands;

import main.co.instea.Settings;

public class MySwitch {
    private String key;
    private String[] allowedValues;

    public MySwitch(String key, String[] allowedValues) {
        this.key = key;
        this.allowedValues = allowedValues;
    }

    public String getKey() {
        return key;
    }

    public String[] getAllowedValues() {
        return allowedValues;
    }
}
