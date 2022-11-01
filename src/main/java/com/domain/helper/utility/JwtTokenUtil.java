package com.domain.helper.utility;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.domain.model.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
  private static final long serialVersionUID = -2550185165626007488L;

  @Value("${jwtSecret}")
	private String secret;

  @Value("${jwtExpirationMs}")
	private String jwt_expired;

  public static String generateToken(User user) {

		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + 2999);

		return Jwts.builder()
				.setSubject(Long.toString(user.getId()))
				.setIssuedAt(new Date())
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, "secret")
				.compact();
	}
}