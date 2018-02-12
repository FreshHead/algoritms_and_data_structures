package ru.univeralex.lab5sorting;

import ru.univeralex.lab5sorting.api.Sorter;
import ru.univeralex.utils.ArrayUtils;

import java.util.Arrays;

public class HeapSorter implements Sorter {
    @Override
    public int[] getSorted(int[] array) {
        int[] startOnOneArray = new int[array.length + 1];
        for (int i = 1; i < startOnOneArray.length; i++) startOnOneArray[i] = array[i - 1];

        int N = startOnOneArray.length - 1;
        for (int k = N / 2; k >= 1; k--) sink(startOnOneArray, k, N);
        while (N > 1) {
            ArrayUtils.swap(startOnOneArray, 1, N--);
            sink(startOnOneArray, 1, N);
        }
        int[] resultingArray = new int[array.length];
        Arrays.setAll(resultingArray, i -> startOnOneArray[i + 1]);
        return resultingArray;
    }

    private void sink(int[] array, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && array[j] < array[j + 1]) j++;
            if (array[k] > array[j]) break;
            ArrayUtils.swap(array, k, j);
            k = j;
        }
    }
}
