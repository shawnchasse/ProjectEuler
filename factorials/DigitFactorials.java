package factorials;

import util.Factorial;
import java.math.BigInteger;

public class DigitFactorials
{
   public static void main(String args[])
   {
      java.util.ArrayList<BigInteger> factorialList = new java.util.ArrayList<BigInteger>(java.util.Collections.nCopies(10,BigInteger.valueOf(0)));
      final Factorial factorialHelper = new Factorial();

      for ( int i = 0; i< 10; i++ )
      {
	 BigInteger curFactorial = factorialHelper.getNFactorial(i);
	 factorialList.set(i,curFactorial);
      }

      long totalSum = 0;
      for ( int j = 3; j < 50000; j++ )
      {
	 String current = String.valueOf(j);
	 long sum = 0;
	 System.out.print("Working on " + j + " ");
	 for ( char x : current.toCharArray() )
	 {
	    int val = Integer.parseInt(String.valueOf(x));
	    System.out.print(val + "!=" + factorialList.get(val) + " ");
	    sum += factorialList.get(val).longValue();
	 }
	 if ( sum == j )
	 {
	    System.out.println(j + " is the sum of it's digit factorials!");
	    totalSum += sum;
	 }
	 System.out.print( + sum + " \n");
      }
      System.out.println("Total sum of all digit factorial numbers is " + totalSum);
      

   }
}
