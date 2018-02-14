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
}
