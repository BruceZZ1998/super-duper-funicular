package com.bfs.springdatademo.controller;


import com.bfs.springdatademo.domain.Owner;
import com.bfs.springdatademo.domain.Pet;
import com.bfs.springdatademo.service.MongoDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class MongoDemoController {
    private final MongoDemoService service;

    @Autowired
    public MongoDemoController(MongoDemoService service) {
        this.service = service;
    }

    @GetMapping(value = "/owners")

    public List<Owner> getAllOwners() {
        return service.findAllOwners();
    }

    @GetMapping("/owner/{id}")
    public Owner getOwnerByID( @PathVariable String id) {
            return service.findOwnerByID(id);
    }

    @PostMapping("/owner")

    public Owner saveOrUpdateOwner(@RequestBody Owner owner) {
        return service.saveOrUpdateOwner(owner);
    }

    @PutMapping("/owner/{id}/pet")

    public Owner addPetToOwner( @RequestBody Pet pet, @PathVariable String id) {
        return service.addPetByID(pet,id);
    }



    @DeleteMapping("/owner/{id}")
    public ResponseEntity<String> deleteOwnerByID(@PathVariable String id){
        service.deleteOwnerByID(id);
        return new ResponseEntity("successfully", HttpStatus.OK);
    }

}
