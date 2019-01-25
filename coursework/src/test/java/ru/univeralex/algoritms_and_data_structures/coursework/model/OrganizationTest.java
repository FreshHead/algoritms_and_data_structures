package ru.univeralex.algoritms_and_data_structures.coursework.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Test;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.StaticStack;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsFullException;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.DynamicList;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class OrganizationTest {
    @Test
    public void populateBranch() throws StackIsFullException {
        StaticStack<Department> departments = new StaticStack<>(10);

        Branch branch = new Branch("Branch1", departments);

        departments.push(new Department("Dep1", 10));
        departments.push(new Department("Dep2", 11));

        System.out.println(branch.getDepartments().getElementsString());

        assertEquals(branch.getDepartments().pop().getName(), "Dep2");
        assertEquals(branch.getDepartments().pop().getName(), "Dep1");
    }

    @Test
    public void jsonTest() throws StackIsFullException, IOException {
        StaticStack<Department> departments = new StaticStack<>(10);
        Branch branch1 = new Branch("Branch1", departments);
        Branch branch2 = new Branch("Branch2", departments);
        DynamicList<Branch> branches = new DynamicList<>();
        branches.insertBefore(0, branch1);
        branches.insert(branch2);
        Organization organization = new Organization("ООО Тест", branches);
        departments.push(new Department("Dep1", 10));
        departments.push(new Department("Dep2", 11));
        ObjectMapper objectMapper = new ObjectMapper();

//        Можно сериализовывать структуры данных но это довольно неудобно
//        SimpleModule module = new SimpleModule();
//        module.addSerializer(StaticStack.class, new StaticStackSerializer());
//        objectMapper.registerModule(module);

//        String jsonString = objectMapper.writeValueAsString(branch);
        File file = new File("src/test/resources/test.json");

        objectMapper.writeValue(file, organization);
//        System.out.println(jsonString);
//        try {
//            JsonNode jsonNode = objectMapper.readerFor(Branch.class).readTree(jsonString);
//            System.out.println(jsonNode.asText());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Branch deserializedBranch = objectMapper.readValue(jsonString, Branch.class);
//        System.out.println(deserializedBranch.getName());
    }

    @Test
    public void SerializeDepartmentTest() throws IOException {
        Department dep1 = new Department("Dep1", 10);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(dep1);
        System.out.println(jsonString);
        Department deserializedDep = objectMapper.readValue(jsonString, Department.class);
        System.out.println(deserializedDep.getName() + deserializedDep.getEmployeesNumber());

    }

    @Test
    public void lombokTest() {
        Some some = new Some(1);
        System.out.println(some.getId());
    }

    @Getter
    @AllArgsConstructor
    private class Some {
        private int id;
    }

}
