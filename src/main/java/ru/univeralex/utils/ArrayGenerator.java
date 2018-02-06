package ru.univeralex.utils;

import java.util.Random;

public class ArrayGenerator {
    public static int[] generate(int range, int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }
}
