package util;

public class Primer
{
    private static java.util.ArrayList<Long> primes = new java.util.ArrayList<Long>();
    private static java.io.File primeFile = new java.io.File("primes.txt");

    public Primer()
    {
	
    }


    
    public static void main( String args[])
    {
	long numPrimes = Long.parseLong(args[0]);
	Primer myPrimer = new Primer();
	
	java.util.ArrayList<Long> primesLessThanX = myPrimer.getPrimesLessThanX(numPrimes);

	java.util.ArrayList<Long> primeFactors = myPrimer.calculatePrimeFactorsOfX(numPrimes);
	long productOfPrimeFactors = 1;
        for ( int i = 0; i < primeFactors.size()-1; i++ )
	{
	    long base = primesLessThanX.get(i);
	    long power = primeFactors.get(i);
	    System.out.println("Prime Factor: " + base + "^" + power);
	    productOfPrimeFactors *= Math.pow(base,power);
	}
	System.out.println("The product of prime factors for " + numPrimes + " is " + productOfPrimeFactors);
    }

    private void readPrimeFile()
    {
	long start = System.currentTimeMillis();
       
	Long curMaxPrime = Long.valueOf(1);
	if ( primeFile.exists() && primes.size() == 0)
	{
	    java.io.BufferedReader in = null;
	    try
	    {
	        java.io.FileReader fReader = new java.io.FileReader(primeFile);
	        in = new java.io.BufferedReader(fReader);

		String curPrime = ""; 
	    
		while ( (curPrime = in.readLine()) != null )
		{
		    Long thePrime = Long.parseLong(curPrime);
		    primes.add(thePrime);
		    curMaxPrime = thePrime;
	        }
	    }
	    catch ( java.io.IOException ioe )
	    {
		System.out.println("IO Exception encountered: " + ioe);
	    }
	    finally 
            {
		try
		{
		    in.close();
		}
		catch ( java.io.IOException ioe )
    	        {
		    System.out.println("IOException during close");
		}

	    }
	}
	long stop = System.currentTimeMillis();
	System.out.println("Read file took: " + ( stop - start) + " ms");
    }

    private void writePrimeFile()
    {
	long start = System.currentTimeMillis();
	java.io.BufferedWriter out = null;
	try
	{    
	    java.io.FileWriter fWriter = new java.io.FileWriter(primeFile);
	    out = new java.io.BufferedWriter(fWriter);

	    for ( int i = 0; i < primes.size(); i++ )
	    {
	        out.write(primes.get(i).toString());
	        out.newLine();
	    
	    }
	    out.flush();
	}
	catch ( java.io.IOException ioe )
        {
            System.out.println("IO Exception encountered: " + ioe);
        }
	finally
        {
            try
	    {
		out.close();
	    }
            catch ( java.io.IOException ioe )
	    {
		System.out.println("IOException during close");
	    }
        }
	long stop = System.currentTimeMillis();
        System.out.println("Write file took: " + ( stop - start) + " ms");
    }

    // This utility function aims to generate X primes, it will call getPrimesLessThanX until the
    // size of the primes array is large enough to have the Xth prime in it. since primes is a 
    // global array it will have state and we won't be wasting any memory.
    public java.util.ArrayList<Long> getFirstNPrimes(long X)
    {
	// First we don't know how big the Xth prime is so start by doubling X to get the
	// prime generation. From there we'll keep doubling until we generate enough primes.
	long currentTarget = X;
	while (primes.size() < X )
	{
	    currentTarget *= 2;
	    getPrimesLessThanX(currentTarget); // we ignore return value
	}
	// we have enough primes now return the primes array
	return primes;
    }
    
    public java.util.ArrayList<Long> calculatePrimeFactorsOfX( long X )
    {
	// this array will hold a list of prime factors starting at 
	final java.util.ArrayList<Long> primeFactors = new java.util.ArrayList<Long>();
	getPrimesLessThanX(X+1); // get all the primes that are less than X + 1 (need to increment by 1 incase X is prime itself, need it to be inclusive)

	int primeIndex = 0;
	long curVal  = primes.get(primeIndex).longValue(); // start at 2, 1 isn't really prime at all
	while (curVal <= X )
	{	    
            if ( primeFactors.size() < primeIndex + 1 )
	    {
		primeFactors.add(primeIndex,new Long(0)); // initialize the current index
	    }
	    
	    primeFactors.set(primeIndex,new Long( findPrimeFactor( curVal, X)));
	    primeIndex++;
	    curVal = primes.get(primeIndex).longValue();
	}
	return primeFactors;
    }

    // This recursive helper function divides the number by the prime (if evenly divisible) and then returns factor count
    // each time the number or result is divisible by the prime for example:
    // start with 2 as the prime and 16 as the number
    //   16 / 2 = 8 (1 factor)
    //   8  / 2 = 4 (1 factor)
    //   4  / 2 = 2 (1 factor)
    //   2  / 2 = 1 (1 last factor, recursion stops because result = 1)
    private int findPrimeFactor( long prime, long number )
    {
	//System.out.println("Finding prime Factor for prime:number (" + prime + ":" + number + ")");
	int factorCount = 0;
	if ( number % prime == 0 )
	{
	    //System.out.println("Number % Prime == 0 (" + number + ":" + prime +")");
	    long result = number / prime;
	    if ( result != 1 )
	    {	       
		factorCount += findPrimeFactor(prime, result) + 1;
	    }
	    else
	    {
		factorCount += 1; // the case where we get number ==  prime
	    }
	}
	return factorCount;
    }

    public java.util.ArrayList<Long> getPrimesLessThanX( long X )
    {
	readPrimeFile();
	long start = System.currentTimeMillis();
	if ( primes.size() == 0 )
	{
	    primes.add(Long.valueOf(2));
	    primes.add(Long.valueOf(3));
	}
	// okay we've read in the file, now we need to calculate any remaining primes
	// initialize potential prime to a value 2 greater than our greatest prime
	// we do this since if our greatest prime so far is 17 say, then the next prime 
	// will most certainly not be 18 (because its even) but could be 19 (which is true in this example)
	long potentialPrime = primes.get(primes.size()-1) + 2;
	boolean addedPrimes = false;
	// iterate until the last prime is >= X (to ensure that we have all primes < X
	while ( primes.get(primes.size()-1) < X )
	{    
	    boolean isAPrime = true; // default to true.
	    // now for each potential prime we need to iterate over all the existent primes to determine if the potential prime is a prime
	    for ( int i = 0; i < primes.size(); i++ )
	    {
		// get the value at primes list and if aPrime > the sqrt of potential prime break since we can stop (this is a simple optimization)
		long aPrime = primes.get(i).longValue();
	        if ( aPrime > Math.sqrt(potentialPrime) )
		{
		    break;
		}
		// potential prime needs to be determined if it is a prime, if any prime is modulus of 0 of potential prime then potential prime is NOT a prime
		if (potentialPrime % aPrime == 0 )
		{
		    isAPrime = false;
		    break;
		}
	    }
	    // if potential prime is a prime, then add it to the primes list
	    if ( isAPrime )
            {
                primes.add(Long.valueOf(potentialPrime));
		addedPrimes = true;
            }
	    potentialPrime += 2; // increment by 2 in order to skip all even numbers.
	}
	long stop = System.currentTimeMillis();
	System.out.println("Calculated primes less than " + X + " in " + (stop - start) + "ms");
	if ( addedPrimes )
	{
	    writePrimeFile();
	}
	return primes;
    }

}