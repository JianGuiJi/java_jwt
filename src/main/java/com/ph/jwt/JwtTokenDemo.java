package com.ph.jwt;

import com.auth0.jwt.interfaces.Claim;

import java.util.Map;

/**
 * 文件说明
 * Author JiJG(jijg)<jijg@lizi.com>
 * date:2018-03-16 9:45
 */
public class JwtTokenDemo {
    public static void main(String[] args) throws Exception {
        String token = JwtToken.createToken();
        System.out.println(token);
        Map<String, Claim> claims = JwtToken.verifyToken(token);
        System.out.println(claims.get("name").asString());
        System.out.println(claims.get("age").asString());
        System.out.println(claims.get("org") == null ? null : claims.get("org").asString());

        //使用过期的token 经销校验
        String tokenExpire = "eyJha2ciOiJIUzI1NiIsImFsZyI6IkhTMjU2IiwidHlwIjoiSldUIn0.eyJvcmciOiLku4rml6XlpLTmnaEiLCJuYW1lIjoiRnJlZeeggeWGnCIsImV4cCI6MTUyMTE2NTM4MSwiaWF0IjoxNTIxMTY1MzIxLCJhZ2UiOiIyOCJ9.YD6MR_B7zZYv5CfhBnIOYNPSsLc6aXyV9iQ8OaLrb7c";
        System.out.println(tokenExpire);
        Map<String, Claim> claimsExpire = JwtToken.verifyToken(tokenExpire);
        System.out.println(claimsExpire);
    }
}
