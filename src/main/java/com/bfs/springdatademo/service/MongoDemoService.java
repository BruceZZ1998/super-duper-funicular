package com.bfs.springdatademo.service;

import com.bfs.springdatademo.domain.Owner;
import com.bfs.springdatademo.domain.Pet;
import com.bfs.springdatademo.repository.MongoDemoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDemoService {
    private final MongoDemoRepo repository;

    public MongoDemoService(MongoDemoRepo repository) {
        this.repository = repository;
    }

    public Owner findOwnerByID(String id){
        return repository.findById(id).orElse(new Owner());
    }

    public List<Owner> findAllOwners() {
        return repository.findAll();
    }


    public Owner saveOrUpdateOwner(Owner owner) {
        return repository.save(owner);
    }

    public Owner addPetByID(Pet pet, String id){
        Owner owner = repository.findById(id).orElse(new Owner());
        owner.getPets().add(pet);
        return repository.save(owner);
    }

    public void deleteOwnerByID(String id){
        repository.deleteById(id);
    }
}
