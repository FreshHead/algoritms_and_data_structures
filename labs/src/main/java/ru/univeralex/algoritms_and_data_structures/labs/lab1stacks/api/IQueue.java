package ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.api;


import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.QueueIsEmptyException;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.QueueIsFullException;

public interface IQueue {
    void add(int value) throws QueueIsFullException;

    int offer() throws QueueIsEmptyException;

    boolean isEmpty();

    boolean isFull();

    String getElementsString();

}
