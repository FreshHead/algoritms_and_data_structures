package ru.univeralex.algoritms_and_data_structures.labs.lab1stacks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.QueueIsFullException;

public class StaticQueueTest extends AbstractQueueTest{
    @Before
    public void setUp() {
        this.emptyQueue = new StaticQueue(10);
    }

    @Test
    public void isFullTest() throws QueueIsFullException {
        Assert.assertFalse(emptyQueue.isFull());
        for (int i = 0; i < 10; i++) {
            emptyQueue.add(i);
        }
        Assert.assertTrue(emptyQueue.isFull());
    }
}
