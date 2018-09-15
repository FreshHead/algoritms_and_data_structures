package ru.univeralex.algoritms_and_data_structures.labs.lab2lists;

public class ListItem {
    Object value;
    ListItem next;

    public ListItem(Object value) {
        this.value = value;
    }

    public ListItem(Object value, ListItem next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
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