package ru.univeralex.lab5sorting_algorithms;

import org.junit.Assert;
import org.junit.Test;
import ru.univeralex.lab5sorting_algorithms.api.Sorter;
import ru.univeralex.utils.ArrayToStringConverter;

public class AbstractSorterTest {
    Sorter sorter;
    private ArrayToStringConverter converter = new ArrayToStringConverter();

    @Test
    public void alreadySortedTest() {
        Assert.assertEquals(
                converter.convert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                converter.convert(sorter.sort(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}))
        );
    }

    @Test
    public void sortReversedTest() {
        Assert.assertEquals(
                converter.convert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                converter.convert(sorter.sort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}))
        );
    }

    @Test
    public void sortNotUniqueTest() {
        Assert.assertEquals(
                converter.convert(new int[]{1, 1, 3, 3, 4, 4, 4, 7, 9, 9}),
                converter.convert(sorter.sort(new int[]{9, 3, 7, 4, 9, 4, 3, 4, 1, 1}))
        );
    }
}
