package ru.univeralex.algoritms_and_data_structures.coursework.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.StaticStack;

import java.io.IOException;

public class StaticStackSerializer extends StdSerializer<StaticStack> {
    public StaticStackSerializer(Class<StaticStack> t) {
        super(t);
    }

    public StaticStackSerializer() {
        this(null);
    }

    @Override
    public void serialize(StaticStack value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        Object[] elements = value.getElements();
        gen.writeArrayFieldStart("items");
        for (Object element : elements) {
            gen.writeObject(element);
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }

}
