package util;

import java.math.BigInteger;

public class Factorial
{
    private long curFactResult = 0;
    private long curFactDigit = 0;
    public Factorial()
    {

    }
    
    public static void main( String args[])
    {
	long factorial = Long.parseLong(args[0]);
	
	final Factorial factorialGenerator = new Factorial();
	BigInteger result = factorialGenerator.getNFactorial(factorial);

	System.out.println("The result of " + factorial + "! = " + result);
    }
    
    public BigInteger getNFactorial( long N )
    {
	System.out.println("Calculating Factorial for: " + N);
	BigInteger result = BigInteger.ONE;
	if ( N != 1 )
	{
	    result = getNFactorial(N-1).multiply(BigInteger.valueOf(N));
	}
	return result;
    }

    
}