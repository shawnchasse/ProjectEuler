package Triangle_p18_67;

import util.TriangleGrid;

public class MaxPathSum
{
   public MaxPathSum()
   {

   }
   public static void main( String args[] )
   {
      String inputFile = args[0];
      TriangleGrid grid = new TriangleGrid();
      grid.readTriangleFile(inputFile);
      grid.findLargestSumInGrid();

   }
}
