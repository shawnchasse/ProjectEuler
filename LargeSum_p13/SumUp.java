package LargeSum_p13;

import java.math.BigInteger;

public class SumUp 
{
    private static BigInteger sum = new BigInteger("0");
    public static void main(String args[])
    {
	String inFile = args[0];
	java.io.File inputFile = new java.io.File(inFile);
	if( inputFile.exists() )
	{
	    java.io.BufferedReader in = null;
	    try
	    {
	       java.io.FileReader fReader = new java.io.FileReader(inputFile);
	       in = new java.io.BufferedReader(fReader);
	       String curIn = "";
	       while ( (curIn = in.readLine()) != null )
	       {
		   BigInteger tmpIn = new BigInteger(curIn);		   
		   sum = sum.add(tmpIn);
		   System.out.println("The line is " + tmpIn + " and sum so far is " + sum);
	       }
	       String sumString = sum.toString();
	       System.out.println("The sum of the inputs is " + sumString);
	       System.out.println("The first ten digits of that sum are " + sumString.substring(0,10));
	    }
	    catch ( java.io.IOException ioe )
	    {
		System.out.println("IO error while reading file " + ioe.getMessage());
	    }
	}
	else
	{
	    System.out.println("Please provide a valid file for input");
	}
    }
}