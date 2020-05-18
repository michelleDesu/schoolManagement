package se.lexicon.michelle.model;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.data.CourseSequencer;
import se.lexicon.michelle.data.StudentSequencer;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class CourseTest {
    private LocalDate       date;
    private Course          course;
    private List<Student>   students;
    private Student         firstStudent,
                            secondStudent;
    @Before
    public void setUp() throws Exception {
        date = LocalDate.of( 2020, 5, 18);
        students = new ArrayList<>();

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

        CourseSequencer.resetID();
        StudentSequencer.resetID();

        students.add(firstStudent);
        students.add(secondStudent);


        course = new Course(
                CourseSequencer.nextID(),
                "Java",
                date,
                22,
                students
        );



    }

    @Test
    public void register() {
        Student third = new Student(
                StudentSequencer.nextID(),
                "Haldur",
                "haldur@test.com",
                "Jorsala vägen 35a, 37254 testås"
        );
        List<Student> expected = new ArrayList<>();
        expected.add(firstStudent);
        expected.add(secondStudent);
        expected.add(third);

        course.register(third);

        assertArrayEquals(expected.toArray(), course.getStudents().toArray());
    }

    @Test
    public void unRegister() {

        List<Student> expected = new ArrayList<>();
        expected.add(firstStudent);
        course.unRegister(secondStudent);
        assertArrayEquals(expected.toArray(), course.getStudents().toArray());
    }

    @Test
    public void getCourseID() {
        int expected = 1;
        assertEquals(expected, firstStudent.getStudentId());
    }

    @Test
    public void getCourseName() {
        String expected = "Java";
        assertEquals(expected,course.getCourseName());
    }

    @Test
    public void setCourseName() {
        String expected = "Java 8";
        course.setCourseName(expected);
        assertEquals(expected,course.getCourseName());
    }

    @Test
    public void getStartDate() {
        LocalDate expected = LocalDate.of( 2020, 5, 18);
        assertEquals(expected,course.getStartDate());
    }

    @Test
    public void setStartDate() {
        LocalDate expected = LocalDate.of( 2000, 1, 1);
        course.setStartDate(expected);
        assertEquals(expected,course.getStartDate());
    }

    @Test
    public void getWeekDuration() {
        int expected = 22;
        assertEquals(expected,course.getWeekDuration());
    }

    @Test
    public void setWeekDuration() {
        int expected = 21;
        course.setWeekDuration(expected);
        assertEquals(expected,course.getWeekDuration());
    }

    @Test
    public void getStudents() {
        List<Student> expected = new ArrayList<>();
        expected.add(firstStudent);
        expected.add(secondStudent);
        assertArrayEquals(expected.toArray(), course.getStudents().toArray());
    }

    @Test
    public void setStudents() {
        Student third = new Student(
                StudentSequencer.nextID(),
                "Haldur",
                "haldur@test.com",
                "Jorsala vägen 35a, 37254 testås"
        );
        List<Student> expected = new ArrayList<>();
        expected.add(firstStudent);
        expected.add(secondStudent);
        expected.add(third);

        course.setStudents(expected);
        assertArrayEquals(expected.toArray(), course.getStudents().toArray());
    }

    @Test
    public void testEquals_and_hashcode() {

        Course expected = new Course(
                1,
                "Java",
                date,
                22,
                students
        );
        assertTrue(expected.equals(course) && course.equals(expected));
        assertEquals(expected.hashCode(), course.hashCode());

    }
}