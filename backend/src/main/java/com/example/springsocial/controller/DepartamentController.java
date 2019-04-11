package com.example.springsocial.controller;

import com.example.springsocial.model.Departament;
import com.example.springsocial.payload.ApiResponse;
import com.example.springsocial.payload.NewDepartamentRequest;
import com.example.springsocial.repository.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class DepartamentController {

    @Autowired
    private DepartamentRepository departamentRepository;

    @PostMapping("/newdepartament")
    public ResponseEntity<?> registerUser(@Valid @RequestBody NewDepartamentRequest newDepartamentRequest) {

        Departament departament = new Departament();
        departament.setName(newDepartamentRequest.getName());
        System.out.println(newDepartamentRequest.getName());
        departament.setAbout(newDepartamentRequest.getAbout());
        Departament result = departamentRepository.save(departament);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/newdepartament")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Departament registered successfully@"));
    }
}
