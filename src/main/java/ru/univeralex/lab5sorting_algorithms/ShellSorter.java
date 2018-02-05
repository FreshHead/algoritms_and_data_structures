package ru.univeralex.lab5sorting_algorithms;

import ru.univeralex.lab5sorting_algorithms.api.Sorter;
import ru.univeralex.utils.Calculator;

public class ShellSorter implements Sorter {
    int[] steps = new int[]{1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191};

    @Override
    public int[] sort(int[] array) {
        return new int[0];
    }

    private int getNumberOfSteps(int[] array) {
        return Calculator.absoluteLogOfBase2(array.length) - 1;
    }
}
