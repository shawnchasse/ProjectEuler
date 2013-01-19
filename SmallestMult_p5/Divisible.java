package SmallestMult_p5;

import util.Primer;

public class Divisible
{
    public static void main ( String args[] )
    {
	
	long maxDivisor = Long.parseLong(args[0]);
	final Primer primeHelper = new Primer();
	// generate the primes less than our max divisor.
	final java.util.ArrayList<Long> primeList = primeHelper.getPrimesLessThanX(maxDivisor *2 ); // get some extra primes for padding.
	final java.util.ArrayList<Long> largestFactorList = new java.util.ArrayList<Long>();
	
	for ( int i = 1; i <= maxDivisor; i++ )
	{
	    java.util.ArrayList<Long> primeFactors = primeHelper.calculatePrimeFactorsOfX(i);
	    //System.out.println("Got prime factors for " + i + ": " + primeFactors.toString());
	    for ( int j = 0; j < primeFactors.size(); j++ )
	    {
		long powerOfPrime = primeFactors.get(j);
		//System.out.println(j + " " + primeFactors.size() + " Power of prime " + primeList.get(j) + " for current divisor " + i + " is " + powerOfPrime );
		if ( largestFactorList.size() < j + 1 )
		{
		    largestFactorList.add(j,powerOfPrime); // we haven't seen this prime number yet so we have the max power
		}
		else if ( largestFactorList.get(j) < powerOfPrime )
		{
			largestFactorList.set(j,powerOfPrime); // we have a new largest prime power for this prime index store it
		}		
	    }
	    //System.out.println("Largest Prime Factors are: " + largestFactorList.toString());
	} 
	// Now iterate through our largest factor list and for each prime (associated in the primeList) we raise the prime to the power stored in
	// the largest factor list.
	long productOfPrimeFactors = 1;
	for ( int k = 0; k < largestFactorList.size(); k++ )
	{
	    long base = primeList.get(k);
            long power = largestFactorList.get(k);
	    productOfPrimeFactors *= Math.pow(base,power);
	}
	
	System.out.println("Smallest Positive number divisible by 1 to " + maxDivisor + " is " + productOfPrimeFactors);
    }

}