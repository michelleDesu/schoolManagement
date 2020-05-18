package se.lexicon.michelle.model;

import java.util.Objects;

public class Student {
    private final int STUDENT_ID;
    private String name,
                    email,
                    address;

    public Student(int studentId, String name, String email, String address) {
        this.STUDENT_ID = studentId;
        setName(name);
        setEmail(email);
        setAddress(address);
    }


    public int getStudentId() {
        return STUDENT_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return STUDENT_ID == student.STUDENT_ID &&
                Objects.equals(name, student.name) &&
                Objects.equals(email, student.email) &&
                Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(STUDENT_ID, name, email, address);
    }
}
