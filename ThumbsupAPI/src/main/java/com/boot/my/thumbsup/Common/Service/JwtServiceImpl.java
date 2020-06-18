package com.boot.my.thumbsup.Common.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.boot.my.thumbsup.Common.Exception.UnauthorizedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("jwtService")
public class JwtServiceImpl implements JwtService {
	private static final String TU_SIGN_KEY = "TESTKEY";
	private Date REG_DATE = new Date(System.currentTimeMillis() + 1000 * 10);
	//private String ISSUER = "KSH";
	
	@Override
	public <T> String create(String key, T data, String subject) {
		System.out.println("-- TOKEN CREATE --");
		String jwt = Jwts.builder()
				.setHeaderParam("type", "JWT")
				.setHeaderParam("regDate", REG_DATE)
				.setSubject(subject)
				.claim(key, data)
				.signWith(SignatureAlgorithm.HS256, this.generateKey())
				.compact();
		return jwt;
	}
	
	//Key 토큰발급
	private byte[] generateKey() {
		byte[] key = null;
		try {
			key = TU_SIGN_KEY.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Making JWT Key Error ::: {}"+e.getMessage());
		}
		
		return key;
	}
	
	//claim으로 변환도중 예외가 발생하면 유효하지 않은 토큰으로 판단, 예외 핸들링
	@Override
	public boolean isUsable(String token) {
		try {
			Jws<Claims> claims = Jwts.parser()
					.setSigningKey(this.generateKey())
					.parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			throw new UnauthorizedException();
		}
	}

	//JWT에 넣어둔 데이터 가져오기
	@Override
	public Map<String, Object> get(String key){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		String jwt = request.getHeader("Authorization");
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser()
						 .setSigningKey(TU_SIGN_KEY.getBytes("UTF-8"))
						 .parseClaimsJws(jwt);
		} catch (Exception e) {
			throw new UnauthorizedException();
		}
		@SuppressWarnings("unchecked")
		Map<String, Object> value = (LinkedHashMap<String, Object>)claims.getBody().get(key);
		return value;
		
	}
	
	
}