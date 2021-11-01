package com.company.Repository;

import com.company.Model.Course;
import com.company.Model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class CourseRepoTest {
    CourseRepo courseRepo; //declare some object for tests
    Course c1,c2;
    @BeforeEach
    void setUp() {
       courseRepo=new CourseRepo(); //initialize  obejcts for test
        c1=new Course("Topologie", new Teacher("Adryel","Hoszu"),30,6);
        c2=new Course("AI", new Teacher("Mihnea","Aleman"),30,6);
    }

    @Test
    void save() {
        assert(courseRepo.save(c1)==null);//check for unsaved entity
        assert(courseRepo.save(c1)==c1);//check for already saved entity
        assert(courseRepo.save(c2)==null);//check for unsaved entity
        assert(courseRepo.save(c2)==c2);//check for already saved entity
    }

    @Test
    void findOne() {
        courseRepo.save(c1);
        courseRepo.save(c2);
        assert(courseRepo.findOne(c1.getId())==c1);//check for already existing id in repo
        assert(courseRepo.findOne(UUID.randomUUID())==null);//check for not existing id in repo
    }

    @Test
    void delete() {
        courseRepo.save(c1);
        courseRepo.save(c2);
        assert(this.courseRepo.delete(c1.getId())==c1);//check for deleting exisiting object
        assert(this.courseRepo.delete(c2.getId())==c2);
        assert(this.courseRepo.delete(UUID.randomUUID())==null);//check for deleting not existing object
    }

    @Test
    void update() {
        assert courseRepo.update(c1)==c1;//check for updating non existing object
        assert courseRepo.update(c2)==c2;

        courseRepo.save(c1);
        c1.setName("Test1");
        assert courseRepo.update(c1)==null;//check for updating exsting object
        assert courseRepo.save(c1)==c1;

        courseRepo.save(c2);
        c2.setName("Test2");
        assert courseRepo.update(c2)==null;
        assert courseRepo.save(c2)==c2;
    }
}