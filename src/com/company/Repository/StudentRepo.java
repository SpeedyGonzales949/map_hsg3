package com.company.Repository;

import com.company.Model.Student;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class StudentRepo extends InMemoryRepository<Student> {

    public StudentRepo() {
        super();
    }

    @Override
    public Student findOne(@NotNull UUID id) {
        for (Student s:this.repoList //loop through the repo to find the matching id
             ) {
            if(s.getStudentId()==id)
                return s;
        }
        return null;
    }

    @Override
    public Student delete(@NotNull UUID id) {
        for (Student s:this.repoList //loop through the repo to find the matching id
             ) {
            if(s.getStudentId()==id){
                this.repoList.remove(s);
                return s;
            }
        }
        return null;
    }

    @Override
    public Student update(@NotNull Student entity) {
        for (Student s:this.repoList
             ) {
            if(s.getStudentId()==entity.getStudentId()) { //loop through the repo to find the matching entity
                s.setEnrolledCourses(entity.getEnrolledCourses());
                s.setTotalCredits(entity.getTotalCredits());
                s.setFirstName(entity.getFirstName());
                s.setLastName(entity.getLastName());
                return null;
            }
        }
        return entity;
    }

}
