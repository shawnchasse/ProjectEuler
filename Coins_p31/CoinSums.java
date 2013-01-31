package Coins_p31;

public class CoinSums
{

   private int[] coins = {200,100,50,20,10,5,2,1};
   private java.util.ArrayList<java.util.ArrayList<Integer>> results = new java.util.ArrayList<java.util.ArrayList<Integer>>();

   public CoinSums()
   {

   }															      

   public static void main(String args[])
   {
      int targetPence = Integer.parseInt(args[0]);
      CoinSums sumUp = new CoinSums();
      
      sumUp.calcNumWays(targetPence);
      sumUp.printResultsList();
      System.out.println("The number of ways to calculate " + targetPence + " from the coins 200p,100p,50p,20p,10p,5p,2p,1p is " + sumUp.getNumberWays());
   }

   public int getNumberWays()
   {
      return results.size();

   }

   public void calcNumWays(int target)
   {
      for ( int i = 0; i < coins.length; i++ )
      {  
	 if ( target / coins[i] > 0 )
	 {
	    System.out.println("Performing operation on coin " + coins[i]);
	    java.util.ArrayList<Integer> curResult = new java.util.ArrayList<Integer>(java.util.Collections.nCopies(8,0));
         
	    calcNumWaysToTarget(target, i,i,curResult);
	    break;
	 }
      }
   }

   public void calcNumWaysToTarget(int target, int startIndex, int curIndex, java.util.ArrayList<Integer> inputArray)
   {
      int numTimes = target / coins[curIndex];
      int remainder = target;
      if ( numTimes > 0 )
      {
	 for ( int i = 0; i <= numTimes; i++ )
	 {

	    inputArray.set(curIndex, inputArray.get(curIndex) + i );
	    remainder -= (i * coins[curIndex]);
//	    System.out.println("Adding " + i + " to the input array at position " + curIndex + "(" + coins[curIndex] + ") remainder: " + remainder);	
	    if ( remainder == 0 )
	    {
	       System.out.println("Remainder is 0, found an answer ");
	       results.add(new java.util.ArrayList<Integer>(inputArray));	      
	    }
	    else if ( curIndex < coins.length - 1)
	    {
//	       System.out.println("Recurse:" + remainder + ":" + coins[curIndex + 1]);
	       calcNumWaysToTarget(remainder,startIndex, curIndex + 1, inputArray);
	    }
	    remainder += (i * coins[curIndex]);
	    inputArray.set(curIndex, inputArray.get(curIndex) - i);
	    //  	    System.out.println("Removing " + i + " to the input array at position " + curIndex + "(" + coins[curIndex] + ") remainder: " + remainder);
	 }
      }
     	    
   }

   public void printSingleResult(java.util.ArrayList<Integer> list)
   {
      System.out.print("[");
      int sum = 0;
      for ( int i = 0; i < list.size(); i++ )
      {
	 sum += coins[i] * list.get(i);
	 System.out.print( list.get(i) + "x" + coins[i] + ", " );
      }
      System.out.print("] sum=" + sum + "\n");
   }

   public void printResultsList()
   {
      for( java.util.ArrayList<Integer> list : results )
      {
	 printSingleResult(list);
      }

   }
}
