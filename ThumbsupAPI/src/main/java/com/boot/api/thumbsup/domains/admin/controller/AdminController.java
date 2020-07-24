package com.boot.api.thumbsup.domains.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
   // @Autowired
   // private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	//@Autowired
	//private AdminJpaRepo adminJpaRepo;
	//@Autowired
	//private BoardJpaRepo boardJpaRepo;


    
}
