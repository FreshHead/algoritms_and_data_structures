package ru.univeralex.algoritms_and_data_structures.coursework.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.univeralex.algoritms_and_data_structures.coursework.serializer.OrganizationSerializer;
import ru.univeralex.algoritms_and_data_structures.deserializer.OrganizationDeserializer;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.DynamicList;

/**
 * Организация.
 */
@AllArgsConstructor
@Getter
@Builder
@JsonDeserialize(using = OrganizationDeserializer.class)
@JsonSerialize(using = OrganizationSerializer.class)
public class Organization {
    private String name;
    private DynamicList<Branch> branches;

    @JsonPOJOBuilder(withPrefix = "")
    static final class OrganizationBuilder {
    }
}
