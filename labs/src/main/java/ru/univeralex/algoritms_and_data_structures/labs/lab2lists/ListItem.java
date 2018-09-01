package ru.univeralex.algoritms_and_data_structures.labs.lab2lists;

public class ListItem {
    int value;
    ListItem next;

    public ListItem(int value) {
        this.value = value;
    }

    public ListItem(int value, ListItem next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListItem getNext() {
        return next;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }
}