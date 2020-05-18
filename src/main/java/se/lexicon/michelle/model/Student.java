package se.lexicon.michelle.model;

import java.util.Objects;

public class Student {
    private final int STUDENT_ID;
    private String name,
                    email,
                    address;

    /**
     * Student constructor
     * @param studentId int
     * @param name String
     * @param email String
     * @param address String
     */
    public Student(int studentId, String name, String email, String address) {
        this.STUDENT_ID = studentId;
        setName(name);
        setEmail(email);
        setAddress(address);
    }


    /**
     * returns the students id
     * @return int
     */
    public int getStudentId() {
        return STUDENT_ID;
    }

    /**
     * returns the students name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the students name
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the students email
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the students email
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * returns the students address
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the students address
     * @param address String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * overrides equals
     * @param o object
     * @return boolean
     */
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

    /**
     * overrides hashcode
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(STUDENT_ID, name, email, address);
    }
}
