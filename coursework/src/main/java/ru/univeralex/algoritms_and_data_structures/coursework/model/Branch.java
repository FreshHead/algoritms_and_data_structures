package ru.univeralex.algoritms_and_data_structures.coursework.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.univeralex.algoritms_and_data_structures.coursework.serializer.BranchSerializer;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.StaticStack;

/**
 * Филиал организации.
 */
@AllArgsConstructor
@Getter
@Builder
@JsonSerialize(using = BranchSerializer.class)
public class Branch {
    public String name;
    public StaticStack<Department> departments;

    @JsonPOJOBuilder(withPrefix = "")
    static final class BranchBuilder {
    }

    @Override
    public String toString() {
        return name;
    }
}
