package se.lexicon.michelle.data;

public class CourseSequencer {
    private static int CourseID = 0;

    /**
     * returns a unique id for a course
     * @return int
     */
    public static int nextID(){
        return ++CourseID;
    }

    /**
     * for testing purposes
     */
    public static void resetID(){
        CourseID = 0;
    }
}
