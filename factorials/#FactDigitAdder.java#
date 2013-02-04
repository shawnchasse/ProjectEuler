package factorials;

import util.Factorial;
import java.math.BigInteger;

public class FactDigitAdder 
{
    public static void main(String args[])
    {
	final long factorial = Long.parseLong(args[0]);

	final Factorial factorialHelper = new Factorial();
	
	BigInteger result = factorialHelper.getNFactorial(factorial);

	System.out.println("Result of " + factorial + "! is " + result.toString());
	long sumOfResult = 0;
	for ( char digit : result.toString().toCharArray() )
	{
	    System.out.println("Getting long value for digit " + digit);
	    sumOfResult += Long.parseLong(String.valueOf(digit));

	}    
	System.out.println("Sum of digits of " + factorial + "! is " + sumOfResult );
    }
}
