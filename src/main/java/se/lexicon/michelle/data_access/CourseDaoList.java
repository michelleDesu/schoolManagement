package se.lexicon.michelle.data_access;

import se.lexicon.michelle.model.Course;
import se.lexicon.michelle.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao {
    private static  List<Course> courses;

    /**
     * constructor
     * creates a new arrayList
     */
    public CourseDaoList() {
        courses = new ArrayList<>();
    }

    /**
     * saves the course to the list of courses
     * throws IllegalArgumentException if given course is null
     * @param course Course
     * @return Course
     */
    @Override
    public Course saveCourse(Course course) {
        if(course == null){
            throw new IllegalArgumentException("the course you want to add should not be null");
        }
        courses.add(course);

        return course;
    }

    /**
     * finds the course with the specified ID
     * throws NullPointerException if the course with specified id does not exist
     * @param id int
     * @return Course
     */
    @Override
    public Course findById(int id) {
        Course found = null;
        for(Course course : courses){
            if(course.getCourseID() == id){
                found = course;
            }
        }
        if (found == null){
            throw new NullPointerException("The specified course does not exist");
        }
        return found;
    }

    /**
     * return a list of courses with the specified name
     * throws NullPointerException if course list is null
     * @param name String
     * @return List\<Course\>
     */
    @Override
    public List<Course> findByName(String name) {
        List<Course> found = new ArrayList<>();
        for(Course course : courses){
            if(course.getCourseName().equals(name)){
                found.add(course);
            }
        }
        if(found.isEmpty()){
            throw new NullPointerException("There are no courses with the specified name");
        }
        return found;
    }

    /**
     * return a list of courses with the specified startDate
     *throws IllegalArgumentException if given date is null
     * @param date LocalDate
     * @return List\<Course\>
     */
    @Override
    public List<Course> findByDate(LocalDate date) {
        if(date == null){
            throw new IllegalArgumentException("The given date should not be null");
        }
        List<Course> dateCourses = new ArrayList<>();

        for (Course course: courses) {
            if(course.getStartDate() == date){
                dateCourses.add(course);
            }
        }
        if(dateCourses.isEmpty()){
            throw new NullPointerException("There are no courses with the specified name");
        }
        return dateCourses;
    }


    /**
     * return the entire list of courses
     * throws NullPointerException if the course list is null
     * @return List\<Course\>
     */
    @Override
    public List<Course> findAll() {
        if(courses.isEmpty()){
            throw new NullPointerException("There are no students");
        }
        return courses;
    }

    /**
     * Deletes the specified course
     * return true if success
     * false if no success
     * @param course Course
     * @return boolean
     */
    @Override
    public boolean removeCourse(Course course) {
        boolean removed = false;
        for (Course c : courses){
            if(c.equals(course)){
                courses.remove(c);
                removed = true;
                break;
            }
        }
        return removed;
    }
}
