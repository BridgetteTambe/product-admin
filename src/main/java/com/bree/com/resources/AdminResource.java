package com.bree.com.resources;

import com.bree.com.models.Admin;
import com.bree.com.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200/", "http://localhost:4200","http://localhost:4201","https://product-admin-view.vercel.app/","https://product-customer-view.vercel.app/"})
public class AdminResource {
    private static final Logger LOG = LoggerFactory.getLogger(AdminResource.class);

    private final AdminService adminService;

    @PostMapping("/admins")
    public ResponseEntity<Admin> save(@RequestBody Admin admin) throws Exception {
        LOG.info("Rest Request to save admin : {}", admin);
        if (admin.getId() != null) {
            throw new Exception("Can not create new admin with id." + admin.getId());
        }
        Admin save = this.adminService.save(admin);
        return ResponseEntity.ok(save);
    }

    @PutMapping("/admins")
    public ResponseEntity<Admin> update(@RequestBody Admin admin) throws Exception {
        LOG.info("Rest Request to update admin : {}", admin);
        if (admin.getId() == null) {
            throw new Exception("Can not update admin with id.null");
        }
        Admin save = this.adminService.update(admin);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/admins")
    public ResponseEntity delete(@RequestBody Admin admin) throws Exception {
        LOG.info("Rest Request to delete admin : {}", admin);
        if (admin.getId() == null) {
            throw new Exception("Can not delete admin with id.null");
        }
        this.adminService.delete(admin);
        return ResponseEntity.ok(HttpStatus.resolve(200));
    }

    @DeleteMapping("/admins/{id}")
    public ResponseEntity deleteById(@PathVariable String id) throws Exception {
        LOG.info("Rest Request to delete admin by id : {}", id);
        if (id == null) {
            throw new Exception("Can not delete admin with id.null");
        }
        this.adminService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.resolve(200));
    }

    @GetMapping("/admins/{id}")
    public ResponseEntity<Admin> findById(@PathVariable String id) throws Exception {
        LOG.info("Rest Request to find all admin");
        Admin admin = this.adminService.findById(id);
        return ResponseEntity.ok(admin);
    }
    @GetMapping("/admins")
    public ResponseEntity<List<Admin>> findAll() throws Exception {
        LOG.info("Rest Request to find all admin");
        List<Admin> all = this.adminService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/admin/Login/{email}/{password}")
    public Admin getEmailAndUsername(@PathVariable String email, @PathVariable String password) {
        LOG.info("Rest request to get email and password: {} {}", email, password);
        Admin customer = adminService.login(email, password);
        if (ObjectUtils.isEmpty(customer)) {
            throw new RuntimeException("Invalid email or password!");
        }
        return customer;
    }



    @GetMapping("/admins/pageable")
    public ResponseEntity<Page<Admin>> findAll(Pageable pageable) throws Exception {
        LOG.info("Rest Request to find all admin by pageable : {} ", pageable);
        Page<Admin> all = this.adminService.findAll(pageable);
        return ResponseEntity.ok(all);
    }
}
