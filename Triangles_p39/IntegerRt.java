package Triangles_p39;

public class IntegerRt
{
   public static void main ( String args[] )
   {
      int maxPerimeter = Integer.parseInt(args[0]);

      int[] solutionCount = new int[maxPerimeter];
      // formulae for generating pythagorian triplets (primitive) is:
      // a = m^2 - n^2
      // b = 2mn
      // c = m^2 + n^2
      // for all m > n

      int m = 1;
      int n = 1;
      while ( n < maxPerimeter ) // short circuit since sum of a + b + c cannot be greater than your max perimeter, and a + b > c for any abc, 
      {
	 m = n + 1;
	 while ( m < maxPerimeter )
	 {
	    // to simplify the formula for getting the perimeter a + b + c we substitute the above formulae for a b and c
	    // m^2 + n^2 + 2mn + m^2 - n^2 => simplifies as:	   
	    // 2m(m + n)
	    if ( areCoprimes(m,n) && ((m - n) %2 != 0) )
	    {
	       int perimeter = 2*m*(m+n);
	       int multiplier = 1;
	       while ( multiplier * perimeter < maxPerimeter )
	       {
		  int a = (multiplier*(m*m - n*n));
		  int b = (multiplier*(2*m*n));
		  int c = (multiplier*(m*m + n*n));		  
//		  System.out.println("a=" + a + " b=" + b + " c=" + c  + 
//				     " p=" + (multiplier*perimeter) + " m:n " + m + ":" + n + " mult=" + multiplier);
		  solutionCount[perimeter*multiplier] += 1;		  
		  multiplier++;
	       }
	    }
	    m++;
	 }
	 n++;
      }

      int maxPerimeterCount = 0;
      int maxPerimeterVal = 0;
      for ( int i = 0; i < solutionCount.length; i++ )
      {
	 if ( solutionCount[i] > maxPerimeterCount )
	 {
	    maxPerimeterCount = solutionCount[i];
	    maxPerimeterVal = i;
	 }
//	 System.out.println("Perimeter " + i + ":" + solutionCount[i] );
      }
      System.out.println("The perimeter less than " + maxPerimeter + " is " + maxPerimeterVal + " with " + maxPerimeterCount + " solutions");
   }
      
      
   public static boolean areCoprimes(long a, long b)
   {
      boolean areCoprimes = false;

      // make sure a is always larger;
      if ( a < b )
      {
	 long d = a;
	 a = b;
	 b = d;
      }
      long r = -1;
      // if remainder is 0 then they aren't coprime, if remainder is 1 then they are
      while ( !(r == 0 || r == 1 ))
      {
	 if ( b == 1 )
	 {
	    r = 1;
	 }
	 else
	 {
	    // r =  a % b and then for the next loop shift b to a and r to b and repeat
	    r = a % b;
	    a = b;
	    b = r;
	 }
      }
      if ( r == 1 )
      {
	 areCoprimes = true;
      }
      return areCoprimes;
   }
   
   
}
