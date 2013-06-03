import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class testClass {

	public void testMethod(){
		
		final int NUMBER_OF_DAYS_AGO = -14;
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        format.setLenient(true);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        cal.add(Calendar.DATE, NUMBER_OF_DAYS_AGO);
        String stopDate = DateFormat.getDateInstance().format(cal.getTime());
        System.out.println(stopDate);
        
		Calendar currentDate = Calendar.getInstance();
		
		
	}
}
