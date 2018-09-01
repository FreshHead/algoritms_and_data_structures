package ru.univeralex.lab5sorting;

import ru.univeralex.lab5sorting.api.Sorter;

import java.util.Arrays;

public class BubbleSorter implements Sorter {
    @Override
    public int[] getSorted(int[] array) {
        int[] resultingArray = Arrays.copyOf(array, array.length);
        int smaller_element;
        for (int i = 0; i < resultingArray.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (resultingArray[j] < resultingArray[j - 1]) {
                    smaller_element = resultingArray[j];
                    resultingArray[j] = resultingArray[j - 1];
                    resultingArray[j - 1] = smaller_element;
                }
            }
        }
        return resultingArray;
    }
}
