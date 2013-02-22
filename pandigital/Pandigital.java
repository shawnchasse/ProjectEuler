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
	 if ( isPandigital( prime.toString(), prime.toString().length() ) )
	 {
	    System.out.println("Found Pandigital Prime: " + prime );
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
	       if ( bld.length() == 9 && isPandigital(bld.toString(),9) )
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
      
      
      boolean isPandigital = isPandigital(bld.toString(),9);
      
      if ( isPandigital )
      {
	 result = i * j;
      }
      return result;
      
   }

   public boolean isPandigital(String num, int n)
   {
      java.util.HashMap<Integer,Integer> digitMap = buildHashMap(n);										      
      Integer zeroVal = Integer.valueOf(0);
      boolean isPandigital = false;
      if ( !containsZero(num) && num.length() == n )
      {
         isPandigital = true;
         for ( char x : num.toCharArray() )
         {
	    
            String tmp = String.valueOf(x);
            Integer val = Integer.parseInt(tmp);
	    if ( digitMap.get(val) != null &&  digitMap.get(val).equals(zeroVal) )
            {
               digitMap.put(val,Integer.valueOf(1));
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

   public java.util.HashMap<Integer,Integer> buildHashMap(int n)
   {
      java.util.HashMap<Integer,Integer> theMap = new java.util.HashMap<Integer,Integer>();
      for ( int i = 1; i <= n; i++ )
      {
	 theMap.put(Integer.valueOf(i),Integer.valueOf(0));
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
