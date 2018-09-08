package ru.univeralex.algoritms_and_data_structures.labs.lab2lists;

import org.junit.Before;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.wrapper.WrappedArrayList;

public class WrappedArrayListTest extends AbstractListTest {
    @Before
    public void setUp() {
        this.list = new WrappedArrayList();
    }
}
