package ru.univeralex.lab5sorting_algorithms;

import ru.univeralex.lab5sorting_algorithms.api.Sorter;
import ru.univeralex.utils.ArrayUtils;

import java.util.ArrayList;

public class InsertionSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        ArrayList<Integer> sortedList = new ArrayList<>(10);

        for (int current : array) {
            getSortedWithValue(sortedList, current);
        }
        Integer[] integers = new Integer[array.length];
        sortedList.toArray(integers);
        return ArrayUtils.convert(integers);
    }

    private void getSortedWithValue(ArrayList<Integer> sortedList, int value) {
        for (int i = 0; i < sortedList.size(); i++) {
            if (value < sortedList.get(i)) {
                sortedList.add(i, value);
                return;
            }
        }
        sortedList.add(value);
    }
}
