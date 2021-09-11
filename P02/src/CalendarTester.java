
public class CalendarTester {

	/**
	 * 
	 * @return
	 */
	public static boolean testFullCenturiesContained () {
		 if(CalendarPrinter.fullCenturiesContained(new Year(2)) != 0) return false;
		 if(CalendarPrinter.fullCenturiesContained(new Year(2020)) != 20) return false;
		 if(CalendarPrinter.fullCenturiesContained(new Year(44444)) != 444) return false;
		 return true;
		}
	
	
	public static void main(String[] args) {
		System.out.println(testFullCenturiesContained());
		System.out.println(CalendarPrinter.yearOffsetWithinCentury(new Year(9999934)));
		System.out.println(CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear "February", Year 1999));
	}

}
