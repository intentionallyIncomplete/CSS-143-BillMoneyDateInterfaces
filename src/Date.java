import java.io.Serializable;

public class Date implements Comparable, Cloneable, Serializable{

	//class variables
	private int day;
	private int month;
	private int year;

	/*****************************************************/
	/* This ctor will check for a few invariants		 */
	/* The days have to be 1 < days < 31 while the months*/
	/* must be 1 < months < 12 and the year between 	 */
	/* 2014 and 2024. The class variables will only be 	 */
	/* set if all these conditions are met true.		 */
	/*****************************************************/
	public Date(int month, int day, int year){

		if(day < 1 || day > 31){
			System.out.println("invalid day: " + day);
			assert(day > 0);
			System.exit(0);
		}else if(month < 1 || month > 12){
			System.out.println("invalid month: "+ month);
			System.exit(0);
		}else if(year < 2014 || year > 2024){
			System.out.println("invalid year: " + year);
			System.exit(0);
		}else{
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}

	//copy ctor
	public Date(Date other){
		this.day = other.day;
		this.month = other.month;
		this.year = other.year;
	}
	
	public Date clone(){
		try{
			Date newDate = (Date) super.clone();
			return newDate;
		}catch(CloneNotSupportedException e){
			return null;
		}
	}

	/*****************************************************/
	/* the isAfter method will return false under any	 */
	/* condition unless the day of the handed date is GT */
	/* the current one by as little as 1 day			 */
	/*****************************************************/
	public boolean isAfter(Date compareToDate){
		if(compareToDate.day < day && compareToDate.month <= month
				&& compareToDate.year <= year){
			return false;
		}else{
			return true;
		}
	}

	//checking for equivalence
	@Override
	public boolean equals(Object date){
		//using the custom toString method on both
		//objects is necessary to be able to compare them
		//in the same format
		if(this.toString().equals(date.toString())){
			System.out.println("the two dates are the same");
			return true;
		}else{
			System.out.println("the two dates are not the same");
			return false;
		}
	}

	@Override
	public int compareTo(Object otherDate){
		Date tempDateObj = (Date) otherDate;

		if(getDay() < tempDateObj.getDay()){
			System.out.println("Current day comes after the previous day input");
			return -1;
		}else if(getDay() > tempDateObj.getDay()){
			System.out.println("Current day comes before the previous day input");
			return -1;
		}else if(getMonth() < tempDateObj.getDay()){
			System.out.println("Current month comes after the previous month");
			return -1;
		}else if(getMonth() > tempDateObj.getMonth()){
			System.out.println("Current month comes before the previous month");
			return -1;
		}else if(getYear() < tempDateObj.getYear()){
			System.out.println("Current year comes after the previous year");
			return -1;
		}else if(getYear() > tempDateObj.getYear()){
			System.out.println("Current year comes before the previous year");
			return -1;
		}else{
			System.out.println("Dates are the same");
			return 1;
		}
	}

	/*****************/
	/* Begin getters */
	/*****************/

	public int getDay(){
		return day;
	}

	public int getMonth(){
		return month;
	}

	public int getYear(){
		return year;
	}

	/*****************************************************/
	/* End getters, begin setters. These setters include */
	/* the validation of the date when called from the	 */
	/* BillMoneyDateDriver class and prevent illegal	 */
	/* dates or the changing of dates to curb due dates	 */
	/*****************************************************/
	public void setDay(int day){
		if(day < 1 || day > 31){
			System.out.println("invalid day " + day + "\nProgram Exiting...");
			assert(day > 0);
			System.exit(0);
		}else{
			this.day = day;	
		}
	}

	public void setMonth(int month){
		if(month < 1 || month > 12){
			System.out.println("invalid month " + month + "\nProgram Exiting...");
			assert(month < 0);
			assert(month != 12);
			System.exit(0);
		}else{
			this.month = month;
		}
	}

	public void setYear(int year){
		if(year < 2014 || year > 2024){
			System.out.println("invalid year " + year);
			assert(year < 2024);
			assert(year > 0);
		}else{
			this.year = year;
		}
	}

	/**************/
	/* end setters*/
	/**************/
	@Override
	public String toString(){
		return month + "/" + day + "/" + year;
	}
}