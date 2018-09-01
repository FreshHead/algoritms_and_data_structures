package ru.univeralex.algoritms_and_data_structures.labs.lab3list_of_lists;

import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.DynamicList;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.ListItem;
import ru.univeralex.algoritms_and_data_structures.labs.lab2lists.exceptions.NoSuchItemException;

public class ListOfLists {
    private ListOfListsItem head;

    public void insertBefore(int index, int subIndex, int value) throws NoSuchItemException {
        ListOfListsItem current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        ListItem subCurrent = head.subList.head;
        ListItem previous = null;
        if (head.subList.head == null) {
            head.subList.head = new ListItem(value);
            return;
        }
        if (subIndex == 0) {
            head.subList.head = new ListItem(value, head.subList.head);
            return;
        }
        for (int i = 0; i < index; i++) {
            if (subCurrent.getNext() == null)
                throw new NoSuchItemException("Can't insert before element with index: " + index + ". No such index!");
            previous = subCurrent;
            subCurrent = subCurrent.getNext();
        }
        previous.setNext(new ListItem(value, subCurrent));
    }

    public void insertAfter(int index, int subIndex, int value) {

    }

    public void delete(int index) {

    }

    public int findFirst(int value) {
        return 0;
    }

    public String getItemValues() {
        ListOfListsItem current = head;
        ListItem subCurrent = head.subList.head;
        StringBuilder stringBuilder = new StringBuilder().append(subCurrent.getValue());
        while (current.next != null) {
            while (subCurrent.getNext() != null) {
                subCurrent = subCurrent.getNext();
                stringBuilder.append(", ").append(subCurrent.getValue());
            }
        }
        return stringBuilder.toString();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isExist(int element) {
        return false;
    }

    class ListOfListsItem {
        DynamicList subList;
        ListOfListsItem next;

    }


}
