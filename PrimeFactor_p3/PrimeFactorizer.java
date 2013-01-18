package PrimeFactor_p3;

import util.Primer;

class PrimeFactorizer
{
    public static void main( String args[])
    {
        if ( args.length != 1 )
	{
	   System.out.println("Only one argument is allowed, no more no less");
	   return;
	}
        long countTo = 0;
        try
	{
	    countTo = Long.parseLong(args[0]);
	}
        catch ( final NumberFormatException nfe )
	{
	    System.out.println("The argument must be a long value, " + args[0] + " was not.");
	    return;
	}
	// Use the Prime generator class Primer to generate all the prime numbers up to square root of countTo
	Primer primeGenerator = new Primer();
        Double tmpNum = Math.floor(Math.sqrt(countTo));
	java.util.ArrayList<Long> primeList = primeGenerator.getPrimesLessThanX(tmpNum.longValue());
	
	long maxFactor = 1;
	// Iterate over the primeList in reverse order finding the larges prime factor of countTo
	for ( int i = primeList.size() - 1; i >= 0; i--)
        {
	    long curVal = primeList.get(i).longValue();

	    if ( countTo % curVal == 0 )
	    {
		maxFactor = curVal;
		break; // as soon as we find something that is divisble by this break out to save time since we are counting backwards.
	    }
	}

	System.out.println("Max prime factor is " + maxFactor);
    }
}