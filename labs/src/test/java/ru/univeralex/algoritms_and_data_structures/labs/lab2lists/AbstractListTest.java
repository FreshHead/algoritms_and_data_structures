package ru.univeralex.algoritms_and_data_structures.labs.lab2lists;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.api.IList;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.NoSuchItemException;

@Ignore
public class AbstractListTest {
    protected IList list;

    @Test
    public void insertAfterTest() throws NoSuchItemException, IndexOutOfBoundsException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getElementsString());
        list.insertAfter(0, 12);
        Assert.assertEquals("10, 12", list.getElementsString());
        list.insertAfter(1, 14);
        Assert.assertEquals("10, 12, 14", list.getElementsString());
        list.insertAfter(0, 8);
        Assert.assertEquals("10, 8, 12, 14", list.getElementsString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertAfterToBigIndexTest() throws NoSuchItemException, IndexOutOfBoundsException {
        list.insertAfter(0, 10);
        list.insertAfter(2, 12);
    }

    @Test
    public void insertBeforeTest() throws IndexOutOfBoundsException, NoSuchItemException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getElementsString());
        list.insertBefore(0, 12);
        Assert.assertEquals("12, 10", list.getElementsString());
        list.insertBefore(1, 14);
        Assert.assertEquals("12, 14, 10", list.getElementsString());
        list.insertBefore(2, 8);
        Assert.assertEquals("12, 14, 8, 10", list.getElementsString());
    }

    @Test(expected = NoSuchItemException.class)
    public void findNonExistentTest() throws IndexOutOfBoundsException, NoSuchItemException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getElementsString());
        list.insertBefore(0, 12);
        Assert.assertEquals("12, 10", list.getElementsString());
        list.insertBefore(1, 14);
        Assert.assertEquals("12, 14, 10", list.getElementsString());
        list.insertBefore(2, 8);
        Assert.assertEquals("12, 14, 8, 10", list.getElementsString());
        list.findFirst(101);
    }

    @Test
    public void findFirstTest() throws IndexOutOfBoundsException, NoSuchItemException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getElementsString());
        list.insertBefore(0, 12);
        Assert.assertEquals("12, 10", list.getElementsString());
        list.insertBefore(1, 14);
        Assert.assertEquals("12, 14, 10", list.getElementsString());
        list.insertBefore(2, 8);
        Assert.assertEquals("12, 14, 8, 10", list.getElementsString());
        Assert.assertEquals(0, list.findFirst(12));
        Assert.assertEquals(1, list.findFirst(14));
        Assert.assertEquals(3, list.findFirst(10));
    }

    @Test
    public void isEmptyTest() throws IndexOutOfBoundsException, NoSuchItemException {
        Assert.assertTrue(list.isEmpty());
        list.insertBefore(0, 10);
        Assert.assertFalse(list.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteInEmptyTest() throws IndexOutOfBoundsException {
        list.delete(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteNonExistentIndexTest() throws NoSuchItemException, IndexOutOfBoundsException {
        list.insertBefore(0, 10);
        Assert.assertFalse(list.isEmpty());
        list.delete(1);
    }

    @Test
    public void deleteTest() throws NoSuchItemException, IndexOutOfBoundsException {
        list.insertBefore(0, 10);
        list.delete(0);
        Assert.assertTrue(list.isEmpty());
        list.insertBefore(0, 10);
        list.insertAfter(0, 11);
        list.insertAfter(1, 12);
        list.delete(1);
        Assert.assertEquals("10, 12", list.getElementsString());
    }

}
