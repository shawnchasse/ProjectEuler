package Sunday_p19;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class CountingSundays
{

   public CountingSundays()
   {

   }

   public static void main(String args[])
   {
      Calendar cal = java.util.Calendar.getInstance();
      cal.set(1901,0,1);
      Calendar end = java.util.Calendar.getInstance();
      end.set(2000,11,31);
      int countOfSundays = 0;
      SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMM dd yyyy HH:mm:ss Z");
      while ( cal.before(end) )
      {
	 System.out.print("\n" + formatter.format(cal.getTime()));
	 if ( cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY )
	 {
	    System.out.print(" +");
	    countOfSundays++;
	 }
	 cal.add(Calendar.MONTH,1);
      }
      System.out.println("\nThe number of sundays between January 1, 1901 and December 31, 2000 is " + countOfSundays);
   }
}
