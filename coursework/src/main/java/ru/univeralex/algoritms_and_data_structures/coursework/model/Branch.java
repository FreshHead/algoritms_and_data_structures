package ru.univeralex.algoritms_and_data_structures.coursework.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.univeralex.algoritms_and_data_structures.coursework.serializer.BranchSerializer;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.StaticStack;

/**
 * Филиал организации.
 */
@AllArgsConstructor
@Getter
@JsonSerialize(using = BranchSerializer.class)
public class Branch {
    private String name;
    private StaticStack<Department> departments;
}
