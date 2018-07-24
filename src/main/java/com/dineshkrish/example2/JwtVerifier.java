package com.dineshkrish.example2;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class JwtVerifier {

	public static void main(String[] args) {
		
		JwtParser jp = Jwts.parser();		
		jp.setSigningKey("dinesh");
		
		Jwt jwt = jp.parse("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdWIifQ.SBJrF04n6KXLXUa-3fhhj0DrdnTMtpcYzkzIn-jFsBeeFLkdrFXWFDLTwHB2GhdqfSCK8rl747q34Gh4HcHlTw");
		
		System.out.println(jwt.getHeader());
		System.out.println(jwt.getBody());
		
	}
}
