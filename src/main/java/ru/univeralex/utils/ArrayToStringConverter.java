package ru.univeralex.utils;

public class ArrayToStringConverter {
    public String convert(int[] array) {
        StringBuilder stringBuilder = new StringBuilder().append(array[0]);
        for (int i = 1; i < array.length; i++) {
            stringBuilder.append(", ").append(array[i]);
        }
        return stringBuilder.toString();
    }
}
