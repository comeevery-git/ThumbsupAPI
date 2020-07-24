package com.boot.api.thumbsup.domains.auth.domain;

import lombok.Getter;
import lombok.Setter;

/*
 * 결과상태와 메세지 수신
 * 직원가입, 회원가입
 * 
 */

@Getter
@Setter
public class RSPAUTH002 implements RqsInterData{
	// 결과값
	private String success;
	
	// 결과msg
	private String msg;
    
    
    
    
}
