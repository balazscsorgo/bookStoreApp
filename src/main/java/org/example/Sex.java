package org.example;

public enum Sex {
    M("M"),
    F("F");

    private String st;

    Sex(String st) {
        this.st = st;
    }

    public String getSt() {
        return st;
    }

    public static Sex fromString(String st) {
        for (Sex sex: Sex.values()) {
                if (sex.st.equalsIgnoreCase(st)) {
                return sex;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "st='" + st + '\'' +
                '}';
    }

}