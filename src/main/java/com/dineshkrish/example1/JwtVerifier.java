package com.dineshkrish.example1;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class JwtVerifier {

	public static void main(String[] args) {
		
		JwtParser jp = Jwts.parser();		
		
		Jwt jwt = jp.parse("eyJ0eXBlIjoibXl0eXBlIiwiYWxnIjoibm9uZSJ9.eyJzdWIiOiJteXN1YmplY3QiLCJpc3MiOiJteWlzc3VyZSJ9.");
		
		System.out.println(jwt.getHeader());
		System.out.println(jwt.getBody());
		
	}
}
