package ru.univeralex.algoritms_and_data_structures.labs.lab2lists;

import org.junit.Before;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.wrapper.WrappedDynamicList;

public class DynamicListTest extends AbstractListTest {
    @Before
    public void setUp() {
        list = new WrappedDynamicList();
    }
}
