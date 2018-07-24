package com.dineshkrish.example1;

import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

public class JwtGenerator {

	public static void main(String[] args) {
		
		JwtBuilder jb = Jwts.builder();
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("type", "mytype");
		
		
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", "mysubject");
		claims.put("iss", "myissure");
		
		
		jb.setClaims(claims);
		jb.setHeader(headers);
		
		String token = jb.compact();
		
		System.out.println(token);
		
		
	}
}
