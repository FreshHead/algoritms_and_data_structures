package ru.univeralex.lab5sorting_algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.univeralex.utils.ArrayUtils;

public class ShellSorterTest extends AbstractSorterTest {
    @Before
    public void setUp() {
        sorter = new ShellSorter();
    }

    @Test
    public void getEveryNthTest() {
        Assert.assertEquals(ArrayUtils.convert(new int[]{7, 12}),
                ArrayUtils.convert(
                        ((ShellSorter) sorter).getEveryNth(3, new int[]{4, 1, 7, 2, 81, 12, 7, 5})
                )
        );
        Assert.assertEquals(15,
                ((ShellSorter) sorter).getEveryNth(63, ArrayUtils.generate(100, 1000)).length)
        ;
    }
}
