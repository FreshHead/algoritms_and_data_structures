package ru.univeralex.algoritms_and_data_structures.labs.lab2lists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.ListIsFullException;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.NoSuchItemException;

public class StaticListTest extends AbstractListTest{
    @Before
    public void setUp() {
        list = new StaticList(10);
    }

    @Test
    public void isFull() throws NoSuchItemException, ListIsFullException {
        Assert.assertFalse(list.isFull());
        for (int i = 0; i < 10; i++) {
            Assert.assertFalse(list.isFull());
            list.insertAfter(i - 1, i);
        }
        Assert.assertTrue(list.isFull());
    }
}
