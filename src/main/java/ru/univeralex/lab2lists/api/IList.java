package ru.univeralex.lab2lists.api;

import ru.univeralex.lab2lists.exceptions.ListIsFullException;
import ru.univeralex.lab2lists.exceptions.NoSuchItemException;

public interface IList {

    void insertBefore(int index, int value) throws ListIsFullException, NoSuchItemException;

    void insertAfter(int index, int value) throws NoSuchItemException;

    void delete(int index) throws NoSuchItemException;

    int findFirst(int value) throws NoSuchItemException;

    String getListItemValues();

    boolean isEmpty();

    boolean isFull();

    boolean isExist(int element);
}
