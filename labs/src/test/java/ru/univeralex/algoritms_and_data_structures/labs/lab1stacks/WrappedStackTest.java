package ru.univeralex.algoritms_and_data_structures.labs.lab1stacks;

import org.junit.Before;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.wrapper.WrappedStack;

/**
 * Запускает тесты для встроенного Stack.
 */
public class WrappedStackTest extends AbstractStackTest {
    @Before
    public void setUp() {
        this.emptyStack = new WrappedStack();
    }
}
