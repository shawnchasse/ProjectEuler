class Palindromes 
{
    public static void main (String args[])
    {
	final int numDigits = Integer.parseInt(args[0]);
        long maxDigit = ((long)Math.pow(10,numDigits) - (long)1);
	long lowDigit = ((long)Math.pow(10,numDigits - 1) - (long)1); // optimization, if we have 3 digits we don't need to compare any 2 digit numbers
	System.out.println("Max = " + maxDigit );
	System.out.println("Low = " + lowDigit );
	
	long outer = maxDigit;
	long inner = maxDigit; 
	long largestPalindrome = 0;
	long start = System.currentTimeMillis();
	// This is very brute-forcey, but works relatively fast for the target problem of 3 digit multipliers
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