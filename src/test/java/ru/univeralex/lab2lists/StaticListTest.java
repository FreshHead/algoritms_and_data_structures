package ru.univeralex.lab2lists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.univeralex.lab2lists.exceptions.ListIsFullException;
import ru.univeralex.lab2lists.exceptions.NoSuchItemException;

public class StaticListTest extends AbstractListTest{
    @Before
    public void setUp() {
        list = new StaticList(10);
    }

    @Test
    public void isFull() throws NoSuchItemException, ListIsFullException {
        Assert.assertEquals(false, list.isFull());
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(false, list.isFull());
            list.insertAfter(i - 1, i);
        }
        Assert.assertEquals(true, list.isFull());
    }
}
