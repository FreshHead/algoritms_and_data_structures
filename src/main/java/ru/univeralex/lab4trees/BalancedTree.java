package ru.univeralex.lab4trees;

import ru.univeralex.lab1stacks.DynamicStack;
import ru.univeralex.lab1stacks.api.IStack;
import ru.univeralex.lab1stacks.exceptions.StackIsEmptyException;
import ru.univeralex.lab1stacks.exceptions.StackIsFullException;
import ru.univeralex.lab5sorting_algorithms.QuickSorter;
import ru.univeralex.utils.ArrayUtils;

public class BalancedTree {
    protected BalancedTree(int[] array) {
        int[] sortedArray = new QuickSorter().getSorted(array);

        IStack stack = new DynamicStack();
        for (int i = sortedArray.length - 1; i >= 0; i--) {
            try {
                stack.push(sortedArray[i]);
            } catch (StackIsFullException e) {
                e.printStackTrace();
            }
        }
        rootNode = addNodes(array.length, stack);
        directTraversal(rootNode, 0);
    }

    private Node rootNode;

    public BalancedTree(int vertices) {
        this(ArrayUtils.generate(100, vertices));
    }

    private void directTraversal(Node node, int level) {
        System.out.println(getTabs(level) + node.value);
        if (node.leftChild != null) directTraversal(node.leftChild, level + 1);
        if (node.rightChild != null) directTraversal(node.rightChild, level + 1);
    }

    private Node addNodes(int nodesCount, IStack valuesStack) {
        Node currentNode = null;
        if (nodesCount != 0) {
            int leftNodesCount = nodesCount / 2;
            int rightNodesCount = nodesCount - leftNodesCount - 1;

            try {
                currentNode = new Node(valuesStack.pop());
            } catch (StackIsEmptyException e) {
                e.printStackTrace();
            }
            if (currentNode != null) {
                currentNode.leftChild = addNodes(leftNodesCount, valuesStack);
                currentNode.rightChild = addNodes(rightNodesCount, valuesStack);
            }
        }
        return currentNode;
    }

    private String getTabs(int count) {
        String result = "";
        for (int i = 0; i < count; i++) result += "\t";
        return result;
    }

    class Node {
        int value;
        Node leftChild;
        Node rightChild;

        private Node(int value) {
            this.value = value;
        }
    }


}
