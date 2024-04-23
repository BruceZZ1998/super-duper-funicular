package com.bfs.springdatademo;

import com.bfs.springdatademo.domain.Owner;
import com.bfs.springdatademo.domain.Pet;
import com.bfs.springdatademo.service.MongoDemoService;
import org.springframework.boot.SpringApplication;

public class Driver {
    private MongoDemoService service;
    public static void main(String[] args) {


        Owner owner = Owner.builder().name("bruce").build();
        Pet pet1 = Pet.builder().name("moki").species("rabbit").build();
        Pet pet2 = Pet.builder().name("buddy").species("dog").build();
        owner.getPets().add(pet1);
        owner.getPets().add(pet2);
        System.out.println("hello world");

    }
}
