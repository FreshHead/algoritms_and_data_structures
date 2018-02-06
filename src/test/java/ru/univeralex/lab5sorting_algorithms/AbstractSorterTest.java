package ru.univeralex.lab5sorting_algorithms;

import org.junit.Assert;
import org.junit.Test;
import ru.univeralex.lab5sorting_algorithms.api.Sorter;
import ru.univeralex.utils.ArrayConverter;
import ru.univeralex.utils.ArrayGenerator;
import ru.univeralex.utils.SortingChecker;

public class AbstractSorterTest {
    Sorter sorter;

    @Test
    public void alreadySortedTest() {
        Assert.assertEquals(
                ArrayConverter.convert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                ArrayConverter.convert(sorter.sort(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}))
        );
    }

    @Test
    public void sortReversedTest() {
        Assert.assertEquals(
                ArrayConverter.convert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                ArrayConverter.convert(sorter.sort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}))
        );
    }

    @Test
    public void sortNotUniqueTest() {
        Assert.assertEquals(
                ArrayConverter.convert(new int[]{1, 1, 3, 3, 4, 4, 4, 7, 9, 9}),
                ArrayConverter.convert(sorter.sort(new int[]{9, 3, 7, 4, 9, 4, 3, 4, 1, 1}))
        );
    }

    @Test
    public void testWithRandom() {
        Assert.assertEquals(
                true,
                SortingChecker.isSorted(
                        sorter.sort(ArrayGenerator.generate(100, 1000))
                )
        );
    }


}
