package com.boot.api.thumbsup.domains.auth.domain;

import lombok.Getter;
import lombok.Setter;

/*
 * 직원 로그인
 */

@Getter
@Setter
public class RSPAUTH001 implements RqsInterData{
	// 결과값
	private String success;
	
	// 결과msg
	private String msg;
	
	// 관리자idx
	private int admin_idx;
	
	// 관리자 권한
	private String adminRole;
	
    // 관리자유형 
    private String adminType;

    // 부서 
    private String adminDepart;

    // 직급 
    private String adminRank;

    // 아이디 
    private String adminId;

    // 비밀번호 
    private String adminPwd;

    // 이름 
    private String adminNm;

    // 전화번호 
    private String adminTel;

    // 생년월일 
    private String adminRrno;

    // 성별 
    private String adminGender;

    // 대표 이미지 
    private Integer adminImg;

    // 사용유무 
    private String adminUseyn;

    // 탈퇴유무 
    private String adminDelyn;

    // 등록일 
    private String adminRegdate;

    // 수정일 
    private String adminUpddate;

    // 마지막 접속일 
    private String adminAccessdate;

    // token
    private String adminToken;
    
    
}
