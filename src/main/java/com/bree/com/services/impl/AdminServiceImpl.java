package com.bree.com.services.impl;

import com.bree.com.models.Admin;
import com.bree.com.models.Product;
import com.bree.com.repositories.AdminRepository;
import com.bree.com.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger LOG = LoggerFactory.getLogger(AdminServiceImpl.class);
    private final AdminRepository adminRepository;

    /**
     * @param admin
     * @return
     */
    @Override
    public Admin save(Admin admin) {
        LOG.info("Request to save admin: {}", admin);
        return adminRepository.save(admin);
    }

    /**
     * @param admin
     * @return
     */
    @Override
    public Admin update(Admin admin) {
        LOG.info("Request to update admin: {}", admin);
        return adminRepository.save(admin);
    }

    /**
     * @param admin
     */
    @Override
    public void delete(Admin admin) {
        LOG.info("Request to delete admin: {}", admin);
        adminRepository.delete(admin);
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(String id) {
        LOG.info("Request to delete admin: {}", id);
        adminRepository.deleteById(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Admin findById(String id) {
        LOG.info("Request to find  admin by id: {}", id);
        return this.adminRepository.findById(id).orElse(null);
    }

    /**
     * @return
     */
    @Override
    public List<Admin> findAll() {
        LOG.info("Request to find all admins");
        return adminRepository.findAll();
    }


    public Admin login(String email, String password) {
        return adminRepository.findByEmailAndPassword(email,password);
    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<Admin> findAll(Pageable pageable) {
        LOG.info("Request to find all admins: {}", pageable);
        return adminRepository.findAll(pageable);
    }
}
