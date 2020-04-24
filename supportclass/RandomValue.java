package com.supportclass;

import java.math.BigInteger;
import java.util.Random;

public class RandomValue {
	
	               /*Random Value Generation*/
	
		
	public static String  DESKeyValue()
	{
		
		String values[] = new String[] { "123abc45","678abc91","222aes55","999sea77","888lll55","444ccc45","333kkk45","449jjj45"};
		Random random = new Random();
		
		int num=random.nextInt(values.length);
		//int n=random(values);
		//int m=random(values);
		//System.out.println("Ramdom Position Of Array :" +num +" Ramdom Array Value Of prime  : "+values[num]);
		return values[num];
		
	}
	
	public static String  AESKeyValue()
	{
		
		String values[] = new String[] { "123abc45222aes55","678abc91123abc45","222aes55999sea77","999sea77888lll552","888lll55222aes55","444ccc45449jjj45","333kkk45999sea77","449jjj45444ccc45"};
		Random random = new Random();
		
		int num=random.nextInt(values.length);
		//int n=random(values);
		//int m=random(values);
		//System.out.println("Ramdom Position Of Array :" +num +" Ramdom Array Value Of prime  : "+values[num]);
		return values[num];
		
	}
	
}
