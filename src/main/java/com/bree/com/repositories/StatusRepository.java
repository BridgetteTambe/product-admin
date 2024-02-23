package com.bree.com.repositories;

import com.bree.com.models.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StatusRepository extends MongoRepository<Status, Long> {
    List<Status> findByName(String name);
}
