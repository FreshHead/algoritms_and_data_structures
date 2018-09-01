package ru.univeralex.lab2lists;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.univeralex.lab2lists.api.IList;
import ru.univeralex.lab2lists.exceptions.ListIsFullException;
import ru.univeralex.lab2lists.exceptions.NoSuchItemException;

@Ignore
public class AbstractListTest {
    protected IList list;

    @Test
    public void insertAfterTest() throws NoSuchItemException, ListIsFullException {
        list.insertAfter(1, 10);
        Assert.assertEquals("10", list.getItemValues());
        list.insertAfter(0, 12);
        Assert.assertEquals("10, 12", list.getItemValues());
        list.insertAfter(1, 14);
        Assert.assertEquals("10, 12, 14", list.getItemValues());
        list.insertAfter(0, 8);
        Assert.assertEquals("10, 8, 12, 14", list.getItemValues());
    }

    @Test(expected = NoSuchItemException.class)
    public void insertAfterToBigIndexTest() throws NoSuchItemException, ListIsFullException {
        list.insertAfter(0, 10);
        Assert.assertEquals("10", list.getItemValues());
        list.insertAfter(1, 12);
        Assert.assertEquals("10, 12", list.getItemValues());
    }

    @Test
    public void insertBeforeTest() throws NoSuchItemException, ListIsFullException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getItemValues());
        list.insertBefore(0, 12);
        Assert.assertEquals("12, 10", list.getItemValues());
        list.insertBefore(1, 14);
        Assert.assertEquals("12, 14, 10", list.getItemValues());
        list.insertBefore(2, 8);
        Assert.assertEquals("12, 14, 8, 10", list.getItemValues());
    }

    @Test(expected = NoSuchItemException.class)
    public void findNonExistentTest() throws NoSuchItemException, ListIsFullException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getItemValues());
        list.insertBefore(0, 12);
        Assert.assertEquals("12, 10", list.getItemValues());
        list.insertBefore(1, 14);
        Assert.assertEquals("12, 14, 10", list.getItemValues());
        list.insertBefore(2, 8);
        Assert.assertEquals("12, 14, 8, 10", list.getItemValues());
        list.findFirst(101);
    }

    @Test
    public void findFirstTest() throws NoSuchItemException, ListIsFullException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getItemValues());
        list.insertBefore(0, 12);
        Assert.assertEquals("12, 10", list.getItemValues());
        list.insertBefore(1, 14);
        Assert.assertEquals("12, 14, 10", list.getItemValues());
        list.insertBefore(2, 8);
        Assert.assertEquals("12, 14, 8, 10", list.getItemValues());
        Assert.assertEquals(0, list.findFirst(12));
        Assert.assertEquals(1, list.findFirst(14));
        Assert.assertEquals(3, list.findFirst(10));
    }

    @Test
    public void isEmptyTest() throws NoSuchItemException, ListIsFullException {
        Assert.assertEquals(true, list.isEmpty());
        list.insertBefore(0, 10);
        Assert.assertEquals(false, list.isEmpty());
    }

    @Test(expected = NoSuchItemException.class)
    public void deleteInEmptyTest() throws NoSuchItemException {
        list.delete(0);
    }

    @Test(expected = NoSuchItemException.class)
    public void deleteNonExistentIndexTest() throws NoSuchItemException, ListIsFullException {
        list.insertAfter(0, 10);
        Assert.assertEquals(false, list.isEmpty());
        list.delete(1);
    }

    @Test
    public void deleteTest() throws NoSuchItemException, ListIsFullException {
        list.insertAfter(0, 10);
        list.delete(0);
        Assert.assertEquals(true, list.isEmpty());
        list.insertAfter(0, 10);
        list.insertAfter(0, 11);
        list.insertAfter(1, 12);
        list.delete(1);
        Assert.assertEquals("10, 12", list.getItemValues());
    }

}
