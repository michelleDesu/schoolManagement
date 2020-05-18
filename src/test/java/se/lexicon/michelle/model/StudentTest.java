package se.lexicon.michelle.model;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.data.StudentSequencer;

import static org.junit.Assert.*;

public class StudentTest {
    Student student;

    @Before
    public void setUp() throws Exception {
        StudentSequencer.resetID();
        student = new Student(
                StudentSequencer.nextID(),
                "Eldbjörg",
                "eldbjörg@test.com",
                "Jorsala vägen 15B, 37254 testås"
        );
    }

    @Test
    public void getStudentId() {
        int expected = 1;
        assertEquals(expected, student.getStudentId());
    }

    @Test
    public void getName() {
        String expected = "Eldbjörg";
        assertEquals(expected, student.getName());
    }

    @Test
    public void setName() {
        String expected = "Saga";
        student.setName("Saga");
        assertEquals(expected, student.getName() );
    }

    @Test
    public void getEmail() {
        String expected = "eldbjörg@test.com";
        assertEquals(expected, student.getEmail() );
    }

    @Test
    public void setEmail() {
        String expected = "saga@test.com";
        student.setEmail(expected);
        assertEquals(expected, student.getEmail());
    }

    @Test
    public void getAddress() {
        String expected = "Jorsala vägen 15B, 37254 testås";
        assertEquals(expected, student.getAddress() );
    }

    @Test
    public void setAddress() {
        String expected = "testvägen 73, 37154 testås";
        student.setAddress(expected);
        assertEquals(expected, student.getAddress());
    }

    @Test
    public void testEquals_and_hashcode() {

        Student expected = new Student(
                1 ,
                "Eldbjörg",
                "eldbjörg@test.com",
                "Jorsala vägen 15B, 37254 testås"
        );
        assertTrue(expected.equals(student) && student.equals(expected));
        assertEquals(expected.hashCode(), student.hashCode());

    }
}