package ru.univeralex.algoritms_and_data_structures.labs.utils;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void absoluteLogOfBase2Test(){
        Assert.assertEquals(1, Calculator.absoluteLogOfBase2(2));
        Assert.assertEquals(10, Calculator.absoluteLogOfBase2(1024));
        Assert.assertEquals( 9, Calculator.absoluteLogOfBase2(1023));
        Assert.assertEquals(10, Calculator.absoluteLogOfBase2(1025));
        Assert.assertEquals(6, Calculator.absoluteLogOfBase2(100));
    }


}
