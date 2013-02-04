package canceling_p33;

public class DigitCancel
{
   public static void main( String args[] )
   {
      for ( int i = 11; i < 100; i++ )
      {
	 boolean printed = false;
	 for ( int j = i + 1; j < 100; j++ )
	 {
	    if ( canCancel(i,j) )
	    { 
	       System.out.print(i + "/" + j + " ");
	       printed = true;
	    }
	 }
	 if ( printed )
	 {
	    System.out.print("\n");
	 }
      }
   }

   public static boolean canCancel(int i, int j)
   {
      String iStr = String.valueOf(i);
      String jStr = String.valueOf(j);

      int numerator = Integer.parseInt(iStr.substring(0,1));
      int iToss = Integer.parseInt(iStr.substring(1));
      int denominator = Integer.parseInt(jStr.substring(1));
      int jToss = Integer.parseInt(jStr.substring(0,1));

      boolean cancelable = false;
      if ( j != 0 && denominator != 0 && (jToss == iToss) )
      {
	 double aResult = (((double)i)/((double)j));
	 double bResult = ((double)numerator) / ((double)denominator);
	 if ( aResult == bResult )
	 {
	    System.out.println("Can cancel " + i + "/" + j + " : " + numerator + "/" + denominator);
	    cancelable  = true;
	 }
	 
      }
      return cancelable;
   }
}
