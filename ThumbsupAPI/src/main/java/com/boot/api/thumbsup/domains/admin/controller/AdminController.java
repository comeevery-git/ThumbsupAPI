package com.boot.api.thumbsup.domains.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.api.thumbsup.common.config.JwtTokenProvider;
import com.boot.api.thumbsup.domains.admin.domain.AdminJpaRepo;
import com.boot.api.thumbsup.domains.auth.domain.RSPHM001;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
    private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private AdminJpaRepo adminJpaRepo;
	
    /*
	 * 홈페이지 공지사항 조회
	 */
    @ApiOperation(value = "홈페이지 공지사항 조회", notes = "관리자가 홈페이지 공지사항을 조회합니다.")
    @PostMapping(value = "/webNotice")
    public RSPHM001 webNotice(
    		RSPHM001 req,
    		@ApiParam(value = "token", required = true) @RequestParam String token
           ) {

    	try {
    		//토큰 유효확인
    		System.out.println("API #TOKEN 유효확인# " +jwtTokenProvider.validateToken(token));
    		boolean tokenStatus = jwtTokenProvider.validateToken(token);
    		
    		//토큰 상태에 따른 응답보낼 데이터 세팅
    		if(tokenStatus) {
    			//홈페이지 공지사항 조회
    			//Admin admin = adminJpaRepo.findByAdminId(adminId).orElseThrow(CEmailSigninFailedException::new);
    	        //req.setAdmin_idx(admin.getAdmin_idx());
    	        req.setSuccess("success");
    	        
    	        
    		} else {
    			req.setSuccess("fail");
    			req.setMsg("[인증실패] 다시 로그인 해 주십시오.");
    			
    		}
	        
	        return req;
	        
    	} catch (Exception e) {
    		System.out.println(e);
    		req.setSuccess("fail");
    		req.setMsg("api server error");
    	}
    	return req;
    }
	
    
}
