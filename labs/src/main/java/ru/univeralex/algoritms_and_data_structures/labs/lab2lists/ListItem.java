package ru.univeralex.algoritms_and_data_structures.labs.lab2lists;

public class ListItem<E> {
    E value;
    ListItem next;

    public ListItem(E value) {
        this.value = value;
    }

    public ListItem(E value, ListItem next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public ListItem getNext() {
        return next;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }
}