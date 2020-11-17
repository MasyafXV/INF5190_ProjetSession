package dateManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateConversion {

	public DateConversion() {
		
	}
	
	public int getAgeFromBdate(String bdate) {
		
	    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate parsedDate = LocalDate.parse(bdate, formatter1);
	    
	    Calendar dob = Calendar.getInstance();
	    Calendar today = Calendar.getInstance();

	    dob.set(parsedDate.getYear(), parsedDate.getMonth().getValue(), parsedDate.getDayOfMonth()); 

	    int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

	    if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
	        age--; 
	    }

	    return age;  
	}
}
