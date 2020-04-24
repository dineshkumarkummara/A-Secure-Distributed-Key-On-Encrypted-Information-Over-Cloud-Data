/**
 * 
 */
package com.test;




import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.math.BigInteger;

import sun.misc.BASE64Decoder;


public class Decrypt_New
{
	public static String decrypt(String encryptStr,BigInteger n,BigInteger e) throws IOException 
    {
		RSA_New rsa = new RSA_New() ;
		StringBuffer sb=new StringBuffer(encryptStr.trim());
		
		System.out.println("");
		String [] enc=rsa.split(sb,"~");
		BigInteger[] ciphertext=new BigInteger[enc.length];
		for(int i=0;i<enc.length;i++)
			ciphertext[i]=new BigInteger(enc[i]);
		
		//BigInteger n1 = toBigInteger("46883");
		System.out.println("  N :"+n);
		
		//BigInteger d1 = toBigInteger("233");
		System.out.println("  e :"+e);
		
		String dec  =  rsa.decrypt(ciphertext ,e,n) ;
		
		
		return dec;
    }
	public static BigInteger toBigInteger(String foo)
	{
	    return new BigInteger(foo.getBytes());
	}
	public static void main(String ags[])
	{
		/*try {
			System.out.println(decrypt("110#105#116#105#110#"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
