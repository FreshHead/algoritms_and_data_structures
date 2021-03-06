package ru.univeralex.algoritms_and_data_structures.labs.lab5sorting;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.univeralex.algoritms_and_data_structures.labs.lab5sorting.api.Sorter;
import ru.univeralex.algoritms_and_data_structures.labs.utils.ArrayUtils;

@Ignore
public class AbstractSorterTest {
    Sorter sorter;

    @Test
    public void alreadySortedTest() {
        Assert.assertEquals(
                ArrayUtils.convert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                ArrayUtils.convert(sorter.getSorted(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}))
        );
    }

    @Test
    public void sortReversedTest() {
        Assert.assertEquals(
                ArrayUtils.convert(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}),
                ArrayUtils.convert(sorter.getSorted(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}))
        );
    }

    @Test
    public void sortNotUniqueTest() {
        Assert.assertEquals(
                ArrayUtils.convert(new int[]{1, 1, 3, 3, 4, 4, 4, 7, 9, 9}),
                ArrayUtils.convert(sorter.getSorted(new int[]{9, 3, 7, 4, 9, 4, 3, 4, 1, 1}))
        );
    }

    @Test
    public void testWithRandom() {
        Assert.assertTrue(ArrayUtils.isSorted(
                sorter.getSorted(ArrayUtils.generate(100, 100_00))
        ));
    }


}
