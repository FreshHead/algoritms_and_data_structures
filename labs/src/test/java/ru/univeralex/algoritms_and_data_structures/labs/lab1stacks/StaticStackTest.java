package ru.univeralex.algoritms_and_data_structures.labs.lab1stacks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsFullException;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.wrapper.WrappedStaticStack;


public class StaticStackTest extends AbstractStackTest{

    @Before
    public void setUp() {
        this.emptyStack = new WrappedStaticStack(10);
    }

    @Test
    public void isFullTest() throws StackIsFullException {
        for(int i = 0 ; i < 9; i++){
            Assert.assertFalse(this.emptyStack.isFull());
            this.emptyStack.push(i);
        }
        this.emptyStack.push(10);
        Assert.assertTrue(this.emptyStack.isFull());
    }

    @Test(expected = StackIsFullException.class)
    public void TestStackIsFullException() throws StackIsFullException {
        for(int i = 0 ; i < 11; i++){
           this.emptyStack.push(i);
        }
    }
}
