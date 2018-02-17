package ru.univeralex.lab5sorting;

import ru.univeralex.lab5sorting.api.Sorter;
import ru.univeralex.utils.ArrayUtils;

import java.util.Arrays;

public class HeapSorter implements Sorter {
    @Override
    public int[] getSorted(int[] array) {
        int[] sortingArray = Arrays.copyOf(array, array.length);
        int N = sortingArray.length;
        for (int k = N / 2; k > 0; k--) sink(sortingArray, k, sortingArray.length - 1);
        while (N > 0) {
            ArrayUtils.swap(sortingArray, 0, --N);
            sink(sortingArray, 0, N);
        }
        return sortingArray;
    }

    private void sink(int[] array, int k, int N) {

        while (2 * k + 1 < N) {
            int j = 2 * k + 1;
            if (j + 1 < N && array[j] < array[j + 1]) j++;
            if (array[k] > array[j]) break;
            ArrayUtils.swap(array, k, j);
            k = j;
        }
    }
}
