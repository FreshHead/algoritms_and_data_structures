package ru.univeralex.utils;

import org.junit.Assert;
import org.junit.Test;

public class ArrayGeneratorTest {
    @Test
    public void genetateTest(){
        Assert.assertEquals(100, ArrayGenerator.generate(100, 100).length);

    }
}
