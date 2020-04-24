package com.supportclass;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class HashingTechnique {
	
	public static String MD5(String data) 
	{
		String output="";
		
		try
		{
			MessageDigest digest = MessageDigest.getInstance("MD5");
			
			byte[] buffer = new byte[8192];
			buffer = data.getBytes();
			digest.update(buffer);
			byte[] md5sum = digest.digest();
			
			BigInteger bigInt = new BigInteger(1, md5sum);
			output = bigInt.toString(16);
			
			System.out.println("MD5: " + output);
			
		} 
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In MD5 Algorithm.");
		}
		
		return output;
		
	}

}
