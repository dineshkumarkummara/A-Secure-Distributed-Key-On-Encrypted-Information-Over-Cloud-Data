package com.test;
/**
 * 
 */
import java.math.BigInteger ;
import java.util.Random ;
import java.io.* ;



public class RSA_New 
{
	

	/**
	 * Two distinct large prime numbers p and q.
	 */
	//static BigInteger p=new BigInteger("173");
	//static BigInteger q=new BigInteger("271");
	
	static BigInteger p=new BigInteger(Random_PrimeNum.getPrime_Number());
	static BigInteger q=new BigInteger(Random_PrimeNum.getPrime_Number());

	/**
	 * Modulus N.
	 */
	static BigInteger N=p.multiply(q);
	
///here we are multipying two large  prime numbers 
	/**
	 * r = ( p - 1 ) * ( q - 1 )
	 */
	static BigInteger r=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
	
	

	/**
	 * Public exponent E and Private exponent D
	 */
	static BigInteger E=new BigInteger("233"); 
	
	
	static BigInteger D;
	
	  static BigInteger T;
	  static BigInteger one = new BigInteger("1", 10);
	  
	public static void keyGeneration()
	{
		for (int i = 0; true; i++)
        {
            T = new BigInteger(Integer.toString(i), 10);
          // System.out.println(" T1:"+T);
            
            if (E.multiply(T).mod(r).compareTo(one) == 0) 
            {
            	System.out.println(" T1:"+one);
             D = T;
              System.out.println(" T1:"+D);
              break;
            }
        }
	}

	public RSA_New()
	{
		keyGeneration();
		
		//System.out.println("BigInteger Primary Number :"+p+"..."+q);
		
		//System.out.println("N Value :"+N);
		
		//System.out.println("M Value :"+r);
		
		
		//Key Gen //
		
		//System.out.println("Public Exponent E Value :"+E);
		
		//System.out.println("Private Exponent D Value :"+D);
		
		//System.out.println("one Value :"+one);
		
		
	}
	
	
	
	public static BigInteger[] encrypt( String message,BigInteger n1,BigInteger d1 )
	{
		int i ;
		byte[] temp = new byte[1] ;


		byte[] digits = message.getBytes() ;///converting into byte

		BigInteger[] bigdigits = new BigInteger[digits.length] ;

		for( i = 0 ; i < bigdigits.length ; i++ )
		{
			temp[0] = digits[i] ;
			bigdigits[i] = new BigInteger( temp ) ;///what ever the file contents here we are converting into integers
		}

		BigInteger[] encrypted = new BigInteger[bigdigits.length] ;

		for( i = 0 ; i < bigdigits.length ; i++ )
			encrypted[i] = bigdigits[i].modPow( d1, n1 ) ;////RSA Encryption formaula


		return( encrypted ) ;
	}
	
	
	public static String decrypt( BigInteger[] encrypted,BigInteger s,BigInteger t )
	{
		int i ;


		BigInteger[] decrypted = new BigInteger[encrypted.length] ;

		for( i = 0 ; i < decrypted.length ; i++ )
			decrypted[i] = encrypted[i].modPow( s, t ) ;

		char[] charArray = new char[decrypted.length] ;

		for( i = 0 ; i < charArray.length ; i++ )
			charArray[i] = (char) ( decrypted[i].intValue() ) ;


		return( new String( charArray ) ) ;
	}
	
	
	/**
	 * Get prime number p.
	 *
	 * @return	Prime number p.
	 */
	public BigInteger getp()
	{
		return( p ) ;
	}


	/**
	 * Get prime number q.
	 *
	 * @return	Prime number q.
	 */
	public BigInteger getq()
	{
		return( q ) ;
	}


	/**
	 * Get r.
	 *
	 * @return	r.
	 */
	public BigInteger getr()
	{
		return( r ) ;
	}


	/**
	 * Get modulus N.
	 *
	 * @return	Modulus N.
	 */
	public BigInteger getN()
	{
		return( N ) ;
	}


	/**
	 * Get Public exponent E.
	 *
	 * @return	Public exponent E.
	 */
	public BigInteger getE()
	{
		return( E ) ;
	}


	/**
	 * Get Private exponent D.
	 *
	 * @return	Private exponent D.
	 */
	public BigInteger getD()
	{
		return( D ) ;
	}



	
	public void setN(BigInteger n)
	{
		N = n;
	}
	public static String[] split(StringBuffer sb, String splitter)
	{
	    String[] strs = new String[sb.length()];
	    int splitterLength = splitter.length();
	    int initialIndex = 0;
	    int indexOfSplitter = indexOf(sb, splitter, initialIndex);
	    int count = 0;
	    if(-1==indexOfSplitter) return new String[]{sb.toString()};
	    while(-1!=indexOfSplitter){
	        char[] chars = new char[indexOfSplitter-initialIndex];
	        sb.getChars(initialIndex, indexOfSplitter, chars, 0);
	        initialIndex = indexOfSplitter+splitterLength;
	        indexOfSplitter = indexOf(sb, splitter, indexOfSplitter+1);
	        strs[count] = new String(chars);
	        count++;
	    }
	    // get the remaining chars.
	    if(initialIndex+splitterLength<=sb.length()){
	        char[] chars = new char[sb.length()-initialIndex];
	        sb.getChars(initialIndex, sb.length(), chars, 0);
	        strs[count] = new String(chars);
	        count++;
	    }
	    String[] result = new String[count];
	    for(int i = 0; i<count; i++){
	        result[i] = strs[i];
	    }
	    return result;
	}

	public static int indexOf(StringBuffer sb, String str, int start){
	    int index = -1;
	    if((start>=sb.length() || start<-1) || str.length()<=0) return index;
	    char[] tofind = str.toCharArray();
	    outer: for(;start<sb.length(); start++){
	        char c = sb.charAt(start);
	        if(c==tofind[0]){
	            if(1==tofind.length) return start;
	            inner: for(int i = 1; i<tofind.length;i++){ // start on the 2nd character
	                char find = tofind[i];
	                int currentSourceIndex = start+i;
	                if(currentSourceIndex<sb.length()){
	                    char source = sb.charAt(start+i);
	                    if(find==source){
	                        if(i==tofind.length-1){
	                            return start;
	                        }
	                        continue inner;
	                    } else {
	                        start++;
	                        continue outer;
	                    }
	                } else {
	                    return -1;
	                }

	            }
	        }
	    }
	    return index;
	}
}
