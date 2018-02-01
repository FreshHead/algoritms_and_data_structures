package ru.univeralex.lab1stacks;

import org.junit.Before;
import org.junit.Test;

public class DynamicStackTest extends AbstractStackTest{

    @Before
    public void setUp() {
        this.emptyStack = new DynamicStack();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void isFullTest() {
        this.emptyStack.isFull();
    }
}
