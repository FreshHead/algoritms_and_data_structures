package ru.univeralex.lab1stacks.exceptions;

public class QueueIsFullException extends Exception {
    public QueueIsFullException(String message) {
        super(message);
    }
}
