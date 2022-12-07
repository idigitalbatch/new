package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Admin;
import com.example.servises.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AdminController {
    
    
private AdminService adminService;
    
    public AdminController(AdminService adminService) {
        super();
        this.adminService = adminService;
    }



   
        
    //http://localhost:8080/api/v1/addcustomers
    @PostMapping("/addadmin")
    public ResponseEntity<Admin>saveAdmin(@Valid @RequestBody Admin admin) {
        return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);
        
    }
    
    
    @GetMapping("/getalladmins")
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }
    
    @GetMapping("/getadmin/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") long adminId){
        return new ResponseEntity<Admin>(adminService.getAdminById(adminId), HttpStatus.OK);
        
    }
    
    @PutMapping("/updateadmin/{id}")
    public ResponseEntity<Admin> updateAdmin(@Valid @PathVariable("id")long id ,@RequestBody Admin admin){
        return new ResponseEntity<Admin>(adminService.updateAdmin(admin, id), HttpStatus.OK);
        



}
}
