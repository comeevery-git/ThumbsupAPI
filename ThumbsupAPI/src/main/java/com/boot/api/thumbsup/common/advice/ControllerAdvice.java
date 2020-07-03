package com.boot.api.thumbsup.common.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.boot.api.thumbsup.common.exception.RestException;

/*
 * ControllerAdvice는 Spring에서 제공하는 annotation으로 Controller에 전역에 적용되는 코드를 작성할 수 있게 해 줍니다.
 * 또한 설정시 특정 패키지를 명시하면 적용되는 Controller의 범위도 제한할 수 있습니다.
 * 이러한 특성을 이용하면 @ControllerAdvice와 @ExceptionHandler를 조합하여 예외 처리를 공통 코드로 분리하여 작성할 수 있습니다.
 */

@RestControllerAdvice
public class ControllerAdvice {
 
  	@ExceptionHandler(RestException.class)
    public ResponseEntity<Map<String, Object>> handler(RestException e){
  		Map<String, Object> resBody = new HashMap<>();
  		resBody.put("message",e.getMessage());
  		
    	return new ResponseEntity<>(resBody, e.getStatus());
    }
    
}
