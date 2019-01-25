package ru.univeralex.algoritms_and_data_structures.labs.lab1stacks;


import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsFullException;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StaticStack<E> {
    private int pointer;
    private int size;
    private Object[] elements;

    public Object[] getElements() {
        return elements;
    }

    public List<E> getElementsList() {
        ArrayList<E> arrayList = new ArrayList<>();
        for (Object element : elements) {
            if (element != null) {
                arrayList.add((E) element);
            }
        }
        return arrayList;
    }

    public StaticStack(int size) {
        this.pointer = -1;
        this.size = size;
        this.elements = new Object[size];
    }

    public void push(E item) throws StackIsFullException {
        if (this.isFull()) {
            throw new StackIsFullException("Can't push item: " + item.toString() + " because stack is full.");
        }
        this.elements[++this.pointer] = item;
    }

    public E pop() throws EmptyStackException {
        E item = peek();
        elements[pointer] = null;
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
        if (this.pointer == -1) {
            return "";
        }
        StringBuilder result = new StringBuilder((this.elements[this.pointer].toString()));
        for (int i = this.pointer - 1; i >= 0; i--) {
            result.append(", ").append(this.elements[i]);
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
