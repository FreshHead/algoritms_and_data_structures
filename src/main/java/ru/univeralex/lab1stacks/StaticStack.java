package ru.univeralex.lab1stacks;

import ru.univeralex.lab1stacks.exceptions.StackIsEmptyException;
import ru.univeralex.lab1stacks.exceptions.StackIsFullException;

public class StaticStack implements IStack{
    private int pointer;
    private int size;
    private int[] elements;

    StaticStack(int size) {
        this.pointer = -1;
        this.size = size;
        this.elements = new int[size];
    }


    public void push(int value) throws StackIsFullException {
        if(this.isFull()) {
            throw new StackIsFullException("Can't push value: " + value + " because stack is full.");
        }
        this.elements[++this.pointer] = value;
    }

    public int pop() throws StackIsEmptyException {
        if (this.isEmpty()) {
            throw new StackIsEmptyException("Can't pop from stack because it is already empty");
        }
        return this.elements[this.pointer--];
    }

    public boolean isEmpty() {
        return this.pointer == -1;
    }

    public boolean isFull() {
        return this.pointer + 1 == this.size;
    }

    public String toString() {
        return "";
    }
}
