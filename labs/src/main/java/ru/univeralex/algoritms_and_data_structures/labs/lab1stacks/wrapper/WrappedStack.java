package ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.wrapper;

import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.api.IStack;

import java.util.Stack;

/**
 * Обёртка над java.util.Stack имплементирующая IStack, чтобы подходить под готовые тесты.
 * Сделана из интереса и для проверки пониманияя работы стека.
 */
public class WrappedStack implements IStack {
    private Stack<Integer> stack;

    public WrappedStack() {
        this.stack = new Stack<Integer>();
    }


    @Override
    public void push(int value) {
        stack.push(value);
    }

    @Override
    public int pop() {
        return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.empty();
    }

    public boolean isFull() {
        return false;
    }

    @Override
    public String getElementsString() {
        StringBuilder result = new StringBuilder(stack.pop().toString());
        while (!stack.empty()) {
            result.append(", ").append(stack.pop());
        }
        return result.toString();
    }
}
