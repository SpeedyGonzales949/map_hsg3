package com.company.Repository;

import com.company.Model.Course;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class CourseRepo extends InMemoryRepository<Course>{
    public CourseRepo() {
        super();
    }

    @Override
    public Course findOne(@NotNull UUID id) {//loop through the repo to find the matching id
        for(Course c:this.repoList){
            if(c.getId()==id)
                return c;
        }
        return null;
    }

    @Override
    public Course delete(@NotNull UUID id) {//loop through the repo to find the matching id
        for (Course c:this.repoList
             ) {
            if(c.getId()==id){
                this.repoList.remove(c);
                return c;
            }
        }
        return null;
    }

    @Override
    public Course update(@NotNull Course entity) { //loop through the repo to find the matching entity
        for (Course c:this.repoList
             ) {
            if (c.getId()==entity.getId()){
                c.setCredits(entity.getCredits());
                c.setMaxEnrollment(entity.getMaxEnrollment());
                c.setName(entity.getName());
                c.setTeacher(entity.getTeacher());
                c.setStudentsEnrolled(entity.getStudentsEnrolled());
                return null;
            }
        }
        return entity;
    }
}
