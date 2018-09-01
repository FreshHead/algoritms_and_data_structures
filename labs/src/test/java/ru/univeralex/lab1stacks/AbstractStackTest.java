package ru.univeralex.lab1stacks;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.univeralex.lab1stacks.api.IStack;
import ru.univeralex.lab1stacks.exceptions.StackIsEmptyException;
import ru.univeralex.lab1stacks.exceptions.StackIsFullException;

@Ignore
public class AbstractStackTest {

    protected IStack emptyStack;

    @Test
    public void IsEmptyTest(){
        Assert.assertEquals(this.emptyStack.isEmpty(), true);
    }

    @Test
    public void pushTest() throws StackIsFullException {
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
    public void pushPopTest() throws StackIsEmptyException, StackIsFullException {
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

    @Test
    public void toStringTest() throws StackIsFullException {
        for(int i = 0 ; i < 10; i++){
            this.emptyStack.push(i);
        }
        Assert.assertEquals("9, 8, 7, 6, 5, 4, 3, 2, 1, 0", this.emptyStack.getElementsString());
    }

}
