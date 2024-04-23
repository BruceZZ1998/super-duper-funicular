package com.bfs.springdatademo.repository;

import com.bfs.springdatademo.domain.Owner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MongoDemoRepo extends MongoRepository<Owner, String> {


}