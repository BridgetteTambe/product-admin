package com.bree.com.services;

import com.bree.com.models.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StatusService {
    List<Status> findByName(String name);
    Status save(Status status) throws Exception;

    Page<Status> findAll(Pageable pageable);
    Status findById(Long id);

    void delete(Status status);
}
