package com.tbthecoder.studentmgtsystem.controller;

import com.tbthecoder.studentmgtsystem.data.dtos.requests.CreateSchoolRequest;
import com.tbthecoder.studentmgtsystem.service.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/school")
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    public ResponseEntity<?> createSchool(@RequestBody CreateSchoolRequest request) {
        return ResponseEntity.ok(schoolService.createSchool(request));
    }

    @GetMapping
    public ResponseEntity<?> getNoOfSchools() {
        return ResponseEntity.ok(schoolService.getNoOfSchools());
    }
}
