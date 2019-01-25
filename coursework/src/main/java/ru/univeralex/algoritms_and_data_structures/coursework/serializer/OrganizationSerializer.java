package ru.univeralex.algoritms_and_data_structures.coursework.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Organization;

import java.io.IOException;

public class OrganizationSerializer extends StdSerializer<Organization> {

    public OrganizationSerializer(Class<Organization> t) {
        super(t);
    }

    /*
    Конструктор нужен для JsonMapper
     */
    public OrganizationSerializer() {
        this(null);
    }

    @Override
    public void serialize(Organization value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("name", value.getName());
        Object[] branches = value.getBranches().toArray();
        gen.writeArrayFieldStart("branches");

        for (Object branch : branches) {
            gen.writeObject(branch);
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }

}
