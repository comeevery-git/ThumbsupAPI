package com.boot.api.thumbsup.common.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.boot.api.thumbsup.common.exception.CMemberNotFoundException;
import com.boot.api.thumbsup.domains.member.domain.MemberJpaRepo;

import lombok.RequiredArgsConstructor;

/*
 * 토큰에 세팅된 유저 정보로 회원정보를 조회하는 UserDetailsService를 재정의 합니다.
 */

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    
	private final MemberJpaRepo memberJpaRepo;
    
    public UserDetails loadUserByUsername(String mbId) {
//        return memberJpaRepo.findById((Long.valueOf(mbIdx)).orElseThrow(CMemberNotFoundException::new);
    	return memberJpaRepo.findByMbId(mbId).orElseThrow(CMemberNotFoundException::new);
    }
}