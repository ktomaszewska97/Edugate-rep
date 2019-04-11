package com.example.springsocial.controller;

import com.example.springsocial.model.Departament;
import com.example.springsocial.repository.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departament")
public class DepartamentController {

    @Autowired
    private DepartamentRepository departamentRepository;

    @PostMapping(produces = "application/json")
    public Departament addDepartament(@RequestParam("id") int id, @RequestParam("schoolID") int schoolID,
                            @RequestParam("name") String name, @RequestParam("about") String about){

        Departament departament = new Departament(id, schoolID, name, about);
        departamentRepository.save(departament);

        return departament;
    }

    @GetMapping(consumes = "application/json", produces = "application/json", params = "id")
    public Departament getDepartamentById(@RequestParam("id") int id){

        return departamentRepository.findById(id).get();
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    public List<Departament> getDepartaments(){

        return departamentRepository.findAll();
    }
}