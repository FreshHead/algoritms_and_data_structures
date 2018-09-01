package ru.univeralex.lab1stacks;

import ru.univeralex.lab1stacks.api.IQueue;
import ru.univeralex.lab1stacks.api.IStack;
import ru.univeralex.lab1stacks.exceptions.QueueIsEmptyException;
import ru.univeralex.lab1stacks.exceptions.QueueIsFullException;
import ru.univeralex.lab1stacks.exceptions.StackIsEmptyException;
import ru.univeralex.lab1stacks.exceptions.StackIsFullException;
import ru.univeralex.lab1stacks.wrapper.WrappedStaticStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, StackIsFullException {

        while (true) {
            System.out.println("Press number to create a stack:\n1 - static stack;\n2 - dynamic stack;" +
                    "\n3 - static queue\n4 - dynamic queue\n0 - quit.");
            switch (bufferedReader.readLine()) {
                case "1":
                    System.out.println("Enter size of stack:");
                    workWithStack(new WrappedStaticStack(Integer.parseInt(bufferedReader.readLine())));
                    break;
                case "2":
                    workWithStack(new DynamicStack());
                    break;
                case "3":
                    System.out.println("Enter size of queue:");
                    workWithQueue(new StaticQueue(Integer.parseInt(bufferedReader.readLine())));
                    break;
                case "4":
                    workWithQueue(new DynamicQueue());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid Format! Please try again.");
            }
        }
    }

    private static void workWithStack(IStack stack) throws IOException, StackIsFullException {
        while (true) {
            System.out.println("Press number for:\n1 - push element;\n2 - pop element;\n3 - print stack;\n" +
                    "4 - check if empty;\n5 - check if full;\n6 - push random numbers;\n0 - cancel this stack.");
            switch (bufferedReader.readLine()) {
                case "1":
                    System.out.println("Enter value for pushing element:");
                    try {
                        stack.push(Integer.parseInt(bufferedReader.readLine()));
                    } catch (StackIsFullException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try {
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
                    break;
                case "6":
                    System.out.println("Enter a number of elements");
                    pushRandomElements(Integer.parseInt(bufferedReader.readLine()), stack);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid Format! Please try again.");
            }
        }
    }

    private static void pushRandomElements(int amountToPush, IStack stack) throws StackIsFullException {
        if (stack instanceof StaticStack) {
            int currentIndex = ((StaticStack) stack).getIndexOfCurrent();
            int size = ((StaticStack) stack).getSize();
            int neededSize = currentIndex + amountToPush;
            if (neededSize > size - 1) {
                System.out.println("Operation aborted! Not enough space on stack. Need additional "
                        + (neededSize - size - 1) + " of space.");
                return;
            }
        }
        Random random = new Random();
        for (int i = 0; i < amountToPush; i++) {
            stack.push(random.nextInt(100));
        }
    }

    private static void workWithQueue(IQueue queue) throws IOException {
        while (true) {
            System.out.println("Press number for:\n1 - add element;\n2 - offer element;\n3 - print queue;\n" +
                    "4 - check if empty;\n5 - check if full;\n0 - cancel this queue.");
            switch (bufferedReader.readLine()) {
                case "1":
                    System.out.println("Enter value for pushing element:");
                    try {
                        queue.add(Integer.parseInt(bufferedReader.readLine()));
                    } catch (QueueIsFullException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        System.out.println("Offered element is: " + queue.offer());
                    } catch (QueueIsEmptyException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    System.out.println("Queue of elements is: " + queue.getElementsString() + ".");
                    break;
                case "4":
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;
                case "5":
                    try {
                        if (queue.isFull()) {
                            System.out.println("Queue is full.");
                        } else {
                            System.out.println("Queue is not full.");
                        }
                    } catch (UnsupportedOperationException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid Format! Please try again.");
            }
        }
    }


}
