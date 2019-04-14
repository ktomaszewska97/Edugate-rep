package com.example.springsocial.controller;

import com.example.springsocial.model.Departament;
import com.example.springsocial.payload.ApiResponse;
import com.example.springsocial.payload.NewDepartamentRequest;
import com.example.springsocial.repository.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class DepartamentController {

    @Autowired
    private DepartamentRepository departamentRepository;

    @PostMapping("/newdepartament")
    public ResponseEntity<?> registerDepartament(@Valid @RequestBody Departament departament) {

        //Departament departament = new Departament();
        //departament.setName(newDepartamentRequest.getName());
        //departament.setAbout(newDepartamentRequest.getAbout());
        Departament result = departamentRepository.save(departament);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/newdepartament")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "Departament registered successfully@"));
    }

    @RequestMapping("/getdepartament")
    public String index(Model model) {
        List<Departament> departaments = (List<Departament>) departamentRepository.findAll();
        model.addAttribute("departaments", departaments);
        return "departaments";
    }


}