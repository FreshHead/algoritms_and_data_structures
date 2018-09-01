package ru.univeralex.lab1stacks.wrapper;

import ru.univeralex.lab1stacks.StaticStack;
import ru.univeralex.lab1stacks.api.IStack;
import ru.univeralex.lab1stacks.exceptions.StackIsFullException;

/**
 * Обёртка для StaticStack, чтобы он мог проходить старые тесты.
 */
public class WrappedStaticStack implements IStack {
    private StaticStack<Integer> staticStack;

    public WrappedStaticStack(int size) {
        staticStack = new StaticStack<>(size);
    }

    @Override
    public void push(int value) throws StackIsFullException {
        staticStack.push(value);
    }

    @Override
    public int pop() {
        return staticStack.pop();
    }

    @Override
    public boolean isEmpty() {
        return staticStack.isEmpty();
    }

    @Override
    public boolean isFull() {
        return staticStack.isFull();
    }

    @Override
    public String getElementsString() {
        return staticStack.getElementsString();
    }
}
