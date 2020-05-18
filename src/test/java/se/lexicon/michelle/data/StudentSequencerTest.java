package se.lexicon.michelle.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentSequencerTest {
    private StudentSequencer sq;

    @Before
    public void setUp() throws Exception {
        sq = new StudentSequencer();
        sq.resetID();
        int nextId = StudentSequencer.nextID();
    }

    @Test
    public void nextID_should_return_next_id() {
        int expected = 2;
        assertEquals(expected, StudentSequencer.nextID());
    }

    @Test
    public void resetID_should_reset_id() {
        int expected = 1;
        sq.resetID();
        assertEquals(expected, StudentSequencer.nextID());
    }
}