package ru.univeralex.algoritms_and_data_structures.labs.lab5sorting;


import ru.univeralex.algoritms_and_data_structures.labs.lab5sorting.api.Sorter;
import ru.univeralex.algoritms_and_data_structures.labs.utils.ArrayUtils;

import java.util.Arrays;

public class QuickSorter implements Sorter {

    @Override
    public int[] getSorted(int[] array) {
        int[] resultingArray = Arrays.copyOf(array, array.length);
        sort(resultingArray, 0, resultingArray.length - 1);
        return resultingArray;
    }

    private void sort(int[] array, int low, int high) {
        if (high <= low) return;
        int j = partition(array, low, high);
        sort(array, low, j - 1);
        sort(array, j + 1, high);
    }

    private int partition(int[] array, int low, int high) {
        int i = low, j = high + 1;

        while (true) {
            while (array[++i] < array[low]) if (i == high) break;
            while (array[--j] > array[low]) if (j == low) break;
            if (i >= j) break;
            ArrayUtils.swap(array, i, j);
        }
        ArrayUtils.swap(array, low, j);
        return j;
    }

}
