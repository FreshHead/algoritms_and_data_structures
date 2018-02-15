package ru.univeralex.lab2lists;

public class ListItem {
    int value;
    ListItem next;

    ListItem(int value) {
        this.value = value;
    }

    ListItem(int value, ListItem next) {
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