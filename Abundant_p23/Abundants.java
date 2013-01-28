package Abundant_p23;

public class Abundants
{
   public static void main(String args[])
   {
      int maxAbundant = 28123;
      int[] abundantNums = new int[maxAbundant];
      int[] abundantSums = new int[maxAbundant];
      
      // loop through all integers < 28123
      long start = System.currentTimeMillis();
      for ( int i = 2; i < maxAbundant; i++ )
      {
	 int sumDivs = calcSumDivisors(i);
	 if ( sumDivs > i )
	 {
	    // integer i is an abundant number. mark its index to identify as such
	    System.out.print("\rAbundant: " + i );
	    abundantNums[i] = 1;
	 }
	 // now iterate through all the abundant nums and add i + j if and only if i and j are both abundant
	 for ( int j = 0; j < maxAbundant; j++ )
	 {
	    if ( abundantNums[j] == 1 && abundantNums[i] == 1)
	    {
	       int tmpSum = j + i;
	       //System.out.println(i + " + " + j + " = " + tmpSum );	       
	       // if the sum < max value then mark it in the sums array
	       if ( tmpSum < maxAbundant )
	       {
		  abundantSums[tmpSum] = 1;
	       }
	    }
	 }
	 
      }
      
      // now iterate through the sums array and find all numbers that haven't been marked as abundant sums.
      int sumNonAbundantSums = 0;
      for ( int k = 0; k < maxAbundant; k++ )
      {
	 if ( abundantSums[k] == 0 )
	 {
	    //System.out.println("Found " + k + " to be a non-abundant sum");
	    sumNonAbundantSums += k;
	 }
      }
      long stop = System.currentTimeMillis();
      System.out.println("\nThe sum of all numbers that are don't have 2 abundants sums is: " + sumNonAbundantSums + " (calculated in " + (stop-start) + "ms)");
   }
   
   private static int calcSumDivisors(int val)
   {
      int sum = 0;
      for ( int i = 1; i < val; i++ )
      {
	 if ( val % i == 0 )
	 {
	    sum += i;
	 }
      }
      return sum;
   }
}
