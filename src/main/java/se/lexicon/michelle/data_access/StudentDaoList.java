package se.lexicon.michelle.data_access;

import se.lexicon.michelle.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentDaoList implements StudentDao{
    private static List<Student> students;

    /**
     * default constructor
     * creates an empty ArrayList of Students
     */
    public StudentDaoList() {
        students = new ArrayList<>();
    }

    /**
     * adds the student to the student ArrayList
     * throws IllegalArgumentException if the student is null
     * @param student Student
     * @return Student
     */
    @Override
    public Student saveStudent(Student student) {
        if(student == null){
            throw new IllegalArgumentException("Student you want to add should not be null");
        }
        students.add(student);

        return student;
    }

    /**
     * Searches through student ArrayList for the student with the specified email
     * @param eMail String
     * @return Student
     */
    @Override
    public Student findByEmail(String eMail) {
        Student found = null;
        for(Student student : students){
            if(student.getEmail().equals(eMail)){
                found = student;
            }
        }
        if (found == null){
            throw new NullPointerException("There are no student with that email address");

        }
        return found;
    }

    /**
     * find all students with the the specified name
     * adds them to a new list
     * throws NullPointerException if no names found.
     * @param name String
     * @return List\<Student\>
     */
    @Override
    public List<Student> findByName(String name) {
        List<Student> found = new ArrayList<>();
        for(Student student : students){
            if(student.getName().equals(name)){
                found.add(student);
            }
        }
        if(found.isEmpty()){
            throw new NullPointerException("There are no students with the specified name");
        }
        return found;
    }

    /**
     * finds the student with the specified ID
     * throws NullPointerException if student with specified id does not exist
     * @param id int
     * @return Student
     */
    @Override
    public Student findById(int id) {
        Student found = null;
        for(Student student : students){
            if(student.getStudentId() == id){
                found = student;
            }
        }
        if (found == null){
            throw new NullPointerException("The specified student does not exist");
        }
        return found;
    }

    /**
     * return the entire list of Students
     * throws NullPointerException if student list is emppty
     * @return List\<Student\>
     */
    @Override
    public List<Student> findAll() {
        if(students.isEmpty()){
            throw new NullPointerException("There are no students");
        }
        return students;
    }

    /**
     * Deletes the specified student
     * return true if success
     * false if no success
     * @param student Student
     * @return boolean
     */
    @Override
    public boolean deleteStudent(Student student) {
        boolean removed = false;
        for(Student s : students){
            if(s.equals(student)){
                students.remove(s);
                removed = true;
                break;
            }
        }
        return removed;

    }

    /**
     * Overrides the equal
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * overrides the hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
