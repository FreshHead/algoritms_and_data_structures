package ru.univeralex.algoritms_and_data_structures.labs.lab5sorting;

import ru.univeralex.algoritms_and_data_structures.labs.lab5sorting.api.Sorter;
import ru.univeralex.algoritms_and_data_structures.labs.utils.Calculator;

import java.util.Arrays;

public class ShellSorter implements Sorter {
    private Sorter sorter = new SelectionSorter();

    @Override
    public int[] getSorted(int[] array) {
        int[] resultingArray = new int[array.length];
        for (int i = getNumberOfSteps(array) - 1; i > 0; i--) {
            int step = (int) (Math.pow(2, i) - 1);
            resultingArray = getSortedNthStep(step, array);
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
