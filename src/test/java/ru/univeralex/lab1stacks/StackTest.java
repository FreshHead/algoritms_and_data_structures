package ru.univeralex.lab1stacks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.univeralex.lab1stacks.exceptions.StackIsEmptyException;
import ru.univeralex.lab1stacks.exceptions.StackIsFullException;

public class StackTest {
    IStack emptyStack;

    @Before
    public void setUp() {
        this.emptyStack = new StaticStack(10);
    }

    @Test
    public void IsEmptyTest(){
        Assert.assertEquals(this.emptyStack.isEmpty(), true);
    }

    @Test
    public void pushTest() throws StackIsFullException, StackIsEmptyException {
        this.emptyStack.push(1);
        Assert.assertEquals( false, this.emptyStack.isEmpty());
    }

    @Test
    public void popTest() throws StackIsFullException, StackIsEmptyException {
        this.emptyStack.push(1);
        Assert.assertEquals(1, this.emptyStack.pop());
        Assert.assertEquals(true, this.emptyStack.isEmpty() );
    }

    @Test
    public void isFullTest() throws StackIsFullException {
        for(int i = 0 ; i < 9; i++){
            Assert.assertEquals(false, this.emptyStack.isFull());
            this.emptyStack.push(i);
        }
        this.emptyStack.push(10);
        Assert.assertEquals(true, this.emptyStack.isFull());
    }

    @Test
    public void fullTest() throws StackIsFullException, StackIsEmptyException {
        for(int i = 0 ; i < 10; i++){
            this.emptyStack.push(i);
        }
        String elementsString = "";
        for(int i = 0 ; i < 10; i++){
            elementsString += this.emptyStack.pop() + " ";
        }
        Assert.assertEquals("9 8 7 6 5 4 3 2 1 0 ", elementsString);
    }

    @Test(expected = StackIsEmptyException.class)
    public void TestStackIsEmptyException() throws StackIsEmptyException {
        this.emptyStack.pop();
    }

    @Test(expected = StackIsFullException.class)
    public void TestStackIsFullException() throws StackIsFullException {
        for(int i = 0 ; i < 11; i++){
           this.emptyStack.push(i);
        }
    }
}
