package com.test;

import java.util.Random;

public class Random_PrimeNum {
	
	public static String getPrime_Number()
	{
		
		Random ran = new Random();
		String[] pnum = new String[]{"233","239","241","251","257","263","269","271","277","281","283","293","307","311","313","317","331","337","347","349"}; 
		
		int num = ran.nextInt(pnum.length);
		
		System.out.println("...... "+pnum[num]);
		
		return pnum[num];
		
	}
	public static void main(String[] args)
	{
		
		getPrime_Number();
	}

}
