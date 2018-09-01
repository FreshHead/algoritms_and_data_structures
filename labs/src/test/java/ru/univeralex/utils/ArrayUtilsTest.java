package ru.univeralex.utils;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {
    @Test
    public void generateTest() {
        Assert.assertEquals(100, ArrayUtils.generate(100, 100).length);

    }

    @Test
    public void isSortedTest() {
        Assert.assertEquals(true, ArrayUtils.isSorted(new int[]{0, 10, 15, 32, 40, 61, 1000, 1002}));
        Assert.assertEquals(false, ArrayUtils.isSorted(new int[]{0, 10, 15, 14, 40, 61, 1000, 1002}));
    }

    @Test
    public void convertTest() {
        Assert.assertEquals("0, 1, 2, 3, 4, 5, 6, 7, 8, 9",
                ArrayUtils.convert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
