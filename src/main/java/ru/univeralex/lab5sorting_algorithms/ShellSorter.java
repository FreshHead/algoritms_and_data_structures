package ru.univeralex.lab5sorting_algorithms;

import ru.univeralex.lab5sorting_algorithms.api.Sorter;
import ru.univeralex.utils.Calculator;

import java.util.Arrays;

public class ShellSorter implements Sorter {
    private int[] steps = new int[]{1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191};
    private Sorter sorter = new SelectionSorter();

    @Override
    public int[] getSorted(int[] array) {
        int[] resultingArray = new int[array.length];
        for (int i = getNumberOfSteps(array) - 1; i >= 0; i--) {
            resultingArray = getSortedNthStep(steps[i], array);
        }
        return resultingArray;
    }

    private int getNumberOfSteps(int[] array) {
        return Calculator.absoluteLogOfBase2(array.length) - 1;
    }

    private int[] getSortedNthStep(int n, int[] array) {
        int[] sortedNthArray = sorter.getSorted(getEveryNth(n, array));
        int[] resultingArray = Arrays.copyOf(array, array.length);
        for (int i = 0, index = n - 1; i < sortedNthArray.length; i++, index += n) {
            resultingArray[index] = sortedNthArray[i];
        }
        return resultingArray;
    }

    protected int[] getEveryNth(int n, int[] array) {
        int resultingSize = array.length / n;
        int[] resultingArray = new int[resultingSize];
        for (int i = 0, index = n - 1; i < resultingSize; i++, index += n) {
            resultingArray[i] = array[index];
        }
        return resultingArray;
    }
}
