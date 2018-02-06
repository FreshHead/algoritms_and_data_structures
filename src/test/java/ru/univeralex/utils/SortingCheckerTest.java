package ru.univeralex.utils;

import org.junit.Assert;
import org.junit.Test;

public class SortingCheckerTest {
    @Test
    public void isSortedTest() {
        Assert.assertEquals(true, SortingChecker.isSorted(new int[]{0, 10, 15, 32, 40, 61, 1000, 1002}));
        Assert.assertEquals(false, SortingChecker.isSorted(new int[]{0, 10, 15, 14, 40, 61, 1000, 1002}));
    }
}
