package se.lexicon.michelle.data_access;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.data.CourseSequencer;
import se.lexicon.michelle.data.StudentSequencer;
import se.lexicon.michelle.model.Course;
import se.lexicon.michelle.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CourseDaoListTest {
    CourseDaoList           courses;
    private Course          firstCourse,
                            secondCourse;
    private StudentDaoList  students;
    private Student         firstStudent,
                            secondStudent;
    private LocalDate       date;



    @Before
    public void setUp() throws Exception {
        StudentSequencer.resetID();
        CourseSequencer.resetID();
        courses = new CourseDaoList();
        students = new StudentDaoList();

        date = LocalDate.of( 2020, 5, 18);

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

        firstCourse = new Course(
                CourseSequencer.nextID(),
                "Java",
                date,
                22,
                students.findAll()
        );
        secondCourse = new Course(
                CourseSequencer.nextID(),
                "Fysik",
                date,
                15,
                students.findAll()
        );

        courses.saveCourse(firstCourse);
        courses.saveCourse(secondCourse);


    }

    @Test
    public void saveCourse() {

         Course third = new Course(
                CourseSequencer.nextID(),
                "Takläggning",
                date,
                15,
                students.findAll()
        );
        CourseDaoList expected = new CourseDaoList();
        expected.saveCourse(firstCourse);
        expected.saveCourse(secondCourse);
        expected.saveCourse(third);

        courses.saveCourse(third);

        assertEquals(expected.findAll(), courses.findAll());
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveCourse_should_throw_IllegalArgumentException() {
        courses.saveCourse(null);
    }

    @Test
    public void findById() {
        Course expected = firstCourse;
        assertEquals(expected, courses.findById(1));
    }
    @Test(expected =  NullPointerException.class)
    public void findById_should_throw_NullPointerException(){
        courses.findById(5);
    }

    @Test
    public void findByName() {
        List<Course> expected = new ArrayList<>();
        expected.add(firstCourse);

        assertEquals(expected,courses.findByName("Java") );

    }

    @Test(expected =  NullPointerException.class)
    public void findByName_should_throw_NullPointerException(){
        courses.findByName( "takläggni");
    }

    @Test
    public void findByDate() {
        List<Course> expected = new ArrayList<>();
        expected.add(firstCourse);
        expected.add(secondCourse);

        assertEquals(expected,courses.findByDate(date) );
    }

    @Test(expected =  NullPointerException.class)
    public void findByDate_should_throw_NullPointerException(){
        LocalDate time = LocalDate.of(2000, 12, 5);
        courses.findByDate(time);
    }

    @Test
    public void findAll() {
        List<Course> expected = new ArrayList<>();
        expected.add(firstCourse);
        expected.add(secondCourse);

        assertEquals(expected,courses.findAll() );
    }
    @Test(expected =  NullPointerException.class)
    public void findAll_should_throw_NullPointerException(){
        CourseDaoList newList = new CourseDaoList();
        newList.findAll();
    }

    @Test
    public void removeCourse() {
        assertTrue(courses.removeCourse(firstCourse));
        assertFalse(courses.removeCourse(firstCourse));
    }
}