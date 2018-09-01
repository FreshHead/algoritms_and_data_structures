package ru.univeralex.lab5sorting;

import ru.univeralex.lab5sorting.api.Sorter;

public class SelectionSorter implements Sorter {
    @Override
    public int[] getSorted(int[] array) {
        int[] resultArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int indexOfSmallest = getIndexOfSmallest(array);
            resultArray[i] = array[indexOfSmallest];
            array[indexOfSmallest] = Integer.MAX_VALUE;

        }
        return resultArray;
    }

    private int getIndexOfSmallest(int[] array) {
        int indexOfSmallest = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[indexOfSmallest]) indexOfSmallest = i;
        }
        return indexOfSmallest;
    }
}
