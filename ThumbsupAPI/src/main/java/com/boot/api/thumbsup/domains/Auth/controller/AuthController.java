package com.boot.api.thumbsup.domains.Auth.controller;


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
    public SingleResult<String> signin(
    		@ApiParam(value = "ID : 이메일", required = true) @RequestParam String mbId,
           @ApiParam(value = "비밀번호", required = true) @RequestParam String mbPwd
           ) {
    	try {
	        Member member = memberJpaRepo.findByMbId(mbId).orElseThrow(CEmailSigninFailedException::new);
	        
	        if (!passwordEncoder.matches(mbPwd, member.getPassword())) throw new CEmailSigninFailedException();
	        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(member.getMbId()), member.getRoles()));
	        
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	
    	return responseService.getSingleResult("LOGIN ERROR : 암호화 확인필요");
    }
    
	/*
	 * 가입
	 */
    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
    @PostMapping(value = "/signup")
    public CommonResult signup(
    		@ApiParam(value = "회원아이디", required = true) @RequestParam String mbId,
    	    @ApiParam(value = "회원이름", required = true) @RequestParam String mbNm,
    	    @ApiParam(value = "회원비밀번호", required = true) @RequestParam String mbPwd,
    	    @ApiParam(value = "회원생년월일", required = true) @RequestParam String mbRrno,
    	    @ApiParam(value = "회원성별", required = true) @RequestParam String mbGender,
    	    @ApiParam(value = "회원삭제여부", defaultValue= "N") @RequestParam String mbDelyn
    		) {
    	try {
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		String date = format.format (System.currentTimeMillis());
		System.out.println("회원가입 - 현재 날짜 : "+date);
		String mbRegdate = date;
		String mbUpddate = date;
		mbPwd = passwordEncoder.encode(mbPwd);
		System.out.println(mbId);
		System.out.println(mbNm);
		System.out.println(mbPwd);
		System.out.println(mbRrno);
		System.out.println(mbGender);
		System.out.println(mbRegdate);
		System.out.println(mbUpddate);
		System.out.println(mbDelyn);
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
				.roles(Collections.singletonList("ROLE_USER"))
				.build()
		);
		
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	return responseService.getSuccessResult();
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
