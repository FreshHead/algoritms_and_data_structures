package ru.univeralex.lab2lists;

import org.junit.Before;

public class StaticListTest extends AbstractListTest{
    @Before
    public void setUp() {
        list = new StaticList(10);
    }
}
