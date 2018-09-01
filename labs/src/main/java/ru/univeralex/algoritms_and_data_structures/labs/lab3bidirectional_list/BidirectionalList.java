package ru.univeralex.algoritms_and_data_structures.labs.lab3bidirectional_list;

import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.api.IList;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.NoSuchItemException;

public class BidirectionalList implements IList {
    private ListItem head;
    private int length = 0;

    @Override
    public void insertBefore(int index, int value) throws NoSuchItemException {
        ListItem current = head;
        if (head == null) {
            head = new ListItem(value);
            head.next = head;
            head.prev = head;
            length++;
            return;
        }

        for (int i = 0; i < index; i++) {
            if (current.next == head)
                throw new NoSuchItemException("Can't insert before element with index: " + index + ". No such index!");
            current = current.next;
        }
        current.prev = current.prev.next = new ListItem(value, current.prev, current);
        length++;
        if (index == 0)
            head = current.prev;
    }

    @Override
    public void insertAfter(int index, int value) throws NoSuchItemException {
        ListItem current = head;
        if (head == null) {
            head = new ListItem(value);
            head.next = head;
            head.prev = head;
            length++;
            return;
        }
        for (int i = 0; i < index; i++) {
            if (current.next == head)
                throw new NoSuchItemException("Can't insert after element with index: " + index + ". No such index!");
            current = current.next;
        }

        current.next = new ListItem(value, current, current.next);
        current.next.next.prev = current.next;
        length++;
    }

    @Override
    public void delete(int index) throws NoSuchItemException {
        if (index >= length)
            throw new NoSuchItemException("Can't delete element with index: " + index + ". No such index!");
        ListItem current = head;
        if (head == null) {
            throw new NoSuchItemException("Can't delete because list is empty!");
        }
        if (index == 0) {
            head = null;
            length--;
            return;
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        length--;
    }

    @Override
    public int findFirst(int value) throws NoSuchItemException {
        ListItem current = head;
        int index = 0;
        do {
            if (current.value == value)
                return index;
            index++;
            current = current.next;
        } while (current != head);
        throw new NoSuchItemException("Can't find item with value:" + value);
    }

    public int findFirstInReverse(int value) throws NoSuchItemException {
        ListItem current = head.prev;
        int index = length - 1;
        do {
            if (current.value == value)
                return index;
            index--;
            current = current.prev;
        } while (index != 0);
        throw new NoSuchItemException("Can't find item with value:" + value);
    }

    @Override
    public String getItemValues() {
        ListItem current = head;
        StringBuilder stringBuilder = new StringBuilder().append(head.value);
        while (current.next != head) {
            current = current.next;
            stringBuilder.append(", ").append(current.value);
        }
        return stringBuilder.toString();
    }

    public String getItemValuesInReverse() {
        ListItem current = head.prev;
        StringBuilder stringBuilder = new StringBuilder().append(head.prev.value);
        while (current.prev != head.prev) {
            current = current.prev;
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
        ListItem prev;
        ListItem next;

        ListItem(int value) {
            this.value = value;
        }

        ListItem(int value, ListItem prev, ListItem next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
