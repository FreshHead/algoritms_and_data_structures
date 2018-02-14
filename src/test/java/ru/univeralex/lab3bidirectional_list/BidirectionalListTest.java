package ru.univeralex.lab3bidirectional_list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.univeralex.lab2lists.AbstractListTest;
import ru.univeralex.lab2lists.exceptions.ListIsFullException;
import ru.univeralex.lab2lists.exceptions.NoSuchItemException;

public class BidirectionalListTest extends AbstractListTest {
    @Before
    public void setUp() {
        list = new BidirectionalList();
    }

    @Test
    public void getItemValuesInReverseTest() throws NoSuchItemException, ListIsFullException {
        list.insertAfter(0, 1);
        list.insertBefore(0, 0);
        list.insertBefore(0, -1);
        list.insertAfter(2, 2);
        Assert.assertEquals("2, 1, 0, -1", ((BidirectionalList) list).getItemValuesInReverse());
    }

    @Test
    public void findFirstInReverseTest() throws ListIsFullException, NoSuchItemException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getItemValues());
        list.insertBefore(0, 12);
        Assert.assertEquals("12, 10", list.getItemValues());
        list.insertBefore(1, 14);
        Assert.assertEquals("12, 14, 10", list.getItemValues());
        list.insertBefore(2, 8);
        Assert.assertEquals("12, 14, 8, 10", list.getItemValues());
        list.insertBefore(3, 12);
        Assert.assertEquals(3, ((BidirectionalList) list).findFirstInReverse(12));
        Assert.assertEquals(1, ((BidirectionalList) list).findFirstInReverse(14));
        Assert.assertEquals(4, ((BidirectionalList) list).findFirstInReverse(10));
    }
}
