package ru.univeralex.lab2lists;

import ru.univeralex.lab2lists.api.IList;
import ru.univeralex.lab2lists.exceptions.ListIsFullException;

public class AbstractListTest {
    IList list;

    void insertBeforeTest() throws ListIsFullException {
        list.insertBefore(1, 10);


    }
}
