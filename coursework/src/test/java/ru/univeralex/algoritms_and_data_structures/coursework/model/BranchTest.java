package ru.univeralex.algoritms_and_data_structures.coursework.model;

import org.junit.Test;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.StaticStack;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsFullException;

import static org.junit.Assert.assertEquals;

public class BranchTest {
    @Test
    public void populateBranch() throws StackIsFullException {
        StaticStack<Department> departments = new StaticStack<>(10);

        Branch branch = new Branch("Branch1", departments);
        departments.push(new Department("Dep1", 10));
        departments.push(new Department("Dep2", 11));
        assertEquals(branch.getDepartments().pop().getName(), "Dep2");
        assertEquals(branch.getDepartments().pop().getName(), "Dep1");
    }

}
