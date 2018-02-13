package ru.univeralex.lab2lists.api;

import ru.univeralex.lab2lists.exceptions.ListIsFullException;
import ru.univeralex.lab2lists.exceptions.NoItemException;

public interface IList {

    void insertBefore(int index, int value) throws ListIsFullException, NoItemException;

    void insertAfter(int index, int value) throws NoItemException;

    void delete(int index);

    int findFirst(int value);

    String getListItemValues();

    boolean isEmpty();

    boolean isFull();

    boolean isExist(int element);
}
