package com.boot.api.thumbsup.domains.member.controller;

import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.api.thumbsup.common.exception.CMemberNotFoundException;
import com.boot.api.thumbsup.common.model.CommonResult;
import com.boot.api.thumbsup.common.model.ListResult;
import com.boot.api.thumbsup.common.model.SingleResult;
import com.boot.api.thumbsup.common.service.ResponseService;
import com.boot.api.thumbsup.domains.member.domain.Member;
import com.boot.api.thumbsup.domains.member.domain.MemberJpaRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

/*
 * @Api(tags = {“1. User”})
UserController를 대표하는 최상단 타이틀 영역에 표시될 값을 세팅합니다.
@ApiOperation(value = “회원 조회”, notes = “모든 회원을 조회한다”)
각각의 resource에 제목과 설명을 표시하기 위해 세팅합니다.
@ApiParam(value = “회원 이름”, required = true) @RequestParam ~~~
파라미터에 대한 설명을 보여주기 위해 세팅합니다.
*/

@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")

public class MemberController {
    private final MemberJpaRepo memberJpaRepo;
    private final ResponseService responseService; // 결과를 처리할 Service
    
    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원을 조회한다")
    @GetMapping(value = "/users")
    public ListResult<Member> findAllUser() {
        // 결과데이터가 여러건인경우 getListResult를 이용해서 결과를 출력한다.
        return responseService.getListResult(memberJpaRepo.findAll());
    }
    
    @ApiOperation(value = "회원 단건 조회", notes = "userId로 회원을 조회한다")
    @GetMapping(value = "/user/{msrl}")
    public SingleResult<Member> findUserById(
		    		@ApiParam(value = "회원ID", required = true) @PathVariable int mbIdx
	    		) {
        // 결과데이터가 단일건인경우 getBasicResult를 이용해서 결과를 출력한다.
    	//orElseThorw 에러처리 - ExceptionAdvice.java
        return responseService.getSingleResult(memberJpaRepo.findById(mbIdx).orElseThrow(CMemberNotFoundException::new));
    }
    
    @ApiOperation(value = "회원 입력", notes = "회원을 입력한다")
    @PostMapping(value = "/user")
    public SingleResult<Member> save(
					@ApiParam(value = "회원아이디", required = true) @RequestParam String mbId,
                    @ApiParam(value = "회원이름", required = true) @RequestParam String mbNm,
                    @ApiParam(value = "회원비밀번호", required = true) @RequestParam String mbPwd,
                    @ApiParam(value = "회원생년월일", required = true) @RequestParam String mbRrno,
                    @ApiParam(value = "회원성별", required = true) @RequestParam String mbGender,
                    @ApiParam(value = "회원타입", defaultValue= "USER") @RequestParam String mbType,
                    @ApiParam(value = "회원삭제여부", defaultValue= "N") @RequestParam String mbDelyn
               ) {
    	
    	SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
    	String date = format.format (System.currentTimeMillis());
    	System.out.println("회원가입 - 현재 날짜 : "+date);
    	String mbRegdate = date;
    	String mbUpddate = date;
    	
    	Member member = Member.builder()
                .mbId(mbId)
                .mbNm(mbNm)
                .mbPwd(mbPwd)
                .mbRrno(mbRrno)
                .mbGender(mbGender)
                .mbType(mbType)
                .mbRegdate(mbRegdate)
                .mbUpddate(mbUpddate)
                .mbDelyn(mbDelyn)
                .build();
        
    	return responseService.getSingleResult(memberJpaRepo.save(member));
        
    }
    
    @ApiOperation(value = "회원 수정", notes = "회원정보를 수정한다")
    @PutMapping(value = "/user")
    public SingleResult<Member> modify(
	            	@ApiParam(value = "회원번호", required = true) @RequestParam int mbIdx,
	            	@ApiParam(value = "회원아이디", required = true) @RequestParam String mbId,
	            	@ApiParam(value = "회원이름", required = true) @RequestParam String mbNm
	            ) {
    	Member member = Member.builder()
                .mbIdx(mbIdx)
                .mbId(mbId)
                .mbNm(mbNm)
                .build();
        return responseService.getSingleResult(memberJpaRepo.save(member));
    }
    
    @ApiOperation(value = "회원 삭제", notes = "userId로 회원정보를 삭제한다")
    @DeleteMapping(value = "/user/{msrl}")
    public CommonResult delete(
            		@ApiParam(value = "회원번호", required = true) @PathVariable int mbIdx
            	) {
    	memberJpaRepo.deleteById(mbIdx);
        // 성공 결과 정보만 필요한경우 getSuccessResult()를 이용하여 결과를 출력한다.
        return responseService.getSuccessResult();
    }
    
}
