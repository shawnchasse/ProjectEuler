package Triangle_p12;

import util.Primer;

public class TriangularDivisors
{
    private long curTriangleNum = 1;
    private long curTriangleIncrement = 1;
    private long curTriangleNumDivisors = 0;

    public TriangularDivisors()
    {

    }

    public static void main ( String args[] )
    {

        long numDivisors = Long.parseLong(args[0]);
        final Primer primeHelper = new Primer();
	final TriangularDivisors tDivisors = new TriangularDivisors();
	long maxDivisors = 0;
	
	long start = System.currentTimeMillis();
	while ( tDivisors.getCurTriangleNumDivisors() < numDivisors )
	{
	    tDivisors.getNextTriangleNum();
	    // System.out.println("Working on: " + tDivisors.getCurTriangleNum());
	    final long curDivisors = primeHelper.calculateNumDivisorsOfX(tDivisors.getCurTriangleNum());
	    tDivisors.setCurTriangleNumDivisors(curDivisors);
	    
	    if ( curDivisors >= maxDivisors)
	    {
		maxDivisors = curDivisors;
		System.out.println("Current triangle number: " + tDivisors.getCurTriangleNum() + " has " + curDivisors + " divisors.");
	    }
	    
	}
	long stop = System.currentTimeMillis();
        System.out.println("Time to calculate is: " + ( stop - start) + " ms");
	System.out.println("The first number with " + numDivisors + " divisors or more is " + tDivisors.getCurTriangleNum());
	
	
    }
    public void setCurTriangleNumDivisors(final long numD )
    {
	curTriangleNumDivisors = numD;
    }

    public long getCurTriangleNumDivisors()
    {
	return curTriangleNumDivisors;
    }
    
    public long getNextTriangleNum()
    {
	curTriangleIncrement++;
	curTriangleNum += curTriangleIncrement;
	return curTriangleNum;
    }

    public long getCurTriangleNum()
    {
	return curTriangleNum;
    }
    
}