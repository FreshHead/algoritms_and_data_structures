package ru.univeralex.lab1stacks;

import ru.univeralex.lab1stacks.exceptions.StackIsEmptyException;
import ru.univeralex.lab1stacks.exceptions.StackIsFullException;

public interface IStack {
    void push(int value) throws StackIsFullException;

    int pop() throws StackIsEmptyException;

    boolean isEmpty();

    boolean isFull();

}
