package ru.univeralex.algoritms_and_data_structures.labs.lab2lists.api;


import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.ListIsFullException;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.NoSuchItemException;

public interface IList {

    void insertBefore(int index, int value) throws ListIsFullException, NoSuchItemException;

    void insertAfter(int index, int value) throws NoSuchItemException, ListIsFullException;

    void delete(int index) throws NoSuchItemException;

    int findFirst(int value) throws NoSuchItemException;

    String getItemValues();

    boolean isEmpty();

    boolean isFull();

    boolean isExist(int element);
}
