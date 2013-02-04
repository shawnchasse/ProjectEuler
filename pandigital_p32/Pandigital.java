package pandigital_p32;

public class Pandigital
{
   java.util.HashSet<Long> pandigitalProductsSet = new java.util.HashSet<Long>();
   public Pandigital()
   {

   }

   public static void main(String args[])
   {
      Pandigital products = new Pandigital();
      long sumOfPandigitals = products.findPandigitalProducts();
      System.out.println("The sum of all pandigital products containing digits 1-9 is " + sumOfPandigitals);
   }
   
   public long findPandigitalProducts()
   {
      long pandigitalSum = 0;
      // Need to find the sum of all pandigital numbers whose product and multipicand and multiplier contain digits 1-9 each once.
      for ( int i = 1; i < 10000; i++ )
      {
	 if ( !containsZero(i) )
	 {
	    for( int j = 1; j < 10000; j++ )
	    {
	       if ( !containsZero(j) )
	       {
		  long result = getPandigitalSum(i,j);
		  if ( result != 0 )
		  {
		     System.out.println("The number " + ( i * j ) + " = " + i + " x " + j + " is pandigital! ");
		     pandigitalProductsSet.add(result);
		  }
	       }
	    }
	 }
      }
      for ( Long onePandigital : pandigitalProductsSet )
      {
	 System.out.println("Adding product: " + onePandigital);
	 pandigitalSum += onePandigital.longValue();
      }


      return pandigitalSum;
   }

   public long getPandigitalSum(int i, int j)
   {
      Integer zeroVal = Integer.valueOf(0);
      long result = 0;
      java.util.HashMap<Integer,Integer> digitMap = buildHashMap();
      StringBuilder bld = new StringBuilder();
      bld.append(i);
      bld.append(j);
      bld.append((i*j));
      
      
      boolean isPandigital = false;
      if ( !containsZero(i*j) && bld.length() == 9 )
      {
	 isPandigital = true;
	 for ( char x : bld.toString().toCharArray() )
	 {
	    String tmp = String.valueOf(x);
	    Integer val = Integer.parseInt(tmp);
	    if ( digitMap.get(val).equals(zeroVal) )
	    {
	       digitMap.put(val,Integer.valueOf(1));
	    }
	    else
	    {
	       isPandigital = false;
	       break;
	    }
	 }
      }
      if ( isPandigital )
      {
	 result = i * j;
      }
      return result;
      
   }

   public java.util.HashMap<Integer,Integer> buildHashMap()
   {
      java.util.HashMap<Integer,Integer> theMap = new java.util.HashMap<Integer,Integer>();
      for ( int i = 0; i <= 9; i++ )
      {
	 theMap.put(Integer.valueOf(i),Integer.valueOf(0));
      }
      return theMap;
   }

   public boolean containsZero(int input)
   {
      boolean containsZero = false;
      String val = String.valueOf(input);
      if (val.contains("0"))
      {
	 containsZero = true;
      }
      return containsZero;

   }
}
