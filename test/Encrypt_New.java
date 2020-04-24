/**
 * 
 */
package com.test;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

import com.supportclass.ReadFile;

import sun.misc.BASE64Encoder;


public class Encrypt_New 
{
	public static String encrypt(String str,BigInteger n,BigInteger d) throws IOException
    {
		String nhash;
		
		BigInteger[] ciphertext = null;
		
		//BigInteger n1 = toBigInteger(n);
		//BigInteger d1 = toBigInteger(d);
		
		System.out.println("N&D Val "+n+"."+d);
		
		RSA_New rsa = new RSA_New();
		
		
		ciphertext = rsa.encrypt(str,n,d) ;
		
		StringBuffer bf = new StringBuffer();
		for( int i = 0 ; i < ciphertext.length ; i++ )
		{
			bf.append( ciphertext[i].toString(  )) ;
			bf.append("~");
			if( i != ciphertext.length - 1 )
				System.out.print("") ;
		}
		String message=bf.toString();
		
		
		
		return message.trim();///here we removed the white spaces and added tlid charecter between words
    }
	
	public static BigInteger toBigInteger(String foo)
	{
	    return new BigInteger(foo.getBytes());
	}
	
	public static void main(String a[]) throws IOException
	{
		
		/*String filpath="test.txt";
		
		String s = ReadFile.readfile(filpath);
		
		String s1=encrypt(s);
	
		File f = new File("test_enc.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(s1);
		
		bw.close();
	
		System.out.println("output  :"+s1);
		System.out.println(Decrypt_New.decrypt(s1));
		
		String dec = Decrypt_New.decrypt(s1);
		
		File f1 = new File("test_dec.txt");
		FileWriter fw1 = new FileWriter(f1);
		BufferedWriter bw1 = new BufferedWriter(fw1);
		bw1.write(dec);
		bw1.close();*/
	}
}
