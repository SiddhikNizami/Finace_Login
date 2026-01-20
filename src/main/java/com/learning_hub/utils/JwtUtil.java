package com.learning_hub.utils;


import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.slf4j.Logger; // Import the SLF4J Logger interface
import org.slf4j.LoggerFactory; // Import the SLF4J LoggerFactory
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class JwtUtil {
	
	/*
	 * private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);
	 * 
	 * @Value("${app.jwt.secret}") private String jwtSecret;
	 * 
	 * @Value("${app.jwt.expiration}") private long jwtExpiration;
	 * 
	 * @Value("${app.jwt.refresh-expiration}") private long refreshExpiration;
	 * 
	 * private SecretKey getSigningKey() { byte[] keyBytes =
	 * jwtSecret.getBytes(StandardCharsets.UTF_8); return
	 * Keys.hmacShaKeyFor(keyBytes); }
	 * 
	 * public String generateToken(Authentication authentication) { UserDetails
	 * userDetails = (UserDetails) authentication.getPrincipal(); return
	 * generateToken(userDetails.getUsername()); }
	 * 
	 * public String generateToken(String username) { Map<String, Object> claims =
	 * new HashMap<>(); return createToken(claims, username, jwtExpiration); }
	 * 
	 * public String generateRefreshToken(String username) { Map<String, Object>
	 * claims = new HashMap<>(); return createToken(claims, username,
	 * refreshExpiration); }
	 * 
	 * private String createToken(Map<String, Object> claims, String subject, long
	 * expiration) { Date now = new Date(); Date expiryDate = new Date(now.getTime()
	 * + expiration);
	 * 
	 * return Jwts.builder() .claims(claims) .subject(subject) .issuedAt(now)
	 * .expiration(expiryDate) .signWith(getSigningKey(), Jwts.SIG.HS512)
	 * .compact(); }
	 * 
	 * public String extractUsername(String token) { return extractClaim(token,
	 * Claims::getSubject); }
	 * 
	 * public Date extractExpiration(String token) { return extractClaim(token,
	 * Claims::getExpiration); }
	 * 
	 * public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	 * final Claims claims = extractAllClaims(token); return
	 * claimsResolver.apply(claims); }
	 * 
	 * private Claims extractAllClaims(String token) { return Jwts.parser()
	 * .verifyWith(getSigningKey()) .build() .parseSignedClaims(token)
	 * .getPayload(); }
	 * 
	 * private Boolean isTokenExpired(String token) { return
	 * extractExpiration(token).before(new Date()); }
	 * 
	 * public Boolean validateToken(String token, UserDetails userDetails) { final
	 * String username = extractUsername(token); return
	 * (username.equals(userDetails.getUsername()) && !isTokenExpired(token)); }
	 * 
	 * public boolean validateToken(String token) { try { Jwts.parser()
	 * .verifyWith(getSigningKey()) .build() .parseSignedClaims(token); return true;
	 * } catch (SignatureException ex) { log.error("Invalid JWT signature"); } catch
	 * (MalformedJwtException ex) { log.error("Invalid JWT token"); } catch
	 * (ExpiredJwtException ex) { log.error("Expired JWT token"); } catch
	 * (UnsupportedJwtException ex) { log.error("Unsupported JWT token"); } catch
	 * (IllegalArgumentException ex) { log.error("JWT claims string is empty"); }
	 * return false; }
	 */
}