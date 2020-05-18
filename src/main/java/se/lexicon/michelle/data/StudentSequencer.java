package se.lexicon.michelle.data;

public class StudentSequencer {
    private static int studentID = 0;

    /**
     * returns a unique id for a student
     * @return int
     */
    public static int nextID(){
        return ++studentID;
    }

    /**
     * for testing purposes
     */
    public void resetID(){
        studentID = 0;
    }
}
