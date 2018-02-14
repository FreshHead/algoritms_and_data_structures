package ru.univeralex.lab3bidirectional_list;

import ru.univeralex.lab2lists.api.IList;
import ru.univeralex.lab2lists.exceptions.ListIsFullException;
import ru.univeralex.lab2lists.exceptions.NoSuchItemException;

public class BidirectionalList implements IList {
    private ListItem head;

    @Override
    public void insertBefore(int index, int value) throws NoSuchItemException {
        ListItem current = head;
        if (head == null) {
            head = new ListItem(value);
            head.next = head;
            head.prev = head;
            return;
        }

        for (int i = 0; i < index; i++) {
            if (current.next == head)
                throw new NoSuchItemException("Can't insert before element with index: " + index + ". No such index!");
            current = current.next;
        }
        current.prev = current.prev.next = new ListItem(value, current.prev, current);
        if (index == 0)
            head = current.prev;
    }

    @Override
    public void insertAfter(int index, int value) throws NoSuchItemException, ListIsFullException {
        ListItem current = head;
        if (head == null) {
            head = new ListItem(value);
            head.next = head;
            head.prev = head;
            return;
        }
        for (int i = 0; i < index; i++) {
            if (current.next == head)
                throw new NoSuchItemException("Can't insert after element with index: " + index + ". No such index!");
            current = current.next;
        }

        current.next = new ListItem(value, current, current.next);
        current.next.next.prev = current.next;

    }

    @Override
    public void delete(int index) throws NoSuchItemException {

    }

    @Override
    public int findFirst(int value) throws NoSuchItemException {
        ListItem current = head;
        int index = 0;
        while (current != head) {
            if (current.value == value)
                return index;
            index++;
            current = current.next;
        }
        throw new NoSuchItemException("Can't find item with value:" + value);
    }

    public int findFirstInReverse(int value) throws NoSuchItemException {
        return 0;
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
