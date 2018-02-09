package ru.univeralex.lab4trees;

import ru.univeralex.utils.ArrayUtils;

public class PerfectlyBalancedTree {
    public PerfectlyBalancedTree(int vertices) {
        this(ArrayUtils.generate(100, vertices));
    }

    protected PerfectlyBalancedTree(int[] array) {

    }

    class TreeElement {
        int value;
        TreeElement parent;
        TreeElement leftChild;
        TreeElement rightChild;
    }
}
