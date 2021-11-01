package com.company.Repository;

import com.company.Model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class TeacherRepoTest {

    private TeacherRepo teacherRepo;//declare some object for tests
    private Teacher t1,t2;
    @BeforeEach
    void setUp() {
        teacherRepo=new TeacherRepo(); //initialize  obejcts for test
        t1 = new Teacher("John1", "Doe1");
        t2 = new Teacher("John2", "Doe2");


    }
    @Test
    void save() {
        assert(teacherRepo.save(t1)==null);//check for unsaved entity
        assert(teacherRepo.save(t1)==t1);//check for already saved entity
        assert(teacherRepo.save(t2)==null);//check for unsaved entity
        assert(teacherRepo.save(t2)==t2);//check for already saved entity
    }

    @Test
    void findOne() {
        teacherRepo.save(t1);
        teacherRepo.save(t2);
        assert(teacherRepo.findOne(t1.getId())==t1);//check for already existing id in repo
        assert(teacherRepo.findOne(UUID.randomUUID())==null);//check for not existing id in repo

    }

    @Test
    void delete() {
        teacherRepo.save(t1);
        teacherRepo.save(t2);
        assert(this.teacherRepo.delete(t1.getId())==t1);//check for deleting exisiting object
        assert(this.teacherRepo.delete(t2.getId())==t2);
        assert(this.teacherRepo.delete(UUID.randomUUID())==null);//check for deleting not existing object
    }

    @Test
    void update() {
        assert teacherRepo.update(t1)==t1;//check for updating non existing object
        assert teacherRepo.update(t2)==t2;

        teacherRepo.save(t1);
        t1.setLastName("Ghita1");
        assert teacherRepo.update(t1)==null;//check for updating exsting object
        assert teacherRepo.save(t1)==t1;


        teacherRepo.save(t2);
        t1.setLastName("Ghita2");
        assert teacherRepo.update(t2)==null;
        assert teacherRepo.save(t2)==t2;




    }
}