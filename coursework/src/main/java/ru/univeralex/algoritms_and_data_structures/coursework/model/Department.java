package ru.univeralex.algoritms_and_data_structures.coursework.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Отдел филиала.
 */
@AllArgsConstructor
@Getter
@Builder
@JsonDeserialize(builder = Department.DepartmentBuilder.class)
public class Department {
    private String name;
    private int employeesNumber;

    public String toString() {
        return name + ";" + employeesNumber;
    }

    @JsonPOJOBuilder(withPrefix = "")
    static final class DepartmentBuilder {
    }
}
