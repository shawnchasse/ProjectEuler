package NthPrime_p7;

import util.Primer;

public class NthPrimes
{
    public static void main( String args[] )
    {
	final long start = System.currentTimeMillis();
	final int nthPrime = Integer.parseInt(args[0]);
	final Primer primeGenerator = new Primer();
	final java.util.ArrayList<Long> primeList = primeGenerator.getFirstNPrimes(nthPrime);
	
	// the Primer class did the hard work, we just need to return the nth Prime which is nthPrime-1 in the array because 1 isn't included
	System.out.println( nthPrime + " Prime is " + primeList.get(nthPrime-1));
	final long stop = System.currentTimeMillis();
	System.out.println("Runtime: " + (stop - start) + " ms");
    }
}