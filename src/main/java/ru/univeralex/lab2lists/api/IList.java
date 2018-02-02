package ru.univeralex.lab2lists.api;

import ru.univeralex.lab2lists.exceptions.ListIsFullException;

public interface IList {

    void insertBefore(int index, int value) throws ListIsFullException;

    void insertAfter(int index, int value);

    int findFirst(int value);

    String getElementsValueString();

    boolean isEmpty();

    boolean isFull();

    boolean isExist(int element);
}
