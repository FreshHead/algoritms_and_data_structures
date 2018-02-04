package ru.univeralex.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayToStringConverterTest {
    private ArrayToStringConverter arrayToStringConverter;
    @Before
    public void setUp() {
        this.arrayToStringConverter = new ArrayToStringConverter();
    }

    @Test
    public void convertTest() {
        Assert.assertEquals("0, 1, 2, 3, 4, 5, 6, 7, 8, 9",
                this.arrayToStringConverter.convert(new int[]{0,1,2,3,4,5,6,7,8,9}));
    }
}
