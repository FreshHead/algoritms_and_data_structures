package ru.univeralex.lab5sorting_algorithms;

import ru.univeralex.lab5sorting_algorithms.api.Sorter;
import ru.univeralex.utils.ArrayUtils;

public class QuickSorter implements Sorter {
    private int[] array;

    @Override
    public int[] sort(int[] array) {
        this.array = array;
        sort(this.array, 0, this.array.length - 1);
        return this.array;
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
