package com.boot.api.thumbsup.domains.auth.controller;


import java.text.SimpleDateFormat;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.api.thumbsup.common.config.JwtTokenProvider;
import com.boot.api.thumbsup.common.exception.CEmailSigninFailedException;
import com.boot.api.thumbsup.common.model.CommonResult;
import com.boot.api.thumbsup.common.model.SingleResult;
import com.boot.api.thumbsup.common.service.ResponseService;
import com.boot.api.thumbsup.domains.admin.domain.Admin;
import com.boot.api.thumbsup.domains.admin.domain.AdminJpaRepo;
import com.boot.api.thumbsup.domains.auth.domain.RSPAUTH001;
import com.boot.api.thumbsup.domains.auth.domain.RSPAUTH002;
import com.boot.api.thumbsup.domains.auth.domain.RSPAUTH003;
import com.boot.api.thumbsup.domains.member.domain.Member;
import com.boot.api.thumbsup.domains.member.domain.MemberJpaRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@Api(tags = {"0. Auth"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private MemberJpaRepo memberJpaRepo;
	@Autowired
	private AdminJpaRepo adminJpaRepo;
	
	@Autowired
    private JwtTokenProvider jwtTokenProvider;
	@Autowired
    private ResponseService responseService;
	@Autowired
    private PasswordEncoder passwordEncoder;
    
	/*
	 * 로그인
	 */
    @ApiOperation(value = "로그인", notes = "이메일 로그인을 한다.")
    @PostMapping(value = "/signin")
    public RSPAUTH003 signin(
    		RSPAUTH003 req,
    		@ApiParam(value = "ID : 이메일", required = true) @RequestParam String mbId,
    		@ApiParam(value = "비밀번호", required = true) @RequestParam String mbPwd
           ) {
    	try {
    		//해당 유저 확인
	        Member member = memberJpaRepo.findByMbId(mbId).orElseThrow(CEmailSigninFailedException::new);
	        if (!passwordEncoder.matches(mbPwd, member.getPassword())) throw new CEmailSigninFailedException();
	        
	        //토큰 생성
	        String memberToken = jwtTokenProvider.createToken(String.valueOf(member.getMbId()), member.getRoles());
	        String memberRole = member.getRoles().toString();
	        
	        //응답보낼 데이터 세팅
	        req.setMbIdx(member.getMbIdx());
	        req.setMbId(member.getMbId());
	        req.setMbNm(member.getMbNm());
	        req.setMbTel(member.getMbTel());
	        req.setMemberToken(memberToken);
	        req.setMemberRole(memberRole);
	        req.setSuccess("success");
    		
	        System.out.println(" :::::::::::::::::::::::::::::::::: " +req.getMemberToken()); 
	        
	        return req;
	        
    	} catch (Exception e) {
    		System.out.println(e);
    		req.setSuccess("fail");
    		req.setMsg("api server error");
    	}
    	
    	return req;
	        //return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(member.getMbId()), member.getRoles()));
    		//return responseService.getSingleResult("LOGIN ERROR : 암호화 확인필요");
    }
    
	/*
	 * 가입
	 */
    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
    @PostMapping(value = "/signup")
    public RSPAUTH002 signup(
    		RSPAUTH002 req,
    		@ApiParam(value = "회원아이디", required = true) @RequestParam String mbId,
    	    @ApiParam(value = "회원이름", required = true) @RequestParam String mbNm,
    	    @ApiParam(value = "회원비밀번호", required = true) @RequestParam String mbPwd,
    	    @ApiParam(value = "회원생년월일", required = true) @RequestParam String mbRrno,
    	    @ApiParam(value = "회원성별", required = true) @RequestParam String mbGender
    		) {
    	try {
			SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
			String date = format.format (System.currentTimeMillis());
			System.out.println("회원가입 - 현재 날짜 : "+date);
			String mbRegdate = date;
			String mbUpddate = date;
			String mbDelyn = "N";
			mbPwd = passwordEncoder.encode(mbPwd);
			System.out.println(mbId);
			System.out.println(mbNm);
			System.out.println(mbPwd);
			System.out.println(mbRrno);
			System.out.println(mbGender);
			System.out.println(mbRegdate);
			System.out.println(mbUpddate);
			System.out.println("==========");
			
			
			memberJpaRepo.save(
				Member.builder()
					.mbId(mbId)
					.mbNm(mbNm)
					.mbPwd(mbPwd)
					.mbRrno(mbRrno)
					.mbGender(mbGender)
					.mbRegdate(mbRegdate)
					.mbUpddate(mbUpddate)
					.mbDelyn(mbDelyn)
					.roles(Collections.singletonList("ROLE_MEMBER"))
					.build()
			);
			req.setSuccess("success");
			return req;
		
    	} catch (Exception e) {
    		System.out.println(e);
    		req.setSuccess("fail");
    		req.setMsg("api server error");
    	}
    	//return responseService.getSuccessResult();
    	return req;
   }

    
    /*
	 * 직원 로그인
	 */
    @ApiOperation(value = "직원 로그인", notes = "이메일 로그인을 한다.")
    @PostMapping(value = "/signin_m")
    public RSPAUTH001 signin_m(
    		RSPAUTH001 req,
    		@ApiParam(value = "ID : 이메일", required = true) @RequestParam String adminId,
            @ApiParam(value = "비밀번호", required = true) @RequestParam String adminPwd
           ) {
    	
    	try {
    		//해당유저 확인
	        Admin admin = adminJpaRepo.findByAdminId(adminId).orElseThrow(CEmailSigninFailedException::new);
	        
	        //암호확인
	        if (!passwordEncoder.matches(adminPwd, admin.getPassword())) throw new CEmailSigninFailedException();
	        
	        //권한확인
	        //String role = adminJpaRepo.selectAdminRole(admin.getAdmin_idx());
	        
	        //jwt 토큰생성
	        //return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(admin.getAdminId()), admin.getRoles()));
	        String adminToken = jwtTokenProvider.createToken(String.valueOf(admin.getAdminId()), admin.getRoles());
	        String adminRole = admin.getRoles().toString();
	        
	        //응답보낼 데이터 세팅
	        req.setAdmin_idx(admin.getAdmin_idx());
	        req.setAdminId(admin.getAdminId());
	        req.setAdminNm(admin.getAdminNm());
	        req.setAdminUseyn(admin.getAdminUseyn());
	        req.setAdminToken(adminToken);
	        req.setAdminRole(adminRole);
	        req.setSuccess("success");
    		
	        System.out.println(" :::::::::::::::::::::::::::::::::: " +req.getAdminToken()); 
	        
	        return req;
	        
    	} catch (Exception e) {
    		System.out.println(e);
    		req.setSuccess("fail");
    		req.setMsg("api server error");
    	}
    	//return responseService.getSingleResult("LOGIN ERROR : 암호화 확인필요");
    	return req;
    }
    
	/*
	 * 직원가입
	 */
    @ApiOperation(value = "직원가입", notes = "회원가입을 한다.")
    @PostMapping(value = "/signup_m")
    public RSPAUTH002 signup_m(
    		@ApiParam(value = "직원아이디", required = true) @RequestParam String adminId,
    	    @ApiParam(value = "직원이름", required = true) @RequestParam String adminNm,
    	    @ApiParam(value = "직원비밀번호", required = true) @RequestParam String adminPwd,
    	    @ApiParam(value = "직원생년월일", required = true) @RequestParam String adminRrno,
    	    @ApiParam(value = "직원전화번호", required = true) @RequestParam String adminTel,
    	    @ApiParam(value = "직원부서", required = true) @RequestParam String adminDepart,
    	    RSPAUTH002 req
    		) {
    	try {
    		
			SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
			String date = format.format (System.currentTimeMillis());
			System.out.println("직원가입 - 현재 날짜 : "+date);
			String adminRegdate = date;
			String adminUpddate = date;
			adminPwd = passwordEncoder.encode(adminPwd);
			System.out.println(adminId);
			System.out.println(adminNm);
			System.out.println(adminPwd);
			System.out.println(adminRrno);
			System.out.println(adminTel);
			System.out.println(adminDepart);
			System.out.println("==========");
			
			adminJpaRepo.save(
				Admin.builder()
					.adminId(adminId)
					.adminNm(adminNm)
					.adminPwd(adminPwd)
					.adminRrno(adminRrno)
					.adminTel(adminTel)
					.adminDepart(adminDepart)
					.adminRegdate(adminRegdate)
					.adminUpddate(adminUpddate)
					.roles(Collections.singletonList("ROLE_ADMIN"))
					.build()
				);
			
			req.setSuccess("success");
		
    	} catch (Exception e) {
    		System.out.println(e);
    		req.setSuccess("fail");
    		req.setMsg("api server error");
    	}
    	//return responseService.getSuccessResult();
    	return req;
   }
//return responseService.getSingleResult(memberJpaRepo.save(member));

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 직원 로그인
	
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
     */
    
    
    
    
    
    /*
     * 직원가입
     
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
    	return new ModelAndView("login/admin_login");
    }
    */
    
    
    
    /*
     * 비밀번호 찾기
     */
    @GetMapping("/admin_forget_pwd")
    public String admin_forget_pwd(Model model) {
    	return "login/admin_forget_pwd";
    }
    
}
