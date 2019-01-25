package ru.univeralex.algoritms_and_data_structures.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Branch;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Department;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Organization;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.StaticStack;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.StackIsFullException;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.DynamicList;

import java.io.IOException;
import java.util.Iterator;

public class OrganizationDeserializer extends StdDeserializer<Organization> {

    public OrganizationDeserializer() {
        this(null);
    }

    public OrganizationDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Organization deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        String name = node.get("name").asText();
        Iterator<JsonNode> branchNodeIterator = node.get("branches").elements();
        DynamicList<Branch> branches = deserializeBranches(branchNodeIterator);

        return new Organization(name, branches);
    }

    private DynamicList<Branch> deserializeBranches(Iterator<JsonNode> branchNodeIterator) {
        DynamicList<Branch> branches = new DynamicList<>();

        while (branchNodeIterator.hasNext()) {
            JsonNode branchNode = branchNodeIterator.next();
            String branchName = branchNode.get("name").asText();
            Iterator<JsonNode> departmentNodeIterator = branchNode.get("departments").elements();
            int size = countDepartments(branchNode.get("departments").elements());
            StaticStack<Department> departments = deserializeDepartment(departmentNodeIterator, size);
            branches.insert(new Branch(branchName, departments));
        }
        return branches;
    }

    private StaticStack<Department> deserializeDepartment(Iterator<JsonNode> departmentNodeIterator, int size) {
        StaticStack<Department> departments = new StaticStack<>(20);

        while (departmentNodeIterator.hasNext()) {
            JsonNode departmentNode = departmentNodeIterator.next();
            String name = departmentNode.get("name").asText();
            int employeesNumber = departmentNode.get("employees_number").asInt();
            try {
                departments.push(new Department(name, employeesNumber));
            } catch (StackIsFullException e) {
                e.printStackTrace();
            }
        }
        return departments;
    }

    private int countDepartments(Iterator<JsonNode> departmentNodeIterator) {
        int count = 0;
        while (departmentNodeIterator.hasNext()) {
            count++;
            departmentNodeIterator.next();
        }
        return count;

    }
}
