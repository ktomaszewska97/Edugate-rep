package com.example.springsocial.controller;

import com.example.springsocial.model.SignedUpForCourse;
import com.example.springsocial.payload.ApiResponse;
import com.example.springsocial.repository.SignedUpForCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class SignedUpForCourseController {

    @Autowired
    private SignedUpForCourseRepository signedUpForCourseRepository;

    @PostMapping("/addsignupforcourse")
    public ResponseEntity<?> addSignUp(@Valid @RequestBody SignedUpForCourse signedUpForCourse) {

        SignedUpForCourse res = signedUpForCourseRepository.save(signedUpForCourse);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/addcourse")
                .buildAndExpand(res.getIdSignedUp()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Success!"));
    }

}