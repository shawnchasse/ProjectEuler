package Spiral_p28;

import java.math.BigInteger;

public class SpiralDiagonal
{
   public static void main( String args[] )
   {
      int gridDimension = Integer.parseInt(args[0]);
      
      // The number of 'tiers' in a grid is the grid dimension -2. This tells us how many 
      // 2^n groupings we will have starting at n=0 for the central point and going out from
      // there. The value of the corners is equal to the following:
      // 
      //   curValue + 2^(tier-1) where tier 1 is the center of the spoke. 
      //   For every tier except the first there are 4 values representing the 4 corners
      //
      long curValue = 1; // start at one since that is what will always be at center.
      long sum = 1;
      int tier = 1; // start at tier 1 (aka the second ring) 

      // go to grid dimension since an nxn grid has n-2 tiers
      while ( tier <= (gridDimension - 1)/2 )
      {
	 // for each tier we calculate 4 values.
	 for ( int i = 0; i < 4; i++ )
	 {
	    curValue += tier*2;
	    sum += curValue;
	 }
	 tier++;
      }
      System.out.println("The sum of the diagonals in a " + gridDimension + "x" + gridDimension + " grid is " + sum);
      
   }
}
