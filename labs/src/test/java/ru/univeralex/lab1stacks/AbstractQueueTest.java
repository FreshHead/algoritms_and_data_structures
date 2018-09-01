package ru.univeralex.lab1stacks;

import org.junit.Ignore;
import org.junit.Test;
import ru.univeralex.lab1stacks.api.IQueue;
import ru.univeralex.lab1stacks.exceptions.QueueIsEmptyException;
import ru.univeralex.lab1stacks.exceptions.QueueIsFullException;

import static org.junit.Assert.*;

@Ignore
public class AbstractQueueTest {
    IQueue emptyQueue;

    @Test
    public void isEmptyTest() throws QueueIsFullException {
        assertTrue(emptyQueue.isEmpty());
        emptyQueue.add(10);
        assertFalse(emptyQueue.isEmpty());
    }

    @Test
    public void getElementsStringTest() throws QueueIsFullException {
        for (int i = 0; i < 10; i++) {
            emptyQueue.add(i);
        }
        assertEquals("0, 1, 2, 3, 4, 5, 6, 7, 8, 9", emptyQueue.getElementsString());

    }

    @Test
    public void offerTest() throws QueueIsFullException, QueueIsEmptyException {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                emptyQueue.add(i);
            }
            for (int i = 0; i < 10; i++) {
                assertEquals(i, emptyQueue.offer());
            }
        }
        assertTrue(emptyQueue.isEmpty());
        emptyQueue.add(100);
        emptyQueue.add(1000);
        assertEquals(100, emptyQueue.offer());
        assertEquals(1000, emptyQueue.offer());
    }

}
