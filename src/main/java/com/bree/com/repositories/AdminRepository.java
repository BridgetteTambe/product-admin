package com.bree.com.repositories;

import com.bree.com.models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {

    Admin findByEmailAndPassword(String email, String Password);

}
