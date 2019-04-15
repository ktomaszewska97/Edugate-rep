package com.example.springsocial.controller;

import com.example.springsocial.model.Course;
import com.example.springsocial.model.CourseRealization;
import com.example.springsocial.payload.ApiResponse;
import com.example.springsocial.repository.CourseRealizationRepository;
import com.example.springsocial.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class CourseRealizationController {

    @Autowired
    private CourseRealizationRepository courseRealizationRepository;

    @PostMapping("/addcourserealization")
    public ResponseEntity<?> addFCourseRealization(@Valid @RequestBody CourseRealization courseRealization){

        CourseRealization result = courseRealizationRepository.save(courseRealization);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/addcourserealization")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Course realization registered successfully@"));
    }
}

