package ru.univeralex.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayConverterTest {
    private ArrayConverter arrayConverter;
    @Before
    public void setUp() {
        this.arrayConverter = new ArrayConverter();
    }

    @Test
    public void convertTest() {
        Assert.assertEquals("0, 1, 2, 3, 4, 5, 6, 7, 8, 9",
                this.arrayConverter.convert(new int[]{0,1,2,3,4,5,6,7,8,9}));
    }
}
