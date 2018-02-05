package ru.univeralex.utils;

public class ArrayConverter {
    public String convert(int[] array) {
        StringBuilder stringBuilder = new StringBuilder().append(array[0]);
        for (int i = 1; i < array.length; i++) {
            stringBuilder.append(", ").append(array[i]);
        }
        return stringBuilder.toString();
    }

    public int[] convert(Integer[] array) {
        int[] resultedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultedArray[i] = array[i];
        }
        return resultedArray;
    }
}
