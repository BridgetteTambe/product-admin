package com.bree.com.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "http://localhost:4200","http://localhost:4201","https://product-admin-view.vercel.app/","https://product-customer-view.vercel.app/"})
public class DefaultResource {

    @GetMapping("")
    public String get(){
        return "PRODUCT ADMIN IS UP AND RUNNING...";
    }
}
