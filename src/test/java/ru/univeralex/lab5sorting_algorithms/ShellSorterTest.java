package ru.univeralex.lab5sorting_algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.univeralex.utils.ArrayConverter;
import ru.univeralex.utils.ArrayGenerator;

public class ShellSorterTest extends AbstractSorterTest {
    @Before
    public void setUp() {
        sorter = new ShellSorter();
    }

    @Test
    public void getEveryNthTest() {
        Assert.assertEquals(ArrayConverter.convert(new int[]{7, 12}),
                ArrayConverter.convert(
                        ((ShellSorter) sorter).getEveryNth(3, new int[]{4, 1, 7, 2, 81, 12, 7, 5})
                )
        );
        Assert.assertEquals(15,
                ((ShellSorter) sorter).getEveryNth(63, ArrayGenerator.generate(100, 1000)).length)
        ;
    }
}
