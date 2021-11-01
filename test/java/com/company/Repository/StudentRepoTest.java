package com.company.Repository;

import com.company.Model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class StudentRepoTest {
    private StudentRepo repo;//declare some object for tests
    private Student s1,s2,s3,s4;
    @BeforeEach
    void setUp() {
        repo=new StudentRepo();//declare some object for tests
        s1=new Student("Mihnea1","Aleman1", 0);
        s2=new Student("Mihnea2","Aleman2",0);
        s3=new Student("Mihnea3","Aleman3", 0);
        s4=new Student("Mihnea4","Aleman4", 0);


    }

    @Test
    void findOne() {
        repo.save(s1);
        repo.save(s2);
        assert(repo.findOne(s1.getStudentId())==s1);//check for already existing id in repo
        assert(repo.findOne(UUID.randomUUID())==null);//check for not existing id in repo

    }


    @Test
    void save() {
        assert(repo.save(s1)==null);//check for unsaved entity
        assert(repo.save(s1)==s1);//check for already saved entity
        assert(repo.save(s2)==null);//check for unsaved entity
        assert(repo.save(s2)==s2);//check for already saved entity
    }

    @Test
    void delete() {
        repo.save(s1);
        repo.save(s2);
        assert(this.repo.delete(s1.getStudentId())==s1);//check for deleting exisiting object
        assert(this.repo.delete(s2.getStudentId())==s2);
        assert(this.repo.delete(UUID.randomUUID())==null);//check for deleting not existing object
    }

    @Test
    void update() {
        assert repo.update(s1)==s1;//check for updating non existing object
        repo.save(s1);
        s1.setLastName("Ghita");
        assert repo.update(s1)==null;//check for updating exsting object
        assert repo.save(s1)==s1;
        assert repo.update(s2)==s2;
    }

}