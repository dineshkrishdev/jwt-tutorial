package com.dineshkrish.example4;

import java.io.File;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtGenerator {

	public static void main(String[] args) throws Exception {

		JwtBuilder jb = Jwts.builder();

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("sub", "sub");

		jb.setClaims(map);

		jb.signWith(SignatureAlgorithm.RS512, getPrivateKey());

		System.out.println(jb.compact());

	}

	public static PrivateKey getPrivateKey() throws Exception {
		byte[] keyBytes = Files.readAllBytes(new File("KeyPair/privateKey").toPath());
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}
}
