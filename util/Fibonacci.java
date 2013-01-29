package util;


import java.math.BigInteger;

public class Fibonacci
{
   java.util.ArrayList<BigInteger> fibonaccis = new java.util.ArrayList<BigInteger>();
   BigInteger prev1 = BigInteger.valueOf(1);
   BigInteger prev2 = BigInteger.valueOf(0); 					    
   int curIndex = 0;

   public Fibonacci()
   {

   }

   public static void main (String args[])
   {
      int nDigits = Integer.parseInt(args[0]);
      Fibonacci fib = new Fibonacci();
      fib.findFibonacciWithNDigits(nDigits);
   }
   
   public void findFibonacciWithNDigits(int nDigits)
   {
      BigInteger cur = BigInteger.valueOf(1);      
      fibonaccis.add(curIndex,cur);
      curIndex++;
      while ( cur.toString().length() < nDigits )
      {
	 cur = prev1.add(prev2);
	 prev2 = prev1;
	 prev1 = cur;
	 
	 //System.out.println("Adding " + cur + " to the list at index " + curIndex );
	 fibonaccis.add(curIndex,cur);
	 curIndex++;	 
      }
      System.out.println("The fibonacci number with " + nDigits + " digits is F" + curIndex + " is " + fibonaccis.get(curIndex-1) );
   }
}
