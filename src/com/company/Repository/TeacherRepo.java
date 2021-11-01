package com.company.Repository;

import com.company.Model.Teacher;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class TeacherRepo extends InMemoryRepository<Teacher>{
    public TeacherRepo() {
        super();
    }

    @Override
    public Teacher findOne(@NotNull UUID id) {//loop through the repo to find the matching id
        for (Teacher t:this.repoList
             ) {
            if (t.getId()==id)
                return t;
        }
        return null;
    }

    @Override
    public Teacher delete(@NotNull UUID id) {//loop through the repo to find the matching id
        for (Teacher t:this.repoList
             ) {
            if(t.getId()==id){
                this.repoList.remove(t);
                return t;
            }
        }
        return null;
    }


    @Override
    public Teacher update(@NotNull Teacher entity) { //loop through the repo to find the matching entity
        for (Teacher t:this.repoList
             ) {
            if (t.getId()==entity.getId()){
                t.setLastName(entity.getLastName());
                t.setFirstName(entity.getFirstName());
                t.setCourses(entity.getCourses());
                return null;
            }


        }
        return entity;
    }
}
