package com.company.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Course {
    private String name;
    private Person teacher;
    private int maxEnrollment;
    private int credits;
    private List<Student> studentsEnrolled;
    private UUID id;

    public Course(String name, Person teacher, int maxEnrollment, int credits) {
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollment = maxEnrollment;
        this.credits = credits;
        this.studentsEnrolled= new ArrayList<>();
        this.id=UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<com.company.Model.Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<com.company.Model.Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                ", maxEnrollment=" + maxEnrollment +
                ", credits=" + credits +
                ", studentsEnrolled=" + studentsEnrolled +
                ", id=" + id +
                '}';
    }
}
