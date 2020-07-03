package com.boot.api.thumbsup.domains.brand.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.api.thumbsup.domains.Admin.domain.AdminRepository;
import com.boot.api.thumbsup.domains.Admin.service.AdminService;

@Controller
@RequestMapping("/brand")
public class BrandController {
 
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminRepository adminRepository;
	
    /*
     * 브랜드
     */
  
    
    
}
