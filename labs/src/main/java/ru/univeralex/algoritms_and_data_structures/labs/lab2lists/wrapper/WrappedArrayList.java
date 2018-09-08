package ru.univeralex.algoritms_and_data_structures.labs.lab2lists.wrapper;

import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.api.IList;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.NoSuchItemException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Обёртка над java.util.ArrayList имплементирующая IList, чтобы подходить под готовые тесты.
 * Сделана из интереса и для проверки пониманияя работы списка.
 */
public class WrappedArrayList implements IList {
    private ArrayList<Integer> list;

    public WrappedArrayList() {
        this.list = new ArrayList<>();
    }

    @Override
    public void insertBefore(int index, int value) throws IndexOutOfBoundsException {
        list.add(index, value);
    }

    @Override
    public void insertAfter(int index, int value) throws IndexOutOfBoundsException {
        list.add(index + 1, value);
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        this.list.remove(index);
    }

    @Override
    public int findFirst(int value) throws NoSuchItemException {
        if (list.indexOf(value) == -1) {
            throw new NoSuchItemException("Can't find item with value:" + value);
        }
        return list.indexOf(value);
    }

    @Override
    public String getElementsString() {
        Iterator<Integer> iterator = list.iterator();
        StringBuilder stringBuilder = new StringBuilder().append(iterator.next());

        while (iterator.hasNext()) {
            stringBuilder.append(", ").append(iterator.next());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isExist(int element) {
        return list.contains(element);
    }

}
