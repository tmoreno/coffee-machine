package com.tmoreno.kata.coffeemachine;

public enum DrinkCode {
    TEA("T"),
    COFFEE("C"),
    CHOCOLATE("H"),
    ORANGE_JUICE("O");

    private final String code;

    DrinkCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
