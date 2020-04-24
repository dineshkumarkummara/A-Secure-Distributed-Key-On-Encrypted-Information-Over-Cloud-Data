package com.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing 
{
	
	public static String HashingFunction(String input,int key) 
	{
		String output="";
        try 
        {
        	input=key+input;
        	System.out.println("Input value----"+input);
        	MessageDigest digest = MessageDigest.getInstance("MD5");
			
			byte[] buffer = new byte[8192];
			buffer = input.getBytes();
			digest.update(buffer);
			byte[] md5sum = digest.digest();
			
			BigInteger bigInt = new BigInteger(1, md5sum);
			output = bigInt.toString(16);
			///base 16  for hexa decimal 
			System.out.println("MD5: " + output);
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
}
