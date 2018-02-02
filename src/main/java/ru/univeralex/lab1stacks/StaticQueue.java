package ru.univeralex.lab1stacks;

import ru.univeralex.lab1stacks.api.IQueue;
import ru.univeralex.lab1stacks.exceptions.QueueIsEmptyException;
import ru.univeralex.lab1stacks.exceptions.QueueIsFullException;

public class StaticQueue implements IQueue {
    private int size;
    private int[] elements;
    private int first, last;
    private int amount;

    StaticQueue(int size) {
        this.size = size;
        first = last = amount = 0;
        elements = new int[size];

    }

    @Override
    public void add(int value) throws QueueIsFullException {
        if (isFull()) throw new QueueIsFullException("Can't add value: " + value + " because queue is full.");
        if(last == size) last = 0;
        elements[last++] = value;
        amount++;
    }

    @Override
    public int offer() throws QueueIsEmptyException {
        if (isEmpty()) throw new QueueIsEmptyException("Can't offer value because queue is empty.");
        amount--;
        if(first == size) first = 0;
        return elements[this.first++];
    }

    public boolean isEmpty() {
        return amount == 0;
    }

    public boolean isFull() {
        return last - first == size;
    }

    @Override
    public String getElementsString() {
        String result = Integer.toString(elements[first]);
        int current = first;
        for (int i = 1; i < amount; i++) {
            if(current > size) current = -1;
            result += ", " + elements[++current];
        }
        return result;
    }

}
