package com.example.servises;

import java.util.List;

import com.example.model.Admin;

public interface AdminService {



		   Admin saveAdmin(Admin admin);



		   List<Admin> getAllAdmins();



		   Admin getAdminById(long id);



		   Admin updateAdmin(Admin admin, long id);



		}
