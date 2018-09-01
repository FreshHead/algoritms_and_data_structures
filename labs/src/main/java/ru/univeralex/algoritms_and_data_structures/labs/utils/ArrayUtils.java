package ru.univeralex.algoritms_and_data_structures.labs.utils;

import java.util.Random;

public class ArrayUtils {
    public static String convert(int[] array) {
        StringBuilder stringBuilder = new StringBuilder().append(array[0]);
        for (int i = 1; i < array.length; i++) {
            stringBuilder.append(", ").append(array[i]);
        }
        return stringBuilder.toString();
    }

    public static int[] convert(Integer[] array) {
        int[] resultedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultedArray[i] = array[i];
        }
        return resultedArray;
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static int[] generate(int range, int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
