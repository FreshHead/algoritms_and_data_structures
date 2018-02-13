package ru.univeralex.lab2lists;

import ru.univeralex.lab2lists.api.IList;
import ru.univeralex.lab2lists.exceptions.NoSuchItemException;

public class DynamicList implements IList {
    private ListItem head;

    @Override
    public void insertBefore(int index, int value) throws NoSuchItemException {
        ListItem current = head;
        ListItem previous = null;
        if (head == null) {
            head = new ListItem(value);
            return;
        }
        if (index == 0) {
            head = new ListItem(value, head);
            return;
        }
        for (int i = 0; i < index; i++) {
            if (current.next == null)
                throw new NoSuchItemException("Can't insert before element with index: " + index + ". No such index!");
            previous = current;
            current = current.next;
        }
        previous.next = new ListItem(value, current);
    }

    @Override
    public void insertAfter(int index, int value) throws NoSuchItemException {
        ListItem current = head;
        if (head == null) {
            head = new ListItem(value);
            return;
        }
        for (int i = 0; i < index; i++) {
            if (current.next == null)
                throw new NoSuchItemException("Can't insert after element with index: " + index + ". No such index!");
            current = current.next;
        }
        current.next = new ListItem(value, current.next);
    }

    @Override
    public void delete(int index) throws NoSuchItemException {
        ListItem current = head;
        ListItem previous = null;
        if (head == null) {
            throw new NoSuchItemException("Can't delete because list is empty!");
        }
        if (index == 0) {
            head = null;
            return;
        }
        for (int i = 0; i < index; i++) {
            if (current.next == null)
                throw new NoSuchItemException("Can't delete element with index: " + index + ". No such index!");
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
    }

    @Override
    public int findFirst(int value) throws NoSuchItemException {
        ListItem current = head;
        int index = 0;
        while (current != null) {
            if (current.value == value)
                return index;
            index++;
            current = current.next;
        }
        throw new NoSuchItemException("Can't find item with value:" + value);
    }

    @Override
    public String getListItemValues() {
        ListItem current = head;
        StringBuilder stringBuilder = new StringBuilder().append(head.value);
        while (current.next != null) {
            current = current.next;
            stringBuilder.append(", ").append(current.value);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isExist(int element) {
        return false;
    }

    class ListItem {
        int value;
        ListItem next;

        ListItem(int value) {
            this.value = value;
        }

        ListItem(int value, ListItem next) {
            this.value = value;
            this.next = next;
        }
    }
}
