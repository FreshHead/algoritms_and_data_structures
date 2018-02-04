package ru.univeralex.lab5sorting_algorithms;

import ru.univeralex.lab5sorting_algorithms.api.Sorter;

public class BubbleSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        int smaller_element;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    smaller_element = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = smaller_element;
                }
            }
        }
        return array;
    }
}
