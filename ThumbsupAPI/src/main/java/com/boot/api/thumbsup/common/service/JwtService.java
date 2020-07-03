package com.boot.api.thumbsup.common.service;

import java.util.Map;

public interface JwtService {
	//토큰발급
	<T> String create(String key, T data, String subject);
	//토큰유효확인
	boolean isUsable(String token);
	//토큰데이터 가져오기
	Map<String, Object> get(String key);
	
	
}