package pandigital;

import util.Primer;
import java.util.ArrayList;

public class Pandigital
{
   java.util.HashSet<Long> pandigitalProductsSet = new java.util.HashSet<Long>();

   public Pandigital()
   {

   }

   public static void main(String args[])
   {
      Pandigital products = new Pandigital();
      long sumOfPandigitals = products.findPandigitalProducts();
      System.out.println("The sum of all pandigital products containing digits 1-9 is " + sumOfPandigitals);
      
      long pandigitalMultiple = products.findPandigitalMultiples();
      System.out.println("The largest 1-9 pandigital 9-digit number formed as the concatenated product of an integer (1,2,... , n) is " + pandigitalMultiple);

      long pandigitalPrime = products.findPandigitalPrime();
      System.out.println("The largest n-digit pandigital prime number is " + pandigitalPrime );

      long pandigitalSumSubStringDivisible = products.findPandigitalSubStringDivisibilitySum();
      System.out.println("Sum of all 0 to 9 pandigital numbers with special divisibility is " + pandigitalSumSubStringDivisible );
   }


   public boolean isSubStringDivisibility(String digitStr )
   {
      System.out.print("Checking " + digitStr + "\r");
      // now if it is do the division
      // digits 2,3,4 divisible by 2
      // digits 3,4,5 divisible by 3
      // digits 4,5,6 divisible by 5
      // digits 5,6,7 divisible by 7
      // digits 6,7,8 divisible by 11
      // digits 7,8,9 divisible by 13
      // digits 8,9,10 divisible by 17
      int[] subStart = {1,2,3,4,5,6,7};
      int subLength = 3;
      int[] subDivisor = {2,3,5,7,11,13,17};
      boolean fullyDivisible = true;
      for ( int j = 0; j < subStart.length; j++ )
      {
	 int endIndex = subStart[j] + subLength;
	 int subDigit = 0;
	 if ( endIndex >= digitStr.length() )
	 {
	    subDigit = Integer.parseInt(digitStr.substring(subStart[j]));
	 }
	 else
	 {
	    subDigit = Integer.parseInt(digitStr.substring(subStart[j],endIndex));
	 }
	 if ( subDigit % subDivisor[j] != 0 )
	 {
	    fullyDivisible = false;
	    break;
	 }
      }
      return fullyDivisible;
   }
 
   public long permute(String prefix, String str)
   {
      long sum = 0;
      int len = str.length();
      if ( len == 0 )
      {
	 // we are at a permutation since the suffix str is length 0;
	 if ( isSubStringDivisibility(prefix) )
	 {
	    return Long.parseLong(prefix);
         }
      }
      else
      {
         for ( int i = 0; i < len; i++ )
         {
            sum += permute(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1, len));
         }
      }
      return sum;
      
   }
 
   public long findPandigitalSubStringDivisibilitySum()
   {
      String digits =  "0123456789";
      long sum = permute("",digits);
      return sum;
   }
  

   public long findPandigitalPrime()
   {
      Primer primeGenerator = new Primer();
      int maxPrime = 10000000;
      System.out.println("Getting primes less than " + maxPrime);
      ArrayList<Long> primeArray = primeGenerator.getPrimesLessThanX(maxPrime);
      
      System.out.println("Looking for pandigital primes");
      long largestPandigitalPrime = 0;
      for ( Long prime : primeArray )
      {	
	 
	 if ( !containsZero(prime.toString()) && isPandigital( prime.toString(), prime.toString().length(), 1 ) )
	 {
	    //System.out.println("Found Pandigital Prime: " + prime );
	    if ( prime.longValue() > largestPandigitalPrime )
	    {
	       largestPandigitalPrime = prime.longValue();
	    }
	 }
      }
      return largestPandigitalPrime;
   }

   public long findPandigitalMultiples()
   {
      long maxPandigitalMultiple = 0;
      // need to find the concatenated product of an integer x whose concatenated product i s x*1, x*2, ... x*n 
      for ( int i = 1; i < 1000; i++ )
      {
	 StringBuilder bld = new StringBuilder();
	 for ( int j = 1; j < 10; j++ )
	 {
	    int cur = i * j;
	    if ( !containsZero(String.valueOf(cur)) )
	    {
	       bld.append(cur);

	       if ( !containsZero(bld.toString()) && bld.length() == 9 && isPandigital(bld.toString(),9,1) )
	       {
		  long curPandigital = Long.parseLong(bld.toString());
		  if ( curPandigital > maxPandigitalMultiple )
		  {
		     maxPandigitalMultiple = curPandigital;
		  }

	       }
	    }
	 }
	 
      }
      return maxPandigitalMultiple;
   }
   
   public long findPandigitalProducts()
   {
      long pandigitalSum = 0;
      // Need to find the sum of all pandigital numbers whose product and multipicand and multiplier contain digits 1-9 each once.
      for ( int i = 1; i < 10000; i++ )
      {
	 if ( !containsZero(String.valueOf(i)) )
	 {
	    for( int j = 1; j < 1000; j++ )
	    {
	       if ( !containsZero(String.valueOf(j)) )
	       {
		  long result = getPandigitalSum(i,j);
		  if ( result != 0 )
		  {
		     //System.out.println("The number " + ( i * j ) + " = " + i + " x " + j + " is pandigital! ");
		     pandigitalProductsSet.add(result);
		  }
	       }
	    }
	 }
      }
      for ( Long onePandigital : pandigitalProductsSet )
      {
	 //System.out.println("Adding product: " + onePandigital);
	 pandigitalSum += onePandigital.longValue();
      }


      return pandigitalSum;
   }

   public long getPandigitalSum(int i, int j)
   {
      
      long result = 0;
      
      StringBuilder bld = new StringBuilder();
      bld.append(i);
      bld.append(j);
      bld.append((i*j));
      
      boolean isPandigital = false;
      if ( !containsZero(bld.toString() ) )
      { 
	 isPandigital = isPandigital(bld.toString(),9,1);
      }
      
      if ( isPandigital )
      {
	 result = i * j;
      }
      return result;
      
   }

   public boolean isPandigital(String num, int n, int start)
   {
      java.util.HashMap<Integer,Boolean> digitMap = buildHashMap(n, start);  
      boolean isPandigital = false;
      if ( num.length() == n )
      {
         isPandigital = true;
         for ( char x : num.toCharArray() )
         {
	    
            String tmp = String.valueOf(x);
            Integer val = Integer.parseInt(tmp);
	    if ( digitMap.get(val) != null &&  digitMap.get(val).equals(Boolean.FALSE) )
            {
               digitMap.put(val,Boolean.TRUE);
            }
            else
            {
               isPandigital = false;
               break;
            }
         }
      }
      return isPandigital;
   }

   public java.util.HashMap<Integer,Boolean> buildHashMap(int n,int start)
   {
      java.util.HashMap<Integer,Boolean> theMap = new java.util.HashMap<Integer,Boolean>();
      for ( int i = start; i <= n; i++ )
      {
	 theMap.put(Integer.valueOf(i),Boolean.FALSE);
      }
      return theMap;
   }

   public boolean containsZero(String str)
   {
      boolean containsZero = false;
      
      if (str.contains("0"))
      {
	 containsZero = true;
      }
      return containsZero;

   }
}
