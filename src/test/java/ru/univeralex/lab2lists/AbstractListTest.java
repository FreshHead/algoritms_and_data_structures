package ru.univeralex.lab2lists;

import org.junit.Assert;
import org.junit.Test;
import ru.univeralex.lab2lists.api.IList;
import ru.univeralex.lab2lists.exceptions.ListIsFullException;
import ru.univeralex.lab2lists.exceptions.NoItemException;

public class AbstractListTest {
    IList list;

    @Test
    public void insertAfterTest() throws NoItemException {
        list.insertAfter(1, 10);
        Assert.assertEquals("10", list.getListItemValues());
        list.insertAfter(0, 12);
        Assert.assertEquals("10, 12", list.getListItemValues());
        list.insertAfter(1, 14);
        Assert.assertEquals("10, 12, 14", list.getListItemValues());
        list.insertAfter(0, 8);
        Assert.assertEquals("10, 8, 12, 14", list.getListItemValues());
    }

    @Test(expected = NoItemException.class)
    public void insertAfterToBigIndexTest() throws NoItemException {
        list.insertAfter(0, 10);
        Assert.assertEquals("10", list.getListItemValues());
        list.insertAfter(1, 12);
        Assert.assertEquals("10, 12", list.getListItemValues());
    }

    @Test
    public void insertBeforeTest() throws NoItemException, ListIsFullException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getListItemValues());
        list.insertBefore(0, 12);
        Assert.assertEquals("12, 10", list.getListItemValues());
        list.insertBefore(1, 14);
        Assert.assertEquals("12, 14, 10", list.getListItemValues());
        list.insertBefore(2, 8);
        Assert.assertEquals("12, 14, 8, 10", list.getListItemValues());
    }
}
