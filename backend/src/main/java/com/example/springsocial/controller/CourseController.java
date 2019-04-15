package com.example.springsocial.controller;

import com.example.springsocial.model.Course;
import com.example.springsocial.payload.ApiResponse;
import com.example.springsocial.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

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

    @GetMapping("/getcourses/{idCourse}")
    public Optional<Course> getCourseById(@PathVariable(value = "idCourse") int id) {
        //Optional<Course> group = courseRepository.findById(id);
        //return group.map(response -> ResponseEntity.ok().body(response))
                //.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        return courseRepository.findById(id);
    }
    @GetMapping("/getcourses")
    public Iterable<Course> contact() {
        return courseRepository.findAll();
    }
}