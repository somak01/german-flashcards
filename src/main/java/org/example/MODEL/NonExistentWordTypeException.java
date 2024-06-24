package org.example.MODEL;

public class NonExistentWordTypeException extends Exception{
    public NonExistentWordTypeException() {
        super();
    }
    public NonExistentWordTypeException(String message) {
        super(message);
    }
}
