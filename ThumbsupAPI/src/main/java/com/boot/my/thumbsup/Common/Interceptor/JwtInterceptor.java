package com.boot.my.thumbsup.Common.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.boot.my.thumbsup.Common.Exception.UnauthorizedException;
import com.boot.my.thumbsup.Common.Service.JwtService;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	private static final String HEADER_AUTH = "Authorization";
	
	@Autowired
	private JwtService jwtService;
	
	//HTTP 헤더에서 JWT를 가져와서 유효하면 true, 그렇지 않으면 예외발생
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String token = request.getHeader(HEADER_AUTH);

		if(token != null && jwtService.isUsable(token)){
			return true;
		}else{
			throw new UnauthorizedException();
		}
	}
	
	
	
}