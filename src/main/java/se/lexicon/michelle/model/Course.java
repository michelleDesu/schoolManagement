package se.lexicon.michelle.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Course {
    private final int       COURSE_ID;
    private String          courseName;
    private LocalDate       startDate;
    private int             weekDuration;
    private List<Student>   students;

    /**
     * Course constructor
     * @param courseID int
     * @param courseName String
     * @param startDate LocalDate
     * @param weekDuration int
     * @param students List\<Student\>
     */
    public Course(int courseID, String courseName, LocalDate startDate, int weekDuration, List<Student> students) {
        this.COURSE_ID = courseID;
        setCourseName(courseName);
        setStartDate(startDate);
        setWeekDuration(weekDuration);
        setStudents(students);
    }


    /**
     * registers a student to a course
     * @param student Student
     */
    public void register(Student student){
        students.add(student);

    }

    /**
     * removes student from a course
     * @param student Student
     */
    public void unRegister(Student student){
        students.remove(student);
    }

    /**
     * returns the course ID of the course.
     * @return int
     */
    public int getCourseID() {
        return COURSE_ID;
    }

    /**
     * returns the name of the course
     * @return String
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * sets the name of the course
     * @param courseName String
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * returns the start date of the course
     * @return LocalDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * sets the start date of the course
     * @param startDate LocalDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * returns the week duration of a course
     * @return int
     */
    public int getWeekDuration() {
        return weekDuration;
    }

    /**
     * sets the week duration of a course
     * @param weekDuration int
     */
    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    /**
     * returns the list with students in a course
     * @return List\<Student\>
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * sets a list of students in a course
     * @param students List\<Student\>
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Overrides equals
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return COURSE_ID == course.COURSE_ID &&
                weekDuration == course.weekDuration &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(startDate, course.startDate) &&
                Objects.equals(students, course.students);
    }

    /**
     * Overrides hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(COURSE_ID, courseName, startDate, weekDuration, students);
    }
}


