package ru.univeralex.algoritms_and_data_structures.labs.lab3bidirectional_list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.AbstractListTest;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.NoSuchItemException;

public class BidirectionalListTest extends AbstractListTest {
    @Before
    public void setUp() {
        list = new BidirectionalList();
    }

    @Test
    public void getItemValuesInReverseTest() throws NoSuchItemException {
        list.insertAfter(0, 1);
        list.insertBefore(0, 0);
        list.insertBefore(0, -1);
        list.insertAfter(2, 2);
        assertEquals("2, 1, 0, -1", ((BidirectionalList) list).getItemValuesInReverse());
    }

    private void assertEquals(String s, String itemValuesInReverse) {
    }

    @Test
    public void findFirstInReverseTest() throws NoSuchItemException {
        list.insertBefore(0, 10);
        Assert.assertEquals("10", list.getElementsString());
        list.insertBefore(0, 12);
        Assert.assertEquals("12, 10", list.getElementsString());
        list.insertBefore(1, 14);
        Assert.assertEquals("12, 14, 10", list.getElementsString());
        list.insertBefore(2, 8);
        Assert.assertEquals("12, 14, 8, 10", list.getElementsString());
        list.insertBefore(3, 12);
        Assert.assertEquals(3, ((BidirectionalList) list).findFirstInReverse(12));
        Assert.assertEquals(1, ((BidirectionalList) list).findFirstInReverse(14));
        Assert.assertEquals(4, ((BidirectionalList) list).findFirstInReverse(10));
    }
}
