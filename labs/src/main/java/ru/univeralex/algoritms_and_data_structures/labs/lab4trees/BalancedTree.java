package ru.univeralex.algoritms_and_data_structures.labs.lab4trees;


import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.DynamicStack;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.api.IStack;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsEmptyException;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsFullException;
import ru.univeralex.algoritms_and_data_structures.labs.lab5sorting.QuickSorter;
import ru.univeralex.algoritms_and_data_structures.labs.utils.ArrayUtils;

class BalancedTree {
    BalancedTree(int vertices) {
        this(ArrayUtils.generate(100, vertices));
    }

    private BalancedTree(int[] array) {
        int[] sortedArray = new QuickSorter().getSorted(array);

        IStack stack = new DynamicStack();
        for (int i = sortedArray.length - 1; i >= 0; i--) {
            try {
                stack.push(sortedArray[i]);
            } catch (StackIsFullException e) {
                e.printStackTrace();
            }
        }
        Node rootNode = addNodes(array.length, stack);
        System.out.println("Прямой обход:");
        directTraversal(rootNode, 0);
        System.out.println("Симметричный обход:");
        symmetricTraversal(rootNode, 0);
        System.out.println("Обратный обход:");
        reverseTraversal(rootNode, 0);
    }

    private void directTraversal(Node node, int level) {
        System.out.println(getTabs(level) + node.value);
        if (node.leftChild != null)
            directTraversal(node.leftChild, level + 1);
        if (node.rightChild != null)
            directTraversal(node.rightChild, level + 1);
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

    private void symmetricTraversal(Node node, int level) {
        if (node.leftChild != null)
            symmetricTraversal(node.leftChild, level + 1);
        System.out.println(getTabs(level) + node.value);
        if (node.rightChild != null)
            symmetricTraversal(node.rightChild, level + 1);
    }

    private void reverseTraversal(Node node, int level) {
        if (node.leftChild != null)
            reverseTraversal(node.leftChild, level + 1);
        if (node.rightChild != null)
            reverseTraversal(node.rightChild, level);
        System.out.println(getTabs(level) + node.value);
    }

    private String getTabs(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) result.append("\t");
        return result.toString();
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
