package SumPrimes;

import util.Primer;

public class SumPrimes
{
    public static void main ( String args[] )
    {
	final long maxVal = Integer.parseInt(args[0]);

	Primer primeGenerator = new Primer();
	final java.util.ArrayList<Long> primeList = primeGenerator.getPrimesLessThanX( maxVal );
	
	long sum = 0;
	for ( Long aPrime : primeList )
	{
	    long curPrimeVal = aPrime.longValue();
	    if ( curPrimeVal >= maxVal )
	    {
		break;
	    }
	    sum += curPrimeVal;
	}
	System.out.println("The sum of all primes less than " + maxVal + " = " + sum );

    }

}