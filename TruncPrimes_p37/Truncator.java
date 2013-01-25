package TruncPrimes_p37;

import util.Primer;

public class Truncator
{
   public static void main(String args[])
   {
      int numTruncatable = Integer.parseInt(args[0]);
      int numFound = 0;
      long sumTruncatable = 0;
      
      Primer pHelper = new Primer();
      long xPrimes = 10000000;
      System.out.println("Getting primes less than " + xPrimes );
      java.util.ArrayList<Long> primeList = pHelper.getPrimesLessThanX(xPrimes);
      java.util.HashSet<Long> primeSet = new java.util.HashSet<Long>();
      System.out.println("Putting the primes into a hash set...");
      for ( Long aPrime : primeList )
      {
	 primeSet.add(aPrime);
      }
      System.out.println("Done putting primes into set, starting to identify truncatable primes");
      
      for ( Long aPrime : primeList )
      {
	 if ( isTruncatable(aPrime, primeSet) )
	 {
	    numFound++;
	    sumTruncatable += aPrime.longValue();
	 }
	 if ( numFound >= numTruncatable )
	 {
	    break;
	 }
      }
      System.out.println("Found " + numFound + " primes that are truncatable, their combined sum is " + sumTruncatable);
      
      
   }

   private static boolean isTruncatable(Long prime, java.util.HashSet<Long> primeSet )
   {
      boolean truncatable = false;
      long thePrime = prime.longValue();
      if ( thePrime >= 10 ) //  37 is the first truncatable prime anything less than that is not.
      {
	 //System.out.println("Working on prime number " + thePrime);
	 truncatable = isLTrunc(prime,primeSet) && isRTrunc(prime,primeSet) ? true : false;
	 if ( truncatable )
	 {
	    System.out.println("Prime " + thePrime + " is truncatable " );
	 }
      }
      return truncatable;
   }

   private static boolean isLTrunc( long prime, java.util.HashSet<Long> primeSet )
   {
      boolean trunc = false;
      String pStr = String.valueOf(prime);
      while (pStr.length() > 1)
      {
	 String lTrunc = pStr.substring(1);
	 Long potPrime = Long.valueOf(lTrunc);
	 if ( primeSet.contains(potPrime) )
	 {
	    trunc = true;
	 }
	 else
	 {
	    trunc = false;
	    break;
	 }
	 pStr = lTrunc;
      }
      return trunc;
   }

   private static boolean isRTrunc( long prime, java.util.HashSet<Long> primeSet )
   {
      boolean trunc = false;
      String pStr = String.valueOf(prime);
      while ( pStr.length() > 1 )
      {
	 String rTrunc = pStr.substring(0,pStr.length()-1);
	 Long potPrime = Long.valueOf(rTrunc);
	 if ( primeSet.contains(potPrime) )
	 {
	    trunc = true;
	 }
	 else
	 {
	    trunc = false;
	    break;
	 }
	 pStr = rTrunc;
      }
      return trunc;
   }
      
}
