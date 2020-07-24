package com.boot.api.thumbsup.domains.service.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.api.thumbsup.common.config.JwtTokenProvider;
import com.boot.api.thumbsup.domains.auth.domain.RSPHM001;
import com.boot.api.thumbsup.domains.service.domain.Board;
import com.boot.api.thumbsup.domains.service.domain.BoardJpaRepo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/service")
public class ServiceController {
	@Autowired
    private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private BoardJpaRepo boardJpaRepo;
	
    /*
	 * 홈페이지 공지사항 조회
	 */
    @ApiOperation(value = "홈페이지 공지사항 조회", notes = "관리자가 홈페이지 공지사항을 조회합니다.")
    @GetMapping(value = "/webNotice")
    public RSPHM001 webNotice(
    		RSPHM001 req,
    		@ApiParam(value = "token", required = true) @RequestParam String token
           ) {

    	try {
    		//토큰 유효확인
    		System.out.println("API #TOKEN 유효확인# " +jwtTokenProvider.validateToken(token));
    		boolean tokenStatus = jwtTokenProvider.validateToken(token);
    		
    		//토큰 상태에 따른 응답보낼 데이터 세팅
    		if(tokenStatus == true) {
    			System.out.println("API #TOKEN.....true.........");
    			//홈페이지 공지사항 조회
    			List<Board> board = boardJpaRepo.findAll();
    			System.out.println("#TEST1# " +board);
    			System.out.println("#TEST2# " +board.toString());
    			
    			
    			
    	        req.setSuccess("success");
    	        req.setMsg("[인증성공] 홈페이지 공지사항 조회");
    		} else {
    			System.out.println("API #TOKEN...false.........");
    			req.setSuccess("fail");
    			req.setMsg("[인증실패] 다시 로그인 해 주십시오.");
    		}
	        
    	} catch (Exception e) {
    		System.out.println(e);
    		req.setSuccess("fail");
    		req.setMsg("api server error");
    	}
    	System.out.println("리턴 메세지 : " +req.getMsg()+" / 리턴 상태값 : "+req.getSuccess());
    	return req;
    	
    }
	
    
}
