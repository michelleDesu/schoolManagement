package se.lexicon.michelle.data_access;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.data.CourseSequencer;
import se.lexicon.michelle.data.StudentSequencer;
import se.lexicon.michelle.model.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoListTest {
    private StudentDaoList  students;
    private Student         firstStudent,
                            secondStudent;

    @Before
    public void setUp() throws Exception {
        StudentSequencer.resetID();
        students = new StudentDaoList();

        firstStudent = new Student(
                StudentSequencer.nextID(),
                "Eldbjörg",
                "eldbjörg@test.com",
                "Jorsala vägen 15B, 37254 testås"
        );
        secondStudent = new Student(
                StudentSequencer.nextID(),
                "Saga",
                "saga@test.com",
                "Jorsala vägen 15B, 37254 testås"
        );



        students.saveStudent(firstStudent);
        students.saveStudent(secondStudent);


    }

    @Test
    public void saveStudent() {
        Student third = new Student(
                StudentSequencer.nextID(),
                "Haldur",
                "haldur@test.com",
                "Jorsala vägen 35a, 37254 testås"
        );
        StudentDaoList expected = new StudentDaoList();
        expected.saveStudent(firstStudent);
        expected.saveStudent(secondStudent);
        expected.saveStudent(third);

        students.saveStudent(third);
        assertEquals(expected.findAll(), students.findAll());


    }
    @Test(expected = IllegalArgumentException.class)
    public void saveStudent_should_throw_IllegalArgumentException() {
        students.saveStudent(null);
    }

    @Test
    public void findByEmail() {
       Student expected = new Student(
               1,
               "Eldbjörg",
               "eldbjörg@test.com",
               "Jorsala vägen 15B, 37254 testås"
       );
       assertEquals(expected, students.findByEmail("eldbjörg@test.com"));


    }
    @Test(expected = NullPointerException.class)
    public void findByEmail_should_throw_NullPointerException() {
        students.findByEmail( "Saga.erx@test.com");
    }

    @Test
    public void findByName() {
        List<Student> expected = new ArrayList<>();
        expected.add(firstStudent);

        assertEquals(expected,students.findByName("Eldbjörg") );

    }
    @Test(expected =  NullPointerException.class)
    public void findByName_should_throw_NullPointerException(){
        students.findByEmail( "");
    }

    @Test
    public void findById() {
        Student expected = firstStudent;
        assertEquals(expected, students.findById(1));
    }

    @Test(expected =  NullPointerException.class)
    public void findById_should_throw_NullPointerException(){
        students.findById(5);
    }

    @Test
    public void findAll() {
        List<Student> expected = new ArrayList<>();
        expected.add(firstStudent);
        expected.add(secondStudent);

        assertEquals(expected,students.findAll() );

    }

    @Test(expected =  NullPointerException.class)
    public void findAll_should_throw_NullPointerException(){
        StudentDaoList newList = new StudentDaoList();
        newList.findAll();
    }

    @Test
    public void deleteStudent() {
        assertTrue(students.deleteStudent(firstStudent));
        assertFalse(students.deleteStudent(firstStudent));
    }

    @Test
    public void testEquals_and_hashcode() {

        Student expected = new Student(
                1 ,
                "Eldbjörg",
                "eldbjörg@test.com",
                "Jorsala vägen 15B, 37254 testås"
        );
        assertTrue(expected.equals(firstStudent) && firstStudent.equals(expected));
        assertEquals(expected.hashCode(), firstStudent.hashCode());

    }
}