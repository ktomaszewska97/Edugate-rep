package com.example.springsocial.controller;

import com.example.springsocial.model.FieldOfStudy;
import com.example.springsocial.payload.ApiResponse;
import com.example.springsocial.repository.FieldOfStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.net.URI;

@RestController
public class FieldOfStudyController {

    @Autowired
    private FieldOfStudyRepository fieldOfStudyRepository;

    @PostMapping("/addfield")
    public ResponseEntity<?> addFieldOfStudy(@Valid @RequestBody FieldOfStudy fieldOfStudy){

        FieldOfStudy result = fieldOfStudyRepository.save(fieldOfStudy);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/addfield")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "FieldOfStudy registered successfully@"));
    }
//
//    @GetMapping(consumes = "application/json", produces = "application/json", params = "id")
//    public FieldOfStudy getFieldOfStudyById(@RequestParam("id") int id){
//
//        return fieldOfStudyRepository.findById(id).get();
//    }
//
//    @GetMapping(consumes = "application/json", produces = "application/json")
//    public List<FieldOfStudy> getFieldOfStudy(){
//
//        return fieldOfStudyRepository.findAll();
//    }
}
