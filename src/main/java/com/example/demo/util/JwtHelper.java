package com.example.demo.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.Maps;

public class JwtHelper {
  
  private static final String  SECRET = "fqyang_session_secret";
  
  private static final String  ISSUER = "fqyang_user";
  
  /*  生成token: 将claims存贮到token中
  *
  *  tips: 可以将用户的email和用户名存入token中，这样可以减少数据库的压力，因为可直接从token中获取这些信息
  *
  * */
  public static String genToken(Map<String, String> claims){
    try
    {
      Algorithm algorithm = Algorithm.HMAC256(SECRET);
      JWTCreator.Builder builder = JWT.create().withIssuer(ISSUER).withExpiresAt(DateUtils.addDays(new Date(), 1));
      claims.forEach((k,v) -> builder.withClaim(k, v));
      return builder.sign(algorithm).toString();
    }
    catch (IllegalArgumentException e)
    {
      throw new RuntimeException(e);
    }
  }

  /*  校验token: 并从token中获取claims
  *
  * */
  public static Map<String, String> verifyToken(String token)  {
    Algorithm algorithm = null;
    try {
      algorithm = Algorithm.HMAC256(SECRET);
    }
    catch (IllegalArgumentException e) {
      throw new RuntimeException(e);
    }

    JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
    DecodedJWT jwt =  verifier.verify(token);

    Map<String, Claim> map = jwt.getClaims();
    Map<String, String> resultMap = Maps.newHashMap();
    map.forEach((k,v) -> resultMap.put(k, v.asString()));

    System.out.println("验证token成功");

    return resultMap;
  }

}
