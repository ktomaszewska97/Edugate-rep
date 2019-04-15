package com.example.springsocial.controller;

import com.example.springsocial.model.Course;
import com.example.springsocial.payload.ApiResponse;
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
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/addcourse")
    public ResponseEntity<?> addFCourse(@Valid @RequestBody Course course){

        Course result = courseRepository.save(course);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/addcourse")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Course registered successfully@"));
    }
}
