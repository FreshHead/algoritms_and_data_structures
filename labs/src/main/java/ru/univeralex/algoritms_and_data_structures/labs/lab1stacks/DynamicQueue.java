package ru.univeralex.algoritms_and_data_structures.labs.lab1stacks;


import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.api.IQueue;
import ru.univeralex.algoritms_and_data_structures.labs.lab1stacks.exceptions.QueueIsEmptyException;

public class DynamicQueue implements IQueue {
    @Override
    public String getElementsString() {
        QueueElement current = first.getNextQueueElement();
        StringBuilder result = new StringBuilder(String.valueOf(first.getValue()));
        while (current != null) {
            result.append(", ").append(current.getValue());
            current = current.getNextQueueElement();
        }
        return result.toString();
    }

    private QueueElement first;
    private QueueElement last;

    @Override
    public void add(int value) {
        if (isEmpty()) {
            first = last = new QueueElement(value, null);
        } else {
            last = new QueueElement(value, last);
            last.getPreviousQueueElement().setNextQueueElement(last);
        }
    }

    @Override
    public int offer() throws QueueIsEmptyException {
        if (isEmpty()) throw new QueueIsEmptyException("Can't offer value because queue is empty.");
        int value = first.getValue();
        first = first.getNextQueueElement();
        return value;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Can't check is full or not for dynamic queue!");
    }

    class QueueElement {
        int value;
        QueueElement previousQueueElement;

        QueueElement nextQueueElement;

        QueueElement(int value, QueueElement previousQueueElement) {
            this.value = value;
            this.previousQueueElement = previousQueueElement;
        }

        private int getValue() {
            return value;
        }

        private QueueElement getPreviousQueueElement() {
            return previousQueueElement;
        }

        private QueueElement getNextQueueElement() {
            return nextQueueElement;
        }

        private void setNextQueueElement(QueueElement nextQueueElement) {
            this.nextQueueElement = nextQueueElement;
        }

    }
}
