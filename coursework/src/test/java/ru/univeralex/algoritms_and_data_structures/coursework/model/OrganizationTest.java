package ru.univeralex.algoritms_and_data_structures.coursework.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.StaticStack;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsFullException;

import static org.junit.Assert.assertEquals;

public class OrganizationTest {
    @Test
    public void populateBranch() throws StackIsFullException {
        StaticStack<Department> departments = new StaticStack<>(10);
        Branch branch = new Branch("Branch1", departments);
        departments.push(new Department("Dep1", 10));
        departments.push(new Department("Dep2", 11));
        assertEquals(branch.getDepartments().pop().getName(), "Dep2");
        assertEquals(branch.getDepartments().pop().getName(), "Dep1");
    }


    @Test
    public void jsonTest() throws StackIsFullException, JsonProcessingException {
        StaticStack<Department> departments = new StaticStack<>(10);
        Branch branch = new Branch("Branch1", departments);
        departments.push(new Department("Dep1", 10));
        departments.push(new Department("Dep2", 11));

        String json2 = new ObjectMapper().writeValueAsString(branch);
        System.out.println(json2);
    }

}
