package com.feliperuppel.attributesample;

public class Attribute<T> {
    private final String key;
    private final T value;

    public Attribute(String key, T value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" : %s \n", key, value instanceof String ? "\"" + value + "\"" : value);
    }
}
