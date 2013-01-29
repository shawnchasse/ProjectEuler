package util;

public class TriangleGrid
{

   private java.util.ArrayList<java.util.ArrayList<Integer>> triGrid = null; 
   public TriangleGrid()
   {

   }

   public static void main(String args[])
   {
      String inputFile = args[0];
      TriangleGrid grid = new TriangleGrid();
      grid.readTriangleFile(inputFile);
      grid.findLargestSumInGrid();
   }

   public void findLargestSumInGrid()
   {
      // to find the largest sum we could start at the top and work our way down. This would involve
      // an exhaustive search of all paths. As projecteuler.net/problem=18 specifies this is fine for problem
      // 18 which will have 16384 total paths, but for problem 67, we see that the total paths would be 2^99!
      // so to reduce the problem to a manageable level i believe the trick is to start at the bottom and work 
      // our way up by finding all the max sum for each level starting with N-2 (0 indexed array would be n-1, 
      // but we also want to start at the next to last level so n-2)
      for ( int i = triGrid.size()-2; i >= 0; i-- )
      {
	 // first get the row we're interested in:
	 java.util.ArrayList<Integer> curRow = triGrid.get(i);
	 // next get the next row:
	 java.util.ArrayList<Integer> nextRow = triGrid.get(i+1);
	 // now iterate through curRow, finding max sum of curRow[x], and nextRow[x] and nextRow[x+1]
	 for ( int x = 0; x < curRow.size(); x++)
	 {
	    int curVal = curRow.get(x).intValue();
	    int sumA = nextRow.get(x).intValue() + curVal;
	    int sumB = nextRow.get(x+1).intValue() + curVal;
	   
	    int result = sumA > sumB ? sumA : sumB;
	    
	    curRow.set(x,Integer.valueOf(result));	   
	 }
      }
      System.out.println("The path with the largest sum results in a value of " + triGrid.get(0).get(0) );
   }

   public void readTriangleFile(String inputFile)
   {
      
      // first read in the file and build the tree.
      java.io.File triFile = new java.io.File(inputFile);
      if ( triFile.exists() )
      {
	 int levels = 0;
	 StringBuilder bld = new StringBuilder("");
	 java.io.BufferedReader in = null;
	 try
	 {
	    java.io.FileReader fReader = new java.io.FileReader(triFile);
	    in = new java.io.BufferedReader(fReader);
	    
	    String curLine = "";
	    

	    while ( (curLine = in.readLine()) != null )
	    {	      
	       if ( bld.length() != 0 )
	       {
		  bld.append(",");
	       }
	       bld.append(curLine);
	       levels++;
	    }
	 }
	 catch ( java.io.IOException ioe )
	 {
	    System.out.println("IO Exception encountered: " + ioe);
	 }
	 finally
	 {
	    try
	    {
	       in.close();
	    }
	    catch ( java.io.IOException ioe )
	    {
		   System.out.println("IOException during close");
	    }
	    
	 }
	 triGrid = new java.util.ArrayList<java.util.ArrayList<Integer>>(levels);
	 // each row is comma separated
	 String[] inputLevels = bld.toString().split(",");
	 for ( int j = 0; j < inputLevels.length; j++ )
	 {
	    // the data in each row is space separated.
	    String[] rowData = inputLevels[j].split(" ");
	    java.util.ArrayList<Integer> rowArr = new java.util.ArrayList<Integer>(rowData.length);
	    for ( int i = 0; i < rowData.length; i++ )
	    {
	       rowArr.add(i,Integer.valueOf(rowData[i]));
	    }
	    triGrid.add(j,rowArr);
	 }

	 for ( int i = 0; i < triGrid.size(); i++ )
	 {
	    java.util.ArrayList<Integer> row = triGrid.get(i);
	    for ( int j = 0; j < row.size(); j++ )
	    {
	       System.out.print(row.get(j) + " ");
	    }
	    System.out.print("\n");
	 }
      
      }
      
   }

   

}
