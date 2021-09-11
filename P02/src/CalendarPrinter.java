
public class CalendarPrinter {

	
	
	
	/**
	* Calculates the number of centuries (rounded down) between year 0 and the
	* specified year. For example, the year 2034 has the century index of 20 (as do
	* the other years 2000-2099).
	* @param year to compute the century offset for
	* @return number of centuries between year 0 and the specified year
	*/
	public static int fullCenturiesContained(Year year) {
		return year.intValue()/100;
	}
	
	/**
	* Calculates the number of years between the specified year and the first year of
	* its century. For example, the year 2034 has the offset within its century of 34
	* (as do 1234 and 9999934).
	* @param year to compute the offset within century for
	* @return number of years between the specified year and the first year of century
	*/
	public static int yearOffsetWithinCentury(Year year) {
		String startYear = "";
		startYear = year.toString();
		String centuryString = startYear.substring(startYear.length()-2);
		int century = Integer.valueOf(centuryString);
		return century;
	}
	/**
	* This method computes whether the specified year is a leap year or not.
	* @param year is the year is being checked for leap-year-ness
	* @return true when the specified year is a leap year, and false otherwise
	*/
	public static boolean isLeapYear(Year year) {
		if (year.intValue() % 4 != 0) {
			return false;
		}
		else if (year.intValue() % 100 != 0) {
			return true;
		}
		else if (year.intValue() % 400 != 0) {
			return false;
		}
		else {
			return true;
		}
		
	}
	/**
	* Calculates the number of days in the specified month, while taking into
	* consideration whether or not the specified month is in a leap year.
	* Note: that this is calculated based on the month's monthOfYear and year, and
	* is NOT retrieved from the month's getDayCount() method. This is because this
	* method is used to generate the day objects that are stored within each month.
	* @param month to determine the number of days within (within its year)
	* @return the number of days in the specified month (between 28-31)
	*/ 
	public static int numberOfDaysInMonth(Month month) {
		String monthString = month.toString();
		if (monthString.equals("September") || monthString.equals("April") || 
				monthString.equals("June") || monthString.equals("November")) {
			return 30;
		}
		else if (monthString.equals("February")) {
			if (isLeapYear(month.getYear())) {
				return 29;
			}
			return 28;
		}
		else {
			return 31;
		}
	}
	/**
	* Calculates which day of the week the first day of the specified month falls on.
	* Note: that this is calculated based on the month's monthOfYear and year, and
	* is NOT retrieved from the month's getDayByDate(1) day. This is because this
	* method is used to generate the day objects that are stored within each month.
	* @param month within which we are calculate the day of week for the first day
	* @return DayOfWeek corresponding to the first day within the specified month
	*/
	public static DayOfWeek calcFirstDayOfWeekInMonth(Month month) {
		
	}
	/**
	* Calculates the day of the week that follows the specified day of week.
	* For example, Thursday comes after Wednesday, and Monday comes after Sunday.
	* @param dayBefore is the day of week that comes before the day of week returned
	* @return day of week that comes after dayBefore
	*/
	public static DayOfWeek dayOfWeekAfter(DayOfWeek dayBefore) {
		
	}
	/**
	* Calculates the month of the year that follows the specified month. For example,
	* July comes after June, and January comes after December.
	* @param monthBefore is the month that comes before the month that is returned
	* @return month of year that comes after monthBefore
	*/
	public static MonthOfYear monthOfYearAfter(MonthOfYear monthBefore) {
		
	}
	/**
	* Creates a new month object and fully initializes with its corresponding days.
	* @param monthOfYear which month of the year this new month represents
	* @param year in which this month is a part
	* @return reference to the newly created month object
	*/
	public static Month createNewMonth(MonthOfYear monthOfYear, Year year) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
