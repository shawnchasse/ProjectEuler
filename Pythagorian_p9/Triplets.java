package Pythagorian_p9;

public class Triplets
{

   public static void main (String args[])
   {
      // generating a pythagorian triple according to euclid's formula:
      // a = m^2 - n^2
      // b = 2mn
      // c = m^2 + n^2
      int m = 1;
      
      boolean found = false;
      while ( m < 1000 )
      {
	 int n = 1;
	 while ( n < 1000 )
	 {
	    int m2 = m*m;
	    int n2 = n*n;
	    int a = m2 - n2;
	    int b = 2 * m * n;
	    int c = m2 + n2;
	    if ( (a + b + c)  == 1000 && a > 0 && b > 0 && c > 0)
	    {
	       System.out.println("\nFound triplet of " + a + " + " + b + " + " +  c + " = 1000. Product is: " + (a*b*c) );
	       found = true;
	       break;
	    }
	    n++;
	 }
	 m++;
	 if (found)
	 {
	    break;
	 }
      }
      
   }
}
