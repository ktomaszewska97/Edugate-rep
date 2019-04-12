package com.example.springsocial.controller;

import com.example.springsocial.model.School;
import com.example.springsocial.payload.ApiResponse;
import com.example.springsocial.payload.NewSchoolRequest;
import com.example.springsocial.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @PostMapping("/newschool")
    public ResponseEntity<?> registerSchool(@Valid @RequestBody NewSchoolRequest newSchoolRequest) {

        School school = new School();
        school.setName(newSchoolRequest.getName());
        school.setAbout(newSchoolRequest.getAbout());
        school.setDescription(newSchoolRequest.getDescription());

        School result = schoolRepository.save(school);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/newschool")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "School registered successfully@"));
    }
}