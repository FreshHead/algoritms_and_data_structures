package ru.univeralex.algoritms_and_data_structures.labs.utils;

public class Calculator {
    public static int absoluteLogOfBase2(int n){
        if(n <= 0) throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }
}
