package org.example;

public enum Sex {
    M("M"),
    F("F");

    private final String st;

    Sex(String st) {
        this.st = st;
    }

    public String getSt() {
        return this.st;
    }
}