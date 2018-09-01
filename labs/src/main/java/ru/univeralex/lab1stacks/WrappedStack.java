package ru.univeralex.lab1stacks;

import ru.univeralex.lab1stacks.api.IStack;

import java.util.Stack;

/**
 * Обёртка над java.util.Stack с имплементирующая IStack, чтобы подходить под готовые тесты.
 * Сделана из интереса и для проверки понимая работы стека.
 */
public class WrappedStack implements IStack {
    private Stack<Integer> stack;

    WrappedStack() {
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
