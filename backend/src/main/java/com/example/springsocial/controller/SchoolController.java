package com.example.springsocial.controller;

import com.example.springsocial.model.School;
import com.example.springsocial.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @PostMapping(produces = "application/json")
    public School addSchool(@RequestParam("id") int id, @RequestParam("name") String name,
                            @RequestParam("description") String description, @RequestParam("about") String about){

        School school = new School(id, name, description, about);
        schoolRepository.save(school);

        return school;
    }

    @GetMapping(consumes = "application/json", produces = "application/json", params = "id")
    public School getSchoolById(@RequestParam("id") int id){

        return schoolRepository.findById(id).get();
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    public List<School> getSchools(){

        return schoolRepository.findAll();
    }
}
