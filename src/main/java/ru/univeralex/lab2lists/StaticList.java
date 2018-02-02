package ru.univeralex.lab2lists;

import ru.univeralex.lab2lists.api.IList;
import ru.univeralex.lab2lists.exceptions.ListIsFullException;

public class StaticList implements IList{
    private int[] elements;
    private int length;
    private int maximumSize;

    StaticList(int maximumSize) {
        this.maximumSize = maximumSize;
        elements = new int[maximumSize];
    }

    @Override
    public void insertBefore(int index, int value) throws ListIsFullException {
        if(isFull()) throw new ListIsFullException("Can't insert value: " + value + " because list is full.");
        shiftToTheRight(index);
        elements[index] = value;
        length++;
    }

    private void shiftToTheRight(int fromIndex) {
        for (int i = fromIndex; i < length; i++) {
            elements[i + 1] = elements[i];
        }
    }

    @Override
    public void insertAfter(int index, int value) {

    }

    @Override
    public int findFirst(int value) {
        for(int i = 0; i < length; i++) {

        }
        return 0;
    }

    @Override
    public String getElementsValueString() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return length == maximumSize;
    }

    @Override
    public boolean isExist(int value) {
        return false;
    }

}
