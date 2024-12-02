package com.poec.plumedenfant.config;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

	// généré par https://jwtsecret.com/generate
	private String jwtSecret = "b8491bb7dd4ed3465790528e11a45321f2508caab43d68bb972c8aad0df4589c9011ab8804fed697b99fa236cd635dab54e5ff66dddb41ff2a897582aa4ca80b913f36304169da306781224b9d2b5c96b276046a2c0da4af99dc60991000a2ea0f74f14aa1e70e31eb4262ef8e280dceba6499d594a051e967b63831ddbcb75ca280adbb8bdc4aea46a072a75e181630f5b261dcff33d041f450eab8c2929b99b960afcc15a0e7b6a677e213062a4f02d12ac639b58b181dd4bea745e6d83074f6d232bc42813f832c41b6d1974260959caee5ebff8961e6d4c051417c360565825f164b2a9b0744f87fd4eea5e5d4d29b0a086b94654e45405fe2f90f3e15f6";
	private long jwtExpirationDate = 7200000; // Pour 2h
	
	
	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date currentDate = new Date();
		Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);
		
		// Get user role from authentication
		String[] roles = authentication.getAuthorities().stream()
				.map(authority -> authority.getAuthority())
				.toArray(String[]::new);
		
		String token = Jwts.builder()
						.subject(username)
						.issuedAt(new Date())
						.expiration(expireDate)
						.claim("roles", roles) // ajout des roles dans le token
						.signWith(key(), SignatureAlgorithm.HS256)
						.compact();
		
		return token;
	}
	
	private Key key() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}
	
	// Extraire le username du token
	public String getUsername(String token) {
		return Jwts.parser()
				.verifyWith((SecretKey) key())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	// Get roles from JWT token
	public String[] getRoles(String token) {
		return Jwts.parser()
				.verifyWith((SecretKey) key())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.get("roles", String[].class);
	}
	
	// validate JWT token
	public boolean validateToken(String token) {
		Jwts.parser()
			.verifyWith((SecretKey) key())
			.build()
			.parse(token);
		
		return true;
	}
	
}
