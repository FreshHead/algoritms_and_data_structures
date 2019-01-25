package ru.univeralex.algoritms_and_data_structures.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Branch;
import ru.univeralex.algoritms_and_data_structures.coursework.model.Organization;
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
        Iterator<JsonNode> branchIterator = node.get("branches").elements();
        DynamicList<Branch> branches = new DynamicList<>();

        while (branchIterator.hasNext()) {
            String branchName = branchIterator.next().get("name").asText();
            branches.insert(new Branch(branchName, null));
        }

        return new Organization(name, branches);
    }
}
