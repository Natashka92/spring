package com.common.services.security;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.util.DigestUtils;
import java.util.Random;

public class PasswordEncoder implements org.springframework.security.authentication.encoding.PasswordEncoder{

    public static final int LENGTH = 16;
    public static final int PLACE = 16;

    @Override
    public String encodePassword(String password, Object obj) throws DataAccessException {
        try{
            String str = randomSalt();
            return encrypt(password, str);
        }
        catch (Exception e){
            throw  new DataAccessResourceFailureException("Failed to encode password.", e);
        }
    }

    @Override
    public boolean isPasswordValid(String encPassword, String password, Object obj) {
        try{
            String str = extractSaltFromHash(encPassword);
            return encrypt(password, str).equals(encPassword);
        }
        catch (Exception e){
            throw new DataAccessResourceFailureException("Failed to validate password.", e);
        }
    }

    public String encrypt(String password, String salt){
        String saltPassword = addSaltToPassword(password, salt);
        String hash = getMD5(saltPassword);
        return addSaltToHash(hash, salt);
    }

    public String getMD5(String raw){
        return DigestUtils.md5DigestAsHex(raw.getBytes());
    }

    public String randomSalt(){
        return generateString(new Random(), "0123456789abcdef", LENGTH);
    }

    public String addSaltToPassword(String password, String salt) {
        return new StringBuilder(password).append(salt).toString();
    }

    public String addSaltToHash(String hash, String salt) {
        String part1 = hash.substring(0, PLACE);
        String part2 = hash.substring(PLACE);
        return new StringBuilder(part1).append(salt).append(part2).toString();
    }

    public String extractSaltFromHash(String hash) {
        return hash.substring(PLACE, PLACE + LENGTH);
    }

    public String generateString(Random rng, String characters, int length){
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
