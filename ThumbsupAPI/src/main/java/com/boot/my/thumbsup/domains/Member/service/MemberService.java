package com.boot.my.thumbsup.domains.Member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.my.thumbsup.domains.Member.domain.MemberRepository;

//컨트롤러에서 받은 데이터로 쿼리를 수행하여, 나온 결과를 다시 컨트롤러에 전달
//UserRepository 객체를 주입받으며,
//sava()는 Insert쿼리를 수행하고, findAll()은 select쿼리를 수행한다.

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
/*
	public void userInsert(Member member) {
		memberRepository.save(member);
	}
	
	public Iterable<Member> userSelect(){
		return memberRepository.findAll();
	}
*/
}
