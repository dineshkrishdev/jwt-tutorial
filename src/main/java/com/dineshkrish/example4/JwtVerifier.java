package com.dineshkrish.example4;

import java.io.File;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class JwtVerifier {

	public static void main(String[] args) throws Exception {

		JwtParser jp = Jwts.parser();
		jp.setSigningKey(getPublicKey());

		Jwt jwt = jp.parse(
				"eyJhbGciOiJSUzUxMiJ9.eyJzdWIiOiJzdWIifQ.MHXQ4DRXjegt67gKa-VD7eH18r35_y16clBmwXxU-LE0sdiy_glboxKESaLiNPsJ6n1hreJkZjfq2OfO1maeUWaatqBEUxg4V4MnKVWqyMMDJ0sihzENUm_qh1bE8_OMHyIVq1uBZiX3JkBF6uBfEvJvqlnVCKeQn_77FNkZBBI");

		System.out.println(jwt.getHeader());
		System.out.println(jwt.getBody());

	}

	public static PublicKey getPublicKey() throws Exception {

		byte[] keyBytes = Files.readAllBytes(new File("KeyPair/publicKey").toPath());
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

}
