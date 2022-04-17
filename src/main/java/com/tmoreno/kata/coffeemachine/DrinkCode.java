package com.tmoreno.kata.coffeemachine;

public enum DrinkCode {
    TEA("T", "tea"),
    COFFEE("C", "coffee"),
    CHOCOLATE("H", "chocolate"),
    ORANGE_JUICE("O", "orange juice");

    private final String code;
    private final String humanReadable;

    DrinkCode(String code, String humanReadable) {
        this.code = code;
        this.humanReadable = humanReadable;
    }

    public String getCode() {
        return code;
    }

    public String getHumanReadable() {
        return humanReadable;
    }
}
