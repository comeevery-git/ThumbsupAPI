package com.boot.api.thumbsup.common.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/*
 * api의 실행 결과를 담는 공통 모델
api의 처리 상태 및 메시지를 내려주는 데이터로 구성됩니다. success는 api의 성공 실패 여부를 나타내고 code, msg는 해당 상황에서의 응답 코드와 응답 메시지를 나타냅니다.
 */

@Getter
@Setter
public class CommonResult {
    @ApiModelProperty(value = "응답 성공여부 : true/false")
    private boolean success;
    
    @ApiModelProperty(value = "응답 코드 번호 : >= 0 정상, < 0 비정상")
    private int code;
    
    @ApiModelProperty(value = "응답 메시지")
    private String msg;
    
}