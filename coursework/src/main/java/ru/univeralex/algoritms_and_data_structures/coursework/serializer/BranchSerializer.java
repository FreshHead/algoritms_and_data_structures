package ru.univeralex.algoritms_and_data_structures.coursework.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Branch;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Department;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.StaticStack;

import java.io.IOException;

public class BranchSerializer extends StdSerializer<Branch> {

    public BranchSerializer(Class<Branch> t) {
        super(t);
    }

    public BranchSerializer() {
        this(null);
    }

    @Override
    public void serialize(Branch value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("name", value.getName());
        StaticStack<Department> departments = value.getDepartments();
        gen.writeArrayFieldStart("departments");
        while (!departments.isEmpty()) {
            gen.writeStartObject();
            Department department = departments.pop();
            gen.writeStringField("name", department.getName());
            gen.writeNumberField("employee_number", department.getEmployeesNumber());
            gen.writeEndObject();
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }

}
