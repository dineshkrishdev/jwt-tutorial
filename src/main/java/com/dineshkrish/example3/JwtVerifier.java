package com.dineshkrish.example3;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class JwtVerifier {

	public static void main(String[] args) throws Exception {

		JwtParser jp = Jwts.parser();
		jp.setSigningKey(getPublicKey());

		Jwt jwt = jp.parse(
				"eyJhbGciOiJSUzUxMiJ9.eyJzdWIiOiJzdWIifQ.XMdn4Vs6xo82OpFp_Gj-i-PbEQBYu53qV4svSYe09ca7KKhTNXGB7j701x3JoSaHZI-7F61nsTPgOnC-n4cdciF1w20AQkpT6ZP5keJZJq2eDlCBvhtM_oNPEKYngP2k43puLMdptF4Vu6Mhtjp4VSzk8dpwsS8GHWAHNVLA19kWnOz4EBLexA7CGk8hkHoVzTklpjf2unyvovt4NCzSABu_RBkLcUsmJFCjI-oS_MrRXx25CdFMqShoGFBd8rz50yiW7-vY-XEtw-UNOweMLqVf3Dpj-Vpyjivp9TFwWr_3MgO_BYD9OJj0zohBRYg4uXdgufa5NaBqzb3D3JU4wA");

		System.out.println(jwt.getHeader());
		System.out.println(jwt.getBody());

	}

	public static PublicKey getPublicKey() throws Exception {

		File trustfile = new File("src/main/resources/truststore.jks");
		InputStream trustis = new FileInputStream(trustfile);
		KeyStore trustkeystore = KeyStore.getInstance(KeyStore.getDefaultType());
		String trustpassword = "dinesh";

		trustkeystore.load(trustis, trustpassword.toCharArray());

		Certificate trustcert = trustkeystore.getCertificate("dinesh");

		PublicKey publicKey = trustcert.getPublicKey();

		return publicKey;
	}

}
