package NameScore_p22;

public class NameScore
{
   public static void main(String args[])
   {
      java.util.TreeMap<String, Integer> nameMap = new java.util.TreeMap<String,Integer>();

      java.io.File namesFile = new java.io.File("names.txt");
      java.io.BufferedReader in = null;
      String[] names = null;
      
      try
      {
	 java.io.FileReader fReader = new java.io.FileReader(namesFile);
	 in = new java.io.BufferedReader(fReader);
	 
	 String curLine = "";
	 // in this case the file is one big line
	 while ( (curLine = in.readLine()) != null )
	 {
	    // all the names are of the form "NAME" with commans separating, so simply split on the comma
	    names = curLine.split(",");
	 }
      }
      catch ( java.io.IOException ioe )
      {
	 System.out.println("Error reading from input file names.txt: " + ioe.getMessage() );
      }

      // now iterate over the names array
      for ( String aName : names )
      {
	 // need to remove the beginning and trailing quote " so get a substring that includes them
	 String theName = aName.substring(1,aName.length()-1);
	 // put the string to a character array so we can do integer math
	 char[] chars = theName.toCharArray();
	 int nameSum = 0;
	 for ( char aChar : chars )
	 {
	    // the character value is the character minus the letter  'A' (names are all uppercase) plus 1 (so A is 1 and not 0)
	    int charVal = aChar - 'A' + 1;
	    //System.out.println("Character " + aChar + " is worth " + charVal);
	    // add the value of the character to the name sum
	    nameSum += charVal;
	 }
	 //System.out.println(theName + " is worth " + nameSum);
	 // Now put the name and the name sum into the treeset (auto sorting!)
	 nameMap.put(theName,Integer.valueOf(nameSum));
      }
      int namePos = 1;
      int nameScoreTotal = 0;
      // Finally simply iterate through the navigable set and take the position * the namesum and add it to the total.
      for ( String key : nameMap.navigableKeySet() )
      {
	 
	 int nameProduct = nameMap.get(key) * namePos;
	 //System.out.println(key + " is worth " + nameMap.get(key) + " and is position " + namePos + " for a result of " + nameProduct);
	 nameScoreTotal += nameProduct;
	 namePos++;
      }
      System.out.println("The sum of all the name products is " + nameScoreTotal );
   }
}
   
