package se.lexicon.michelle.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseSequencerTest {

    @Before
    public void setUp() throws Exception {
        CourseSequencer.resetID();
        int nextId = CourseSequencer.nextID();
    }

    @Test
    public void nextID() {
        int expected = 2;
        assertEquals(expected, CourseSequencer.nextID());
    }

    @Test
    public void resetID() {
        int expected = 1;
        CourseSequencer.resetID();
        assertEquals(expected, CourseSequencer.nextID());
    }
}