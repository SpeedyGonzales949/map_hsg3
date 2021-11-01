package com.company.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Teacher extends Person{
    private List<Course> courses;
    private UUID id;
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
        this.id=UUID.randomUUID();
        this.courses=new ArrayList<>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "courses=" + courses +
                ", id=" + id +
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
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return getCourses().equals(teacher.getCourses()) && getId().equals(teacher.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourses(), getId());
    }
}
