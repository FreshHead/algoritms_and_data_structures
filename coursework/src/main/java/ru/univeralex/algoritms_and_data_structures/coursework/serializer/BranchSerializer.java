package ru.univeralex.algoritms_and_data_structures.coursework.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Branch;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Department;

import java.io.IOException;

public class BranchSerializer extends StdSerializer<Branch> {

    public BranchSerializer(Class<Branch> t) {
        super(t);
    }

    /*
    Конструктор нужен для JsonMapper
     */
    public BranchSerializer() {
        this(null);
    }

    @Override
    public void serialize(Branch value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("name", value.getName());
        Object[] departments = value.getDepartments().getElements();
        gen.writeArrayFieldStart("departments");
        for (Object department : departments) {
            if (department != null) {
                gen.writeStartObject();
                gen.writeStringField("name", ((Department) department).getName());
                gen.writeNumberField("employees_number", ((Department) department).getEmployeesNumber());
                gen.writeEndObject();
            }
        }

        gen.writeEndArray();
        gen.writeEndObject();
    }

}
