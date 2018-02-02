package ru.univeralex.lab1stacks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.univeralex.lab1stacks.exceptions.QueueIsFullException;

public class StaticQueueTest extends AbstractQueueTest{
    @Before
    public void setUp() {
        this.emptyQueue = new StaticQueue(10);
    }

    @Test
    public void isFullTest() throws QueueIsFullException {
        Assert.assertEquals(false,emptyQueue.isFull());
        for (int i = 0; i < 10; i++) {
            emptyQueue.add(i);
        }
        Assert.assertEquals(true,emptyQueue.isFull());
    }
}
