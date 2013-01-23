package Collatz_p14;

public class CollatzSequence
{
    
    public static void main( String args[] )
    {
	long maxVal = Long.parseLong(args[0]);
	long start = System.currentTimeMillis();
	long longestChainProducer = findLongestChain(maxVal);
	System.out.println("Execution time is " + (System.currentTimeMillis() - start) + "ms.");
	System.out.println("The number that produces the longest chain less than " + maxVal + " is " + longestChainProducer );
	
	
    }

   private static long findLongestChain(long maxVal)
   {
      long maxSequence = 1;
      long maxSequenceProducer = 1;
      for ( int i = 2; i < maxVal; i++ )
      {
	 long initialVal = i;
	 long seqNum = 1;
	 while ( initialVal != 1 )
	 {
	    initialVal = findNextVal(initialVal);
	    seqNum++;
	 }
	 //System.out.println("Chain length for " + i + " is " + seqNum);
	 if ( seqNum > maxSequence )
	 {
	    maxSequence = seqNum;
	    maxSequenceProducer = i;
	 }
	 
      }
      return maxSequenceProducer;
   }


    private static long findNextVal ( long curVal )
    {
	long next = 1;
	if ( curVal % 2 != 0 )
	{
	    next = findNextFromOdd(curVal);
	}
	else
	{
	    next  = findNextFromEven(curVal);
	}
	return next;
    }

   private static long findNextFromOdd( long curVal )
   {
      long next = 1;
      next = (3 * curVal) + 1;
      return next;
   }

   private static long findNextFromEven( long curVal )
   {
      long next = 1;
      next = curVal / 2;
      return next;
   }
}
