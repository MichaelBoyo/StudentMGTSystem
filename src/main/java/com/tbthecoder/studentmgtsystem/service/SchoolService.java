package com.tbthecoder.studentmgtsystem.service;

import com.tbthecoder.studentmgtsystem.data.dtos.requests.AddGradeRequest;
import com.tbthecoder.studentmgtsystem.data.dtos.requests.AdmitStudentRequest;
import com.tbthecoder.studentmgtsystem.data.dtos.requests.CreateSchoolRequest;
import com.tbthecoder.studentmgtsystem.data.dtos.responses.AddStudentResponse;
import com.tbthecoder.studentmgtsystem.data.dtos.responses.CourseInfo;
import com.tbthecoder.studentmgtsystem.data.dtos.responses.Response;
import com.tbthecoder.studentmgtsystem.data.dtos.responses.StudentInfo;

public interface SchoolService {
    Response createSchool(CreateSchoolRequest request);
    AddStudentResponse admitStudent(AdmitStudentRequest request);

    Response addGrades(AddGradeRequest request);

    CourseInfo getCourseInfo(String courseName);
    StudentInfo getStudentInfo(String studentName);

    Long getNoOfSchools();

    long getNumberOfStudents(Long schoolId);
}
