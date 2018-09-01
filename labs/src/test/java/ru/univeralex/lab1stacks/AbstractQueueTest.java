package ru.univeralex.lab1stacks;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.univeralex.lab1stacks.api.IQueue;
import ru.univeralex.lab1stacks.exceptions.QueueIsEmptyException;
import ru.univeralex.lab1stacks.exceptions.QueueIsFullException;

@Ignore
public class AbstractQueueTest {
    IQueue emptyQueue;

    @Test
    public void isEmptyTest() throws QueueIsFullException {
        Assert.assertEquals(true, emptyQueue.isEmpty());
        emptyQueue.add(10);
        Assert.assertEquals(false, emptyQueue.isEmpty());
    }

    @Test
    public void getElementsStringTest() throws QueueIsFullException {
        for (int i = 0; i < 10; i++) {
            emptyQueue.add(i);
        }
        Assert.assertEquals("0, 1, 2, 3, 4, 5, 6, 7, 8, 9", emptyQueue.getElementsString());

    }

    @Test
    public void offerTest() throws QueueIsFullException, QueueIsEmptyException {
        for (int j = 0; j < 10; j ++) {
            for (int i = 0; i < 10; i++) {
                emptyQueue.add(i);
            }
            for (int i = 0; i < 10; i++) {
                Assert.assertEquals(i, emptyQueue.offer());
            }
        }
        Assert.assertEquals(true, emptyQueue.isEmpty());
        emptyQueue.add(100);
        emptyQueue.add(1000);
        Assert.assertEquals(100, emptyQueue.offer());
        Assert.assertEquals(1000, emptyQueue.offer());
    }

}
