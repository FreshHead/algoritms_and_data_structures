package ru.univeralex.algoritms_and_data_structures.labs.lab1stacks;

import org.junit.Ignore;
import org.junit.Test;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.api.IStack;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsEmptyException;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsFullException;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

@Ignore
public class AbstractStackTest {

    IStack emptyStack;

    @Test
    public void IsEmptyTest(){
        assertTrue(this.emptyStack.isEmpty());
    }

    @Test
    public void pushTest() throws StackIsFullException {
        this.emptyStack.push(1);
        assertFalse(this.emptyStack.isEmpty());
    }

    @Test
    public void popTest() throws StackIsFullException, StackIsEmptyException {
        this.emptyStack.push(1);
        assertEquals(1, this.emptyStack.pop());
        assertTrue(this.emptyStack.isEmpty());
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
        assertEquals("9 8 7 6 5 4 3 2 1 0 ", elementsString);
    }

    @Test(expected = EmptyStackException.class)
    public void TestStackIsEmptyException() throws StackIsEmptyException {
        this.emptyStack.pop();
    }

    @Test
    public void toStringTest() throws StackIsFullException {
        for(int i = 0 ; i < 10; i++){
            this.emptyStack.push(i);
        }
        assertEquals("9, 8, 7, 6, 5, 4, 3, 2, 1, 0", this.emptyStack.getElementsString());
    }

}
