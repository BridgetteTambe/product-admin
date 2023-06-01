package com.bree.com.services;

import com.bree.com.models.Admin;
import com.bree.com.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminService {
    Admin save(Admin admin);

    Admin update(Admin admin);

    void delete(Admin admin);

    void deleteById(String id);

    List<Admin> findAll();

    Page<Admin> findAll(Pageable pageable);

    Admin findById(String id);

    Admin login(String email, String password);
}
