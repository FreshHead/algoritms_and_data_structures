package ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.api;


import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsEmptyException;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsFullException;

public interface IStack {
    void push(int value) throws StackIsFullException;

    int pop() throws StackIsEmptyException;

    boolean isEmpty();

    boolean isFull();

    String getElementsString();

}
