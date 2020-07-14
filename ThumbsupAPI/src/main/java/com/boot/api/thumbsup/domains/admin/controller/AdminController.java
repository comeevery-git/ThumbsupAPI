package com.boot.api.thumbsup.domains.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.api.thumbsup.domains.admin.domain.AdminJpaRepo;

@Controller
@RequestMapping("/admin")
public class AdminController {
 
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private AdminJpaRepo adminJpaRepo;
	
    /*
     * 관리자페이지 index
     */
  
    
    
}
