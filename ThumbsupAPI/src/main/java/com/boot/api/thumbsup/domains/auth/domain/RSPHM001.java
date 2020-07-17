package com.boot.api.thumbsup.domains.auth.domain;

import lombok.Getter;
import lombok.Setter;

/*
 * 홈페이지 공지사항
 */

@Getter
@Setter
public class RSPHM001 implements RqsInterData{
	// 결과값
	private String success;
	
	// 결과msg
	private String msg;

    // token
    private String adminToken;
    
    
}
