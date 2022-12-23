package com.tbthecoder.studentmgtsystem.service;

import com.tbthecoder.studentmgtsystem.data.dtos.requests.AddGradeRequest;
import com.tbthecoder.studentmgtsystem.data.dtos.requests.AdmitStudentRequest;
import com.tbthecoder.studentmgtsystem.data.dtos.requests.CreateSchoolRequest;
import com.tbthecoder.studentmgtsystem.data.dtos.responses.AddStudentResponse;
import com.tbthecoder.studentmgtsystem.data.dtos.responses.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SchoolServiceImplTest {
    @Autowired
    private SchoolService schoolService;
    Response res;

    @BeforeEach
    void setUp() {
        res = schoolService.createSchool(new CreateSchoolRequest("Test School"));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createSchool() {
        assertEquals(res.message(), "School created successfully");
        assertEquals(1L, schoolService.getNoOfSchools());
        assertEquals(1L, res.schoolId());
    }

    @Test
    void admitStudent() {
        AddStudentResponse resp = schoolService.admitStudent(new AdmitStudentRequest("test firstName",
                "test lastName", res.schoolId()));
        assertEquals(resp.message(), "Student admitted successfully");

        assertEquals(1, schoolService.getNumberOfStudents(res.schoolId()));
    }

    @Test
    void addGrades() {
        schoolService.addGrades(new AddGradeRequest());
    }

    @Test
    void getCourseInfo() {
    }

    @Test
    void getStudentInfo() {
    }
}