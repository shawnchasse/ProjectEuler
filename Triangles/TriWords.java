package Triangles;

public class TriWords
{
   public static void main (String args[])
   {
      String wordFile = args[0];
      String[] words = null;

      // read the file in
      java.io.BufferedReader in = null;
      try
      {
	 java.io.FileReader fReader = new java.io.FileReader(wordFile);
	 in = new java.io.BufferedReader(fReader);
	    
	 String curLine = "";
	 while ( (curLine = in.readLine()) != null )
	 {
	    // this file is formatted so each word is separated by a command and ecapsulated by quotes.
	    words = curLine.split(",");	    
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
      
      // first generate the triangle numbers up to some value
      // in reality if we had a 20 letter word with all z's that 
      // would be 520 which the 31st triangl number is 521 so 200 is sufficient
      int[] triangleNums = new int[200];
      System.out.print( "TriangleNumbers: " );
      for ( int i = 0; i < 200; i++ )
      {
	 int triNum = ((i+1) * ( i + 2 ))/2;
	 triangleNums[i] = triNum;
	 System.out.print( i + ":" + triNum + ", " );
      }
      System.out.print("\n");

      
      int triangleWordCount = 0;
      for ( String word : words )
      {
	 // need to remove the beginning and trailing quote " so get a substring that excludes them
         String theWord = word.substring(1,word.length()-1);
         // put the string to a character array so we can do integer math
         char[] chars = theWord.toCharArray();
	 
	 int wordSum = 0; 
	 for ( char aChar : chars )
	 {
	    // the character value is the character minus the letter  'A' (names are all uppercase) plus 1 (so A is 1 and not 0)
            int charVal = aChar - 'A' + 1;
	    wordSum += charVal;
	 }
	 System.out.println("Looking to see if " + theWord + " with value " + wordSum + " is a triangle word ");
	 // for fun, utilize both the binary search of the array to lookup the triangle number and the equation to lookup whether it is a triangle number
	 if ( isTriangleNumber(wordSum, triangleNums, 0, triangleNums.length - 1 ) && isTriangleNumberEquation(wordSum))
	 {
	    triangleWordCount++;
	 }

      }
      System.out.println("The number of triangle words is " + triangleWordCount );      
   }

   // alternative method is to use the inverse (positive side) of the triangle number equation.
   public static boolean isTriangleNumberEquation(int num )
   {
      int sqrt = (int) java.lang.Math.sqrt(num * 2 );
      return sqrt * (sqrt +1 ) == num * 2;
   }
   
   // use a binary search to look up the triangle number since the triNums array is sorted.
   public static boolean isTriangleNumber(int num, int[] triNums, int a, int b)
   {
      boolean isTriNum = false;
      
      if ( a <= b )
      {
	 int mid = a + ((b - a) / 2); // floor of the division due to integer arithmetic
	 
	 if ( triNums[mid] == num )
	 {
	    System.out.println("Looking for " + num + " and found it at " + a );
	    return true;
	 }
	 else if ( triNums[mid] < num )
	 {
	    isTriNum = isTriangleNumber(num, triNums, mid + 1, b );
	 }
	 else
	 {
	    isTriNum = isTriangleNumber(num, triNums, a, mid - 1);
	 }
      }
      return isTriNum;
      
   }
}
