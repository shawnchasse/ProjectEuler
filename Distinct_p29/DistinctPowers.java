package Distinct_p29;

import java.util.HashSet;
import java.math.BigInteger;


public class DistinctPowers
{
   public static void main(String args[] )
   {
      int maxTerm = Integer.parseInt(args[0]);
      
      HashSet<BigInteger> results = new HashSet<BigInteger>();
      
      for ( long i = 2; i <= maxTerm; i++ )
      {
	 for (  int j = 2; j <= maxTerm; j++ )
	 {
	    BigInteger base = BigInteger.valueOf(i);
	    results.add(base.pow(j));
	 }
      }
      System.out.println("The number of distinct terms for a^b where 2 <= a <= " + maxTerm + " and 2 <= b <= " + maxTerm + " is " + results.size());
   }
}
