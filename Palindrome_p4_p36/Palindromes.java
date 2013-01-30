package Palindrome_p4_p36;

class Palindromes 
{

   private static String problem4 = "product";
   private static String problem36 = "doublebase";

   public Palindromes()
   {

   }


   public static void main (String args[])
   {
      final String solveFor = args[0];

      
      if ( solveFor.equals(problem4) )
      {
	 final int numDigits = Integer.parseInt(args[1]);
	 findLargestPalindromeProduct(numDigits);
      }
      else if ( solveFor.equals(problem36) )
      {
	 final int maxVal = Integer.parseInt(args[1]);
	 findDoubleBasePalindromes(maxVal);
      }
      else
      {
	 System.out.println("No problem available for argument " + solveFor + " valid options for argument 0 are " + problem4 + " or " + problem36 );
      }
      
      
   }

   public static void findDoubleBasePalindromes(int maxVal)
   {
      long sum = 0;
      for ( int i = 0; i < maxVal; i++ )
      {
	 if ( isPalindrome(Integer.toString(i)) )
	 {
	    if ( isPalindrome(Integer.toBinaryString(i)) )
	    {
	       System.out.println("Palindromic in base 10 and base 2: " + i + ":" + Integer.toBinaryString(i) );
	       sum += i;
	    }
	 }
      }
      System.out.println("The sum of all Double-Palindromic numbers below " + maxVal + " is " + sum);
   }

   public static void findLargestPalindromeProduct(int numDigits)
   {
      long maxDigit = ((long)Math.pow(10,numDigits) - (long)1);
      long lowDigit = ((long)Math.pow(10,numDigits - 1) - (long)1); // optimization, if we have 3 digits we don't need to compare any 2 digit numbers
      System.out.println("Max = " + maxDigit );
      System.out.println("Low = " + lowDigit );
      
      long outer = maxDigit;
      long inner = maxDigit; 
      long largestPalindrome = 0;
      long start = System.currentTimeMillis();
      // This is very brute-forcey, but works relatively fast for the target problem of 3 digit multipliers, at 4 digits it's still acceptable but 5 is pretty slow running around 10 minutes.
      while ( outer > lowDigit )
      {
	 while ( inner > lowDigit )	
	 {
	    final long result = outer * inner;
	    if ( isPalindrome(String.valueOf( result  )) )
	    {
	       //System.out.println("Palindrome of " + result + " from " + outer + " and " + inner);
	       if ( largestPalindrome < result )
	       {
		  largestPalindrome = result;
	       }
	    }
	    inner--;
	 }
	 outer--;
	 if ( inner <= lowDigit )
	 {
	    inner = outer - 1;
	 }	    
      }
      long stop = System.currentTimeMillis();
      System.out.println("Total Time: " + (stop - start) + "ms");
      System.out.println("Largest palindrome: " + largestPalindrome );
   }

   private static boolean isPalindrome(final String number )
   {
      boolean palindromic = false;
      final StringBuilder orig = new StringBuilder(number);
      final StringBuilder rev = new StringBuilder(number);
      final String original = orig.toString();
      final String reverse = rev.reverse().toString();
      if ( original.equals(reverse) )
      {
	 palindromic = true;
      }
      return palindromic;
   }
}
