package com.mars.marsgateway.utils;


import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * JWT校验工具类
 * <ol>
 * <li>iss: jwt签发者</li>
 * <li>sub: jwt所面向的用户</li>
 * <li>aud: 接收jwt的一方</li>
 * <li>exp: jwt的过期时间，这个过期时间必须要大于签发时间</li>
 * <li>nbf: 定义在什么时间之前，该jwt都是不可用的</li>
 * <li>iat: jwt的签发时间</li>
 * <li>jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击</li>
 * </ol>
 */

public class JWTUtil {

    private final static Logger log= LoggerFactory.getLogger(JWTUtil.class);

    /**
     * JWT 加解密类型
     */
    private static final SignatureAlgorithm ALGORITHM = SignatureAlgorithm.HS256;
    /**
     * JWT 生成密钥使用的密码
     */
    private static final String SECRET = "iwc.cloudBoss";

    /**
     * JWT 添加至HTTP HEAD中的前缀
     */
    private static final String SEPARATOR = "Bearer ";

    /**
     * JWT 添加至PAYLOAD的签发者
     */
    private static final String ISSUE = "iwc";

    /**
     * JWT 添加至PAYLOAD的有效期(秒)
     */
    private static final int TIMEOUT = 60 * 60 * 24;

    /**
     * 生成JWT
     *
     * @param userId
     * @return
     */
    public static String genJWT(String userId) {

        // 创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);

        long currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString()) //jwt唯一id
                .setIssuedAt(new Date(currentTime))  //签发时间
                .setIssuer(ISSUE) //签发者信息

                .signWith(ALGORITHM, SECRET) //加密方式
                .setExpiration(new Date(currentTime + TIMEOUT * 1000))  //过期时间戳
                .addClaims(claims) //cla信息
                .compact();
    }

    /**
     * 获取token中的claims信息
     *
     * @param token
     * @return
     */
    private static Jws<Claims> getJws(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token);
    }

    public static String getSignature(String token) {
        try {
            return getJws(token).getSignature();
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * 获取token中head信息
     *
     * @param token
     * @return
     */
    public static JwsHeader getHeader(String token) {
        try {
            return getJws(token).getHeader();
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 获取payload body信息
     *
     * @param token
     * @return
     */
    public static Claims getClaimsBody(String token) {
        return getJws(token).getBody();
    }

    /**
     * 获取body某个值
     *
     * @param token
     * @param key
     * @return
     */
    public static Object getVal(String token, String key) {
        return getJws(token).getBody().get(key);
    }

    /**
     * 是否过期
     *
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        try {
            return getClaimsBody(token)
                    .getExpiration()
                    .before(new Date());
        } catch (ExpiredJwtException ex) {
            return true;
        }
    }
}
