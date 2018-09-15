package ru.univeralex.algoritms_and_data_structures.labs.lab2lists.wrapper;

import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.DynamicList;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.api.IList;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.NoSuchItemException;

public class WrappedDynamicList implements IList {
    private final DynamicList<Integer> list;

    public WrappedDynamicList() {
        list = new DynamicList<>();
    }

    @Override
    public void insertBefore(int index, int value) throws IndexOutOfBoundsException {
        list.insertBefore(index, value);
    }

    @Override
    public void insertAfter(int index, int value) throws IndexOutOfBoundsException {
        list.insertAfter(index, value);
    }

    @Override
    public void delete(int index) {
        list.delete(index);
    }

    @Override
    public int findFirst(int value) throws NoSuchItemException {
        return list.findFirst(value);
    }

    @Override
    public String getElementsString() {
        return list.getElementsString();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return list.isFull();
    }

    @Override
    public boolean isExist(int element) {
        return list.isExist(element);
    }
}
