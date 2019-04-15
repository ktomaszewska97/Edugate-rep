package com.example.springsocial.controller;

import com.example.springsocial.model.CourseRealization;
import com.example.springsocial.model.UserCourseRealization;
import com.example.springsocial.payload.ApiResponse;
import com.example.springsocial.repository.CourseRealizationRepository;
import com.example.springsocial.repository.UserCourseRealizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class UserCourseRealizationController {

    @Autowired
    private UserCourseRealizationRepository userCourseRealizationRepository;

    @PostMapping("/addusercourserealization")
    public ResponseEntity<?> addUserCourseRealization(@Valid @RequestBody UserCourseRealization userCourseRealization){

        UserCourseRealization result = userCourseRealizationRepository.save(userCourseRealization);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/addusercourserealization")
                .buildAndExpand(result.getIdUserCourseRealization()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Course realization registered successfully@"));
    }
}
