package ru.univeralex.algoritms_and_data_structures.coursework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.StaticStack;

/**
 * Филиал организации.
 */
@AllArgsConstructor
@Getter
public class Branch {
    private String name;
    private StaticStack<Department> departments;
}
