package ru.univeralex.algoritms_and_data_structures.labs.lab5sorting;

import java.util.*;

/**
 * Сортировка слиянием.
 * Сначала разбиваем данные на 1 элементные списки, затем сливаем их.
 * Одноэлементные списки сливаем в отсортированные пары.
 * Эти пары сливаем снова по парам и так до тех пор, пока не останется один общий отсортированный список.
 */
public class MergeSorter3 {
    public static void main(String[] args) {
        List<Integer> places = new ArrayList<>(Arrays.asList(6, 3, 4, 1, 10, 3));
        List<List<Integer>> listOfSingleIntegerLists = splitUp(places);
        List<Integer> result = merge(listOfSingleIntegerLists).get(0);
    }

    private static List<List<Integer>> splitUp(List<Integer> list) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        list.forEach(element -> listOfLists.add(new ArrayList<>(Collections.singletonList(element))));
        return listOfLists;
    }

    private static List<List<Integer>> merge(List<List<Integer>> listOfLists) {
        if (listOfLists.size() == 1) {
            return listOfLists;
        }
        Iterator<List<Integer>> listIterator = listOfLists.iterator();
        List<List<Integer>> resultList = new ArrayList<>();
        while (listIterator.hasNext()) {
            List<Integer> first = listIterator.next();
            if (listIterator.hasNext()) {
                List<Integer> second = listIterator.next();
                resultList.add(merge(first, second));
            } else {
                resultList.add(first);
            }
        }
        return merge(resultList);
    }

    private static List<Integer> merge(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> result = new ArrayList<>();
        while (firstList.size() > 0 && secondList.size() > 0) {
            if (firstList.get(0) < secondList.get(0)) {
                result.add(firstList.remove(0));
            } else {
                result.add(secondList.remove(0));
            }
        }
        if (firstList.isEmpty()) {
            result.addAll(secondList);
        } else {
            result.addAll(firstList);
        }
        return result;
    }

}