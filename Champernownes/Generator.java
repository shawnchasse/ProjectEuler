package Champernownes;

public class Generator
{
   static int[] digitIndex = { 1, 10, 100, 1000, 10000, 100000, 1000000 };
   public static void main ( String args[] )
   {
      StringBuilder bld = new StringBuilder();
      int current = 1;
      while ( bld.length() < 1000001 )
      {
	 bld.append(current);
	 current++;
      }
      String fract = bld.toString();
      int product = 1;
      for ( int i = 0; i < digitIndex.length; i++ )
      {
	 int curIndex = digitIndex[i];
	 product *= Integer.parseInt(fract.substring(curIndex-1, curIndex));
      }
      System.out.println("The product of the digits at the specified fractional indices is " + product );
      
   }
}
