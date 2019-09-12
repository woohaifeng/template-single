package com.company.template.common.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Map;

public class JWTUtil {

    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
    private static final String SECRET = "TEMPLATE";

    public static String generateToken(Map<String,Object> claims) {
        String jwt = Jwts.builder().setClaims(claims).signWith(SIGNATURE_ALGORITHM,SECRET).compact();
        return jwt;
    }

}
