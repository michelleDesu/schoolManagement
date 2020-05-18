package se.lexicon.michelle.data_access;

import se.lexicon.michelle.model.Student;

import java.util.List;

public interface StudentDao {
    Student saveStudent(Student student);
    Student findByEmail(String eMail);
    List<Student> findByName(String name);
    Student     findById(int id);
    List<Student> findAll();
    boolean deleteStudent(Student student);
}
