package ru.univeralex.algoritms_and_data_structures.labs.lab2lists;

import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.api.IList;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.NoSuchItemException;

public class StaticList implements IList {
    private int[] items;
    private int length;
    private int maximumSize;

    StaticList(int maximumSize) {
        this.maximumSize = maximumSize;
        items = new int[maximumSize];
    }

    @Override
    public void insertBefore(int index, int value) throws IndexOutOfBoundsException {
        if (isFull()) throw new IndexOutOfBoundsException("Can't insert value: " + value + " because list is full.");
        shiftToTheRight(index);
        items[index] = value;
        length++;
    }

    @Override
    public void insertAfter(int index, int value) throws IndexOutOfBoundsException {
        if (isFull()) throw new IndexOutOfBoundsException("Can't insert value: " + value + " because list is full.");
        if (isEmpty()) {
            items[0] = value;
            length++;
            return;
        }
        if (length <= index)
            throw new IndexOutOfBoundsException("No item with index: " + index);
        if (length != index + 1)
            shiftToTheRight(index);
        items[index + 1] = value;
        length++;
    }

    private void shiftToTheRight(int fromIndex) {
        System.arraycopy(items, fromIndex, items, fromIndex + 1, length - fromIndex);
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index + 1 > length)
            throw new IndexOutOfBoundsException("Can't delete item with index: " + index + " ! Because this index does not exist.");
        shiftToTheLeft(index);
        length--;
    }

    private void shiftToTheLeft(int toIndex) {
        System.arraycopy(items, toIndex + 1, items, toIndex, length - toIndex);
    }

    @Override
    public int findFirst(int value) throws NoSuchItemException {
        for (int i = 0; i < length; i++) {
            if (items[i] == value)
                return i;
        }
        throw new NoSuchItemException("Can't find item with value:" + value);
    }

    @Override
    public String getElementsString() {
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
