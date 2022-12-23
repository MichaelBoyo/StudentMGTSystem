package com.tbthecoder.studentmgtsystem.service;

import com.tbthecoder.studentmgtsystem.data.dtos.requests.AddGradeRequest;
import com.tbthecoder.studentmgtsystem.data.dtos.requests.AdmitStudentRequest;
import com.tbthecoder.studentmgtsystem.data.dtos.requests.CreateSchoolRequest;
import com.tbthecoder.studentmgtsystem.data.dtos.responses.AddStudentResponse;
import com.tbthecoder.studentmgtsystem.data.dtos.responses.CourseInfo;
import com.tbthecoder.studentmgtsystem.data.dtos.responses.Response;
import com.tbthecoder.studentmgtsystem.data.dtos.responses.StudentInfo;
import com.tbthecoder.studentmgtsystem.data.models.School;
import com.tbthecoder.studentmgtsystem.data.models.Student;
import com.tbthecoder.studentmgtsystem.data.repository.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;

    @Override
    public Response createSchool(CreateSchoolRequest request) {
        School school = School.builder()
                .name(request.name())
                .build();
        schoolRepository.saveAndFlush(school);
        return new Response("School created successfully", school.getId());
    }

    @Override
    public AddStudentResponse admitStudent(AdmitStudentRequest request) {
        Student student = Student.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();
        School school = schoolRepository.findById(request.schoolId()).orElseThrow(
                () -> new RuntimeException("School not found")
        );
        school.getStudents().add(student);
        schoolRepository.saveAndFlush(school);
        return new AddStudentResponse("Student admitted successfully", student.getId());
    }

    @Override
    public Response addGrades(AddGradeRequest request) {
        return null;
    }

    @Override
    public CourseInfo getCourseInfo(String courseName) {
        return null;
    }

    @Override
    public StudentInfo getStudentInfo(String studentName) {
        return null;
    }

    @Override
    public Long getNoOfSchools() {
        return  schoolRepository.count();
    }

    @Override
    public long getNumberOfStudents(Long schoolId) {
        return schoolRepository.findById(schoolId).orElseThrow(
                () -> new RuntimeException("School not found")
        ).getStudents().size();
    }
}
