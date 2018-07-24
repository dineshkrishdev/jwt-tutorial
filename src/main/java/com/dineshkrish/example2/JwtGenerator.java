package com.dineshkrish.example2;

import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtGenerator {

	public static void main(String[] args) {
		
		JwtBuilder jb = Jwts.builder();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("sub", "sub");
		
		jb.setClaims(map);
		
		jb.signWith(SignatureAlgorithm.HS512, "dinesh");
		
		System.out.println(jb.compact());
		
		
	}
}
