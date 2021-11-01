package com.company.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
public class Student extends Person {
    private UUID studentId;
    private int totalCredits;
    private List<Course> enrolledCourses;

    public Student(String firstName, String lastName, int totalCredits) {
        super(firstName, lastName);
        this.studentId = UUID.randomUUID();
        this.totalCredits = totalCredits;
        this.enrolledCourses=new ArrayList<>();
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", totalCredits=" + totalCredits +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }

    /**
     *
     * @param o class object to compare with
     * @return true if the objects match, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getTotalCredits() == student.getTotalCredits() && getStudentId().equals(student.getStudentId()) && getEnrolledCourses().equals(student.getEnrolledCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getTotalCredits(), getEnrolledCourses());
    }

}
