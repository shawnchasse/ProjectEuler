package Powers_p30;

public class DigitPowers
{
   public static void main(String args[])
   {
      int nthPower = Integer.parseInt(args[0]);
      
      long min = ((Double)java.lang.Math.pow(10,nthPower-1)).longValue();
      long max = ((Double)java.lang.Math.pow(10,nthPower)).longValue();

      System.out.println("Using digits between " + min + " and " + max);

      long nthPowersSum = 0;
      for ( long i = 2; i <= 10000000; i++ )
      {
	 String value = String.valueOf(i);
	 char[] splitStr = value.toCharArray();

	 long sum = 0;
	 for ( int j = 0; j < splitStr.length; j++ )
	 {
	    sum += ((Double)java.lang.Math.pow(Double.parseDouble(String.valueOf(splitStr[j])),nthPower)).longValue();
	 }
	 if ( sum == i )
	 {
	    System.out.println("The number " + i + " is a " + nthPower + "th power sum of its digits");
	    nthPowersSum += i;
	 }
      }
      System.out.println("The sum of all numberrs that are " + nthPower + "th power sum of their digits is " + nthPowersSum);
   }
}
