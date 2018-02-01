package ru.univeralex.lab1stacks;

import ru.univeralex.lab1stacks.api.IStack;
import ru.univeralex.lab1stacks.exceptions.StackIsEmptyException;
import ru.univeralex.lab1stacks.exceptions.StackIsFullException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("Press number to create a stack:\n1 - static stack;\n2 - dynamic stack;\n0 - quit");
            IStack stack;
            switch (bufferedReader.readLine()) {
                case "1":
                    System.out.println("Enter size of stack:");
                    int size = Integer.parseInt(bufferedReader.readLine());
                    stack = new StaticStack(size);
                    workWithStack(stack);
                    break;
                case "2":
                    stack = new DynamicStack();
                    workWithStack(stack);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid Format! Please try again.");
            }
        }
    }

    private static void workWithStack(IStack stack) throws IOException {
        while (true) {
            System.out.println("Press number for:\n1 - push element\n2 - pop element\n3 - print stack\n" +
                    "4 - check if empty\n5 - check if full\n0 - cancel this stack\n6 - push random numbers");
            switch (bufferedReader.readLine()) {
                case "1":
                    System.out.println("Enter value for pushing element:");
                    try{
                        stack.push(Integer.parseInt(bufferedReader.readLine()));
                    }catch (StackIsFullException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try{
                        System.out.println("Pop element is: " + stack.pop());
                    } catch (StackIsEmptyException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    System.out.println("Stack of elements from up to down is: " + stack.getElementsString() + ".");
                    break;
                case "4":
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case "5":
                    try {
                        if (stack.isFull()) {
                            System.out.println("Stack is full.");
                        } else {
                            System.out.println("Stack is not full.");
                        }
                    } catch (UnsupportedOperationException e) {
                        System.out.println(e.getMessage());
                    }
                case "6":
                    System.out.println("Enter a number of elements");
                    int numberOfElementsToPush = Integer.parseInt(bufferedReader.readLine());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid Format! Please try again.");
            }
        }
    }

}
