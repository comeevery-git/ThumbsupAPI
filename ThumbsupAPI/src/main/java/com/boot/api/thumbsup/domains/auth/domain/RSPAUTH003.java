package com.boot.api.thumbsup.domains.auth.domain;

import lombok.Getter;
import lombok.Setter;

/*
 * 회원 로그인
 */

@Getter
@Setter
public class RSPAUTH003 implements RqsInterData{
	// 결과값
	private String success;
	
	// 결과msg
	private String msg;
	
	// jwt 토큰
	private String memberToken;

	// 회원 권한
	private String memberRole;
	
	// idx
	private Integer mbIdx;

    // 아이디 
    private String mbId;

    // 비밀번호 
    private String mbPwd;

    // 이름 
    private String mbNm;

    // 전화번호 
    private String mbTel;

    // 생년월일 
    private String mbRrno;

    // 성별 
    private String mbGender;

    // 대표 이미지 
    private Integer mbImg;

    // 탈퇴유무 
    private String mbDelyn;

    // 등록일 
    private String mbRegdate;

    // 수정일 
    private String mbUpddate;
   
    // 마지막 접속일 
    private String mbAccessdate;


    
    
    
    
    
    
    
}
