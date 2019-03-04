package com.leyou.auth.utils;


import com.leyou.auth.entity.UserInfo;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author bystander
 * @date 2018/10/1
 */
public class JwtUtilsTest {

    private static final String publicKeyPath = "C:\\tmp\\rsa\\rsa.pub";
    private static final String privateKeyPath = "C:\\tmp\\rsa\\rsa.pri";

    private PrivateKey privateKey;
    private PublicKey publicKey;


    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(publicKeyPath, privateKeyPath, "ly@Login(Auth}*^31)&leyou%f3q2");
    }

    @Before
    public void testGetRsa() throws Exception {
        privateKey = RsaUtils.getPrivateKey(privateKeyPath);
        publicKey = RsaUtils.getPublicKey(publicKeyPath);
    }

    @org.junit.Test
    public void generateToken() {
        //生成Token
        String s = JwtUtils.generateToken(new UserInfo(20L, "Jack"), privateKey, 5);
        System.out.println("s = " + s);
    }


    @org.junit.Test
    public void parseToken() {
       String token="eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MzgsInVzZXJuYW1lIjoiYnVzaCIsImV4cCI6MTU1MTQ2MjQ1NH0.FqRuzDjs-VWWfzCNN9rSnbRajwl8RbE3yExctITHuXrxzXgXfgrMmziJzNyHC6UW3qbrnRFm2it4J__NQK0j-dAhtKSse4YU5HDlkUUNvwydKrus1KQgft5Fx2hVsiNRzPzWAG4t0s6gNj2LVzQ6KFwzr_2opzK2yeC9VDapXW0";
       UserInfo userInfo = JwtUtils.getUserInfo(publicKey, token);
        System.out.println("id:" + userInfo.getId());
        System.out.println("name:" + userInfo.getName());
    }

    @org.junit.Test
    public void parseToken1() {
    }

    @org.junit.Test
    public void getUserInfo() {
    }

    @org.junit.Test
    public void getUserInfo1() {
    }
}