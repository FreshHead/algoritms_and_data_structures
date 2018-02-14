package ru.univeralex.lab2lists;

import ru.univeralex.lab2lists.api.IList;
import ru.univeralex.lab2lists.exceptions.ListIsFullException;
import ru.univeralex.lab2lists.exceptions.NoSuchItemException;

public class StaticList implements IList {
    private int[] items;
    private int length;
    private int maximumSize;

    StaticList(int maximumSize) {
        this.maximumSize = maximumSize;
        items = new int[maximumSize];
    }

    @Override
    public void insertBefore(int index, int value) throws ListIsFullException {
        if (isFull()) throw new ListIsFullException("Can't insert value: " + value + " because list is full.");
        shiftToTheRight(index);
        items[index] = value;
        length++;
    }

    @Override
    public void insertAfter(int index, int value) throws ListIsFullException, NoSuchItemException {
        if (isFull()) throw new ListIsFullException("Can't insert value: " + value + " because list is full.");
        if (isEmpty()) {
            items[0] = value;
            length++;
            return;
        }
        if (length <= index)
            throw new NoSuchItemException("No item with index: " + index );
        if(length != index + 1)
            shiftToTheRight(index);
        items[index + 1] = value;
        length++;
    }

    private void shiftToTheRight(int fromIndex) {
        for (int i = length; i > fromIndex; i--) {
            items[i + 1] = items[i];
        }
    }

    @Override
    public void delete(int index) {

    }

//    private void shiftToTheLeft(int fromIndex) {
//        for (int i = length; i > fromIndex; i--) {
//            items[i + 1] = items[i];
//        }
//    }

    @Override
    public int findFirst(int value) {
        return 0;
    }

    @Override
    public String getListItemValues() {
        StringBuilder result = new StringBuilder(Integer.toString(items[0]));
        for (int i = 1; i < length; i++) {
            result.append(", ").append(items[i]);
        }
        return result.toString();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
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
