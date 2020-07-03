package com.boot.api.thumbsup.domains.Login.controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boot.api.thumbsup.common.service.JwtService;
import com.boot.api.thumbsup.domains.Admin.domain.Admin;
import com.boot.api.thumbsup.domains.Admin.domain.AdminRepository;
import com.boot.api.thumbsup.domains.Admin.service.AdminService;

@Controller
@RequestMapping("/login")
public class LoginController {
 
	@Autowired
	UserDetailsService userService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	JwtService jwtService;
	
	/*
	 * 직원 로그인
	 */
    @GetMapping("/admin_login")
    public String main(Model model) {
    	return "login/admin_login";
    }
    @RequestMapping(value="/userLogin")
    public ModelAndView userLogin(
    		ModelAndView mv,
    		@RequestParam String id,
    		HttpServletRequest request,
            HttpServletResponse response,
            Authentication auth
            ) {
    	UserDetails userLogin = userService.loadUserByUsername(id);

    	//System.out.println(userLogin.getAuthorities());
    	//System.out.println(userLogin.getAuthorities().toString());
    	//System.out.println(userLogin.getUsername());
    	//System.out.println(userLogin.getPassword());
    	
    	String user_auth = userLogin.getAuthorities().toString();
		
    	
    	/*
		 * System.out.println("로그인 성공, 권한 : " + user_auth); Map<String, Object> value =
		 * jwtService.get("TUK"); System.out.println("------------------------------");
		 * System.out.println(value);
		 * System.out.println("------------------------------");
		 */
  	   
    	if(user_auth.equals("[ROLE_ADMIN]")) {
    		System.out.println("admin");
    		mv.setViewName("redirect:/admin/admin_index");
    		return mv;
    		
    	} else if(user_auth.equals("[ROLE_MEMBER]")) {
    		System.out.println("member");
    		mv.setViewName("redirect:/index");
    		return mv;
    		
    	} else {
    		System.out.println("else....");
    		mv.setViewName("redirect:/login/admin_login");
    		return mv;
    	}
     
    }
    
    
    
    
    
    
    /*
     * 직원가입
     */
    @RequestMapping(value="/admin_register")
    public ModelAndView admin_register(@ModelAttribute Admin admin,
    		HttpServletRequest request
    		) {
    	return new ModelAndView("login/admin_register");
    }
    @RequestMapping(value="/adminInsert")
    public ModelAndView adminInsert(@Validated Admin admin,
    		HttpServletRequest request,
            HttpServletResponse response
            ) {
    	//System.out.println("admin: " + admin);
    	//System.out.println("---------------------> " + request.getParameter("adminId"));
    	String data = request.getParameter("adminId");
    	String encodePassword = passwordEncoder.encode(request.getParameter("adminPwd"));
    	String localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    	String adminToken = jwtService.create("TUK", data, "SIGNUP");
    	System.out.println("-- Controller Token -- " +adminToken);
    	admin.setAdminPwd(encodePassword);
    	admin.setAdminRegdate(localDate);
    	admin.setAdminToken(adminToken);
    	
 	    adminRepository.save(admin);

 	    /*
 	   Map<String, Object> value =   jwtService.get("TUK");
 	   System.out.println("------------------------------");
 	   System.out.println(value);
 	   System.out.println("------------------------------");
    	*/
    	return new ModelAndView("login/admin_login");
    }
    
    
    
    
    /*
     * 비밀번호 찾기
     */
    @GetMapping("/admin_forget_pwd")
    public String admin_forget_pwd(Model model) {
    	return "login/admin_forget_pwd";
    }
    
}
