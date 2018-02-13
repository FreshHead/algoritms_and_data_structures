package ru.univeralex.lab2lists;

import org.junit.Assert;
import org.junit.Test;
import ru.univeralex.lab2lists.api.IList;
import ru.univeralex.lab2lists.exceptions.ListIsFullException;
import ru.univeralex.lab2lists.exceptions.NoSuchItemException;

public class AbstractListTest {
    IList list;

    @Test
    public void insertAfterTest() throws NoSuchItemException {
        list.insertAfter(1, 10);
        Assert.assertEquals("10", list.getListItemValues());
        list.insertAfter(0, 12);
        Assert.assertEquals("10, 12", list.getListItemValues());
        list.insertAfter(1, 14);
        Assert.assertEquals("10, 12, 14", list.getListItemValues());
        list.insertAfter(0, 8);
        Assert.assertEquals("10, 8, 12, 14", list.getListItemValues());
    }

    @Test(expected = NoSuchItemException.class)
    public void insertAfterToBigIndexTest() throws NoSuchItemException {
        list.insertAfter(0, 10);
        Assert.assertEquals("10", list.getListItemValues());
        list.insertAfter(1, 12);
        Assert.assertEquals("10, 12", list.getListItemValues());
    }

    @Test
    public void insertBeforeTest() throws NoSuchItemException, ListIsFullException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getListItemValues());
        list.insertBefore(0, 12);
        Assert.assertEquals("12, 10", list.getListItemValues());
        list.insertBefore(1, 14);
        Assert.assertEquals("12, 14, 10", list.getListItemValues());
        list.insertBefore(2, 8);
        Assert.assertEquals("12, 14, 8, 10", list.getListItemValues());
    }

    @Test(expected = NoSuchItemException.class)
    public void findNonExistentTest() throws NoSuchItemException, ListIsFullException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getListItemValues());
        list.insertBefore(0, 12);
        Assert.assertEquals("12, 10", list.getListItemValues());
        list.insertBefore(1, 14);
        Assert.assertEquals("12, 14, 10", list.getListItemValues());
        list.insertBefore(2, 8);
        Assert.assertEquals("12, 14, 8, 10", list.getListItemValues());
        list.findFirst(101);
    }

    @Test
    public void findFirstTest() throws NoSuchItemException, ListIsFullException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getListItemValues());
        list.insertBefore(0, 12);
        Assert.assertEquals("12, 10", list.getListItemValues());
        list.insertBefore(1, 14);
        Assert.assertEquals("12, 14, 10", list.getListItemValues());
        list.insertBefore(2, 8);
        Assert.assertEquals("12, 14, 8, 10", list.getListItemValues());
        Assert.assertEquals(0, list.findFirst(12));
        Assert.assertEquals(1, list.findFirst(14));
        Assert.assertEquals(3, list.findFirst(10));
    }
}
