package LexiPermute_p24;

public class Lexicographic
{
   private int numDigits = 0;
   private int numPermutations = 0;
   private int permutations = 0;
   private String currentPermutation = "";			       
   private long start = 0;			       

   public Lexicographic(int digits, int perms)
   {
      numDigits = digits;
      numPermutations = perms;
   }

   public long getStart()
   {
      return start;
   }

   public String getCurrentPermutation()
   {
      return currentPermutation;
   }

   public int getPermutations()
   {
      return permutations;
   }
				     
   public static void main(String args[])
   {
      int numDigits = Integer.parseInt(args[0]);
      int numPermutations = Integer.parseInt(args[1]);
      
      Lexicographic lexi = new Lexicographic(numDigits, numPermutations);
      lexi.calculateNthPermutation();					     
      System.out.println("The " + lexi.getPermutations() + "th permutation is " + lexi.getCurrentPermutation() + " (" + (System.currentTimeMillis() - lexi.getStart()) + "ms)");
   }

   public void permutation(String prefix, String str)
   {
      int len = str.length();
      if ( len == 0 )
      {
	 permutations++;
	 currentPermutation = prefix;
	 if ( permutations == numPermutations )
	 {
	    System.out.println("The " + numPermutations + "th permutation is " + prefix  + " (" + (System.currentTimeMillis() - start) + "ms)");
	 }
      }
      else 
      {
	 for ( int i = 0; i < len; i++ )
	 {
	    permutation(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1, len));
	 }
      }
   }

   public void calculateNthPermutation()
   {
      start = System.currentTimeMillis();
      permutations = 0;
      // first generate an array of the numbers
      StringBuilder bld = new StringBuilder();
      for( int i = 0; i < numDigits; i++ )
      {
         bld.append(i);
      }
      
      permutation("",bld.toString());

   }
   
}
