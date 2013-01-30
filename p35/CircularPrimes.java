package p35;

import util.Primer;

public class CircularPrimes
{
   public CircularPrimes()
   {

   }
   public static void main(String args[])
   {
      long maxVal = Long.parseLong(args[0]);
      
      int numCircularPrimes = 0;
      Primer primeHelper = new Primer();

      java.util.ArrayList<Long> primeList = primeHelper.getPrimesLessThanX(maxVal);
      System.out.println("Got all primes less than " + maxVal );
      java.util.HashSet<Long> primeSet = new java.util.HashSet<Long>();
      for ( Long prime : primeList )
      {
	 primeSet.add(prime);
      }      
      System.out.println("Done putting primes into a hash set");
      for ( Long prime : primeList )
      {
	 if ( isCircularPrime(prime,primeSet) )
	 {
	    numCircularPrimes++;
	 }
      }
      System.out.println("The total number of circular primes below " + maxVal + " is " + numCircularPrimes);
   }
   
   private static boolean isCircularPrime(Long prime, java.util.HashSet<Long> primeSet )
   {
      boolean isCircular = false;
      String primeStr = prime.toString();
      
      if ( primeStr.length() == 1 )
      {
	 isCircular = true;
      }
      else
      {
	 isCircular = true;
	 for ( int i = 1; i < primeStr.length(); i++ )
	 {
	    String tmpStr = primeStr.substring(i,primeStr.length()) + primeStr.substring(0,i);
	    Long tmp = Long.parseLong(tmpStr);
	    if ( !primeSet.contains(tmp) )
	    {
	       isCircular = false;
	       break;
	    }
	 }
      }
      return isCircular;
   }
}
