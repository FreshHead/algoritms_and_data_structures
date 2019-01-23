package ru.univeralex.algoritms_and_data_structures.labs.lab5sorting;

import ru.univeralex.algoritms_and_data_structures.labs.lab5sorting.api.Sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сортировка слиянием. Проба реализации псевдокода с wiki
 */
public class MergeSorter implements Sorter {
    private static int[] merge(int[] left, int[] right) {
        List<Integer> leftList = Arrays.stream(left).boxed().collect(Collectors.toList());
        List<Integer> rightList = Arrays.stream(right).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<Integer>();
        while (leftList.size() > 0 && rightList.size() > 0) {
            if (leftList.get(0) <= rightList.get(0)) {
                result.add(leftList.get(0));
                leftList.remove(0);
            } else {
                result.add(rightList.get(0));
                rightList.remove(0);
            }
        }
        result.addAll(leftList);
        result.addAll(rightList);
        return result.stream().mapToInt(i -> i).toArray();
    }

    @Override
    public int[] getSorted(int[] array) {
        if (array.length <= 1) {
            return array;
        } else {
            int middle = array.length / 2;
            middle = array.length % 2 == 0 ? middle : middle + 1;
            int[] left = new int[middle];

            System.arraycopy(array, 0, left, 0, left.length);
            int size = array.length - middle;
            int[] right = new int[size];
            for (int j = 0, i = size + 1; j < size; j++, i++) {
                right[j] = array[i];
            }
            left = getSorted(left);
            right = getSorted(right);
            return merge(left, right);
        }
    }

}
