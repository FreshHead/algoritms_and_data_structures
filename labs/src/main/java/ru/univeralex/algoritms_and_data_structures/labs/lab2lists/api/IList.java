package ru.univeralex.algoritms_and_data_structures.labs.lab2lists.api;


import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.NoSuchItemException;

public interface IList {

    void insertBefore(int index, int value) throws IndexOutOfBoundsException, NoSuchItemException;

    /*
     * Don't use in empty list.
     */
    void insertAfter(int index, int value) throws NoSuchItemException, IndexOutOfBoundsException;

    void delete(int index);

    int findFirst(int value) throws NoSuchItemException;

    String getElementsString();

    boolean isEmpty();

    boolean isFull();

    boolean isExist(int element);
}
