package se.lexicon.michelle.data.exceptions;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
