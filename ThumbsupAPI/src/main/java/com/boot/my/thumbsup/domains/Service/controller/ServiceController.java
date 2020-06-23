package com.boot.my.thumbsup.domains.Service.controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.my.thumbsup.Common.Service.JwtService;
import com.boot.my.thumbsup.domains.Admin.domain.AdminRepository;
import com.boot.my.thumbsup.domains.Admin.service.AdminService;
import com.boot.my.thumbsup.domains.Service.service.ServiceService;

@Controller
@RequestMapping("/service")
public class ServiceController {
	 
	@Autowired
	UserDetailsService userService;
	@Autowired
	ServiceService serviceService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	JwtService jwtService;
	
	/*
	 * 직원 로그인 -- 직원인증 후 토큰생성, 토큰리턴
	 */
    @RequestMapping("/auth")
    public ResponseEntity<String> auth(
    		@RequestBody MultiValueMap<String, String> map,
    		HttpServletRequest request,
            HttpServletResponse response,
            Authentication auth
            ) {
    	System.out.println("API Server --- tuLogin");
    	System.out.println("API Server --- getName   :::::   "+map.getClass().getName());
    	System.out.println("API Server --- getTypeName   :::::   "+map.getClass().getTypeName());
    	String user_auth = "";
    	
    	System.out.println("API Server --- map   :::::   "+map);
    	System.out.println("API Server --- map.id   :::::   "+map.get("id"));
    	System.out.println("API Server --- map.pwd   :::::   "+map.get("pwd"));
    	String id = map.get("id").toString();
    	id = serviceService.strSplitData(id);
    	System.out.println("@@@@@@@@@@@id : "+id);
    	
    	try {
    		UserDetails userLogin = userService.loadUserByUsername(id);
    		user_auth = userLogin.getAuthorities().toString();

        	System.out.println("API Server --- user_auth   :::::   "+user_auth);
        	/*
    		 * System.out.println("로그인 성공, 권한 : " + user_auth); Map<String, Object> value =
    		 * jwtService.get("TUK"); System.out.println("------------------------------");
    		 * System.out.println(value);
    		 * System.out.println("------------------------------");
    		 */
        	if(user_auth.equals("[ROLE_ADMIN]")) {
        		
            	
        		System.out.println("로그인 성공, 권한 : " + user_auth);
        		
            	String token = jwtService.create("TUK", id, "ADMINLOGIN");
            	System.out.println("-- Controller Token -- ");
        		System.out.println("--------------token----------------");
        		System.out.println(token);
        		System.out.println("--------------token----------------");
        		
    	        return new ResponseEntity<String>(token, HttpStatus.OK); 
    	        
    	    } else {
    	    	System.out.println("일반회원인가? 일단 admin권한이 아님!");
    	    	return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    	    }
    	} catch(UsernameNotFoundException e) {
    		System.out.println("직원정보를 찾을 수 없습니다.");
    		return new ResponseEntity<String>("no_data", HttpStatus.OK);
    	}
    	
    	/*
    	 * 
    	if(user_auth.equals("[ROLE_ADMIN]")) {
    		System.out.println("admin");
    		msg = "admin1";
    		return msg;
    		
    	} else if(user_auth.equals("[ROLE_MEMBER]")) {
    		System.out.println("member");
    		msg = "member1";
    		return msg;
    		
    	} else {
    		System.out.println("else....");
    		msg = "else1";
    		return msg;
    	}
    	*/
    }
    

}
