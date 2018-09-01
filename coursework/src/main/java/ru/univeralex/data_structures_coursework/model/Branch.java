package ru.univeralex.data_structures_coursework.model;

import lombok.AllArgsConstructor;
import ru.univeralex.data_structures_coursework.structure.StaticStack;

/**
 * Филиал организации.
 */
@AllArgsConstructor
public class Branch {
    private String name;
    private StaticStack<Department> departmens;
}
