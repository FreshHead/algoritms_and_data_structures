package ru.univeralex.lab1stacks;

import ru.univeralex.lab1stacks.exceptions.StackIsFullException;

import java.util.EmptyStackException;

public class StaticStack<E> {
    private int pointer;
    private int size;
    private Object[] elements;

    public StaticStack(int size) {
        this.pointer = -1;
        this.size = size;
        this.elements = new Object[size];
    }

    public void push(E item) throws StackIsFullException {
        if(this.isFull()) {
            throw new StackIsFullException("Can't push item: " + item.toString() + " because stack is full.");
        }
        this.elements[++this.pointer] = item;
    }

    public E pop() throws EmptyStackException {
        E item = peek();
        this.pointer--;
        return item;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) this.elements[this.pointer];
    }

    public boolean isEmpty() {
        return this.pointer == -1;
    }

    public boolean isFull() {
        return this.pointer + 1 == this.size;
    }

    public String getElementsString() {
        StringBuilder result = new StringBuilder((elements[pointer].toString()));
        for (int i = pointer - 1; i >= 0; i--) {
            result.append(", ").append(elements[i]);
        }
        return result.toString();
    }

    public int getSize() {
        return this.size;
    }

    public int getIndexOfCurrent() {
        return this.pointer;
    }
}
