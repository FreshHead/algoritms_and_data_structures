package ru.univeralex.lab1stacks;

import ru.univeralex.lab1stacks.api.IStack;

import java.util.EmptyStackException;

public class DynamicStack implements IStack {

    class StackElement {
        int value;
        StackElement previousStackElement;

        StackElement(int value, StackElement previousStackElement) {
            this.value = value;
            this.previousStackElement = previousStackElement;
        }

        private int getValue() {
            return value;
        }

        private StackElement getPreviousStackElement() {
            return previousStackElement;
        }

    }

    private StackElement pointer;

    @Override
    public void push(int value) {
        pointer = new StackElement(value, pointer);
    }

    @Override
    public int pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        int value = pointer.getValue();
        pointer = pointer.getPreviousStackElement();
        return value;
    }

    @Override
    public boolean isEmpty() {
        return pointer == null;
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Can't check is full or not for dynamic stack!");
    }

    @Override
    public String getElementsString() {
        StackElement current = pointer;
        StringBuilder result = new StringBuilder(Integer.toString(current.getValue()));
        current = current.previousStackElement;
        while (current != null) {
            result.append(", ").append(current.getValue());
            current = current.previousStackElement;
        }
        return result.toString();
    }

}
