package com.example.registrationloginwebapp.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final UserDetailsService userDetailsService;

    @Value("${jwt.header}")
    private String authorizationHeader;
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private long validityInMilliseconds;

    public JwtTokenProvider(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String userName, String role) {
        Claims claims = Jwts.claims().setSubject(userName);
        claims.put("role", role);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds * 1000);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.ES256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            System.out.println("Inside JwtTokenProvider!!!!!!!!!!!");
            System.out.println(token);

            JwtParser parser = Jwts.parser();
            System.out.println("step 1:" + parser);

            parser = parser.setSigningKey(secretKey);
            System.out.println("step 2:" + parser);

            System.out.println("////////////////////");

            //TODO parseClaimsJws() throws an exception
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

            System.out.println("Inside JwtTokenProvider!!!!!!!!!!! Patr 2");

            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException exception) {
            throw new JwtAuthenticationException("jwt token is expired or invalid", HttpStatus.UNAUTHORIZED);
        }
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUserName(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUserName(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request){
        return request.getHeader(authorizationHeader);
    }
}
