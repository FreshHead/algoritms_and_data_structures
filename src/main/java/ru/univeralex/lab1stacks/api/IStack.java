package ru.univeralex.lab1stacks.api;

import ru.univeralex.lab1stacks.exceptions.StackIsEmptyException;

public interface IStack {
    void push(int value);

    int pop() throws StackIsEmptyException;

    boolean isEmpty();

    boolean isFull();

    String getElementsString();

}
