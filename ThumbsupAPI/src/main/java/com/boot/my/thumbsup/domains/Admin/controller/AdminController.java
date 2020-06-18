package com.boot.my.thumbsup.domains.Admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.my.thumbsup.domains.Admin.domain.AdminRepository;
import com.boot.my.thumbsup.domains.Admin.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
 
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminRepository adminRepository;
	
    /*
     * 관리자페이지 index
     */
  
    
    
}
