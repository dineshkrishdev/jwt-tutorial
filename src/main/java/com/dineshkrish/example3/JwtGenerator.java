package com.dineshkrish.example3;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
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

		File file = new File("src/main/resources/keystore.jks");
		InputStream is = new FileInputStream(file);
		KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
		String password = "dinesh";
		keystore.load(is, password.toCharArray());

		KeyStore.PrivateKeyEntry keyEnt = (KeyStore.PrivateKeyEntry) keystore.getEntry("dinesh",
				new KeyStore.PasswordProtection(password.toCharArray()));

		PrivateKey privateKey = keyEnt.getPrivateKey();

		return privateKey;
	}

}
