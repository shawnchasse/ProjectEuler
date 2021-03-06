package Lattice_p15;

public class LatticePath
{

   public static void main( String args[] )
   {
      int gridSize = Integer.parseInt(args[0]);
      long numPaths = buildGrid(gridSize);
      System.out.println("\nThe number of paths for a " + gridSize + "x" + gridSize + " grid is " + numPaths);      
   }

   public static long buildGrid(int size)
   {
      long start = System.currentTimeMillis();
      long numPaths = traverse(0,0,size);
      long stop = System.currentTimeMillis();
      System.out.println("Time to traverse: " + (double)((stop-start)/60000.0) + " minutes");
      return numPaths;
   }
   
   public static long traverse( int x, int y, int size )
   {
      //System.out.print("\rTraversing grid with x:y " + x + ":" + y);
      long paths = 0;
      if ( x == size && y == size )
      {
	 //System.out.println("Found a path!" );
	 paths = 1;	 
      }
      else
      {
	 int nextX = x + 1;
	 if(nextX <= size)
	 {
	    paths += traverse(nextX,y,size);
	 }
	 int nextY = y + 1;
	 if(nextY <= size)
	 {
	    paths += traverse(x,nextY,size);
	 }
      }

      return paths;
      
   }
}
