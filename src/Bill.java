import java.io.Serializable;

public class Bill implements Comparable, Cloneable, Serializable{

	/****************************************************/
	/* These are objects from the Money and Date class  */
	/* the ctor for this class will be working with the */
	/* assignment of the object's values by the args    */
	/* values passed in through it.						*/
	/****************************************************/
	private Money amount;
	private Date dueDate;
	private Date paidDate;
	private String originator;

	/*****************************************************/
	/* The 'amount' and 'dueDate' values are assigned	 */
	/* to the private objects Money and Date respectively*/
	/* a new Date object is created for the paidDate and */
	/* set to a null value.								 */
	/*****************************************************/
	public Bill(Money amount, Date dueDate, String originator){
		this.amount = amount;
		this.dueDate = dueDate;
		this.paidDate = null;
		this.originator = originator;
	}

	/*****************************************************/
	/* This is the copy ctor for the Bill class. It will */
	/* basically this just sets the current value of the */
	/* objects to a copy of the object, value by value	 */
	/*****************************************************/
	public Bill(Bill toCopy){
		this.amount = toCopy.amount;
		this.dueDate = toCopy.dueDate;
		this.paidDate = toCopy.paidDate;
		this.originator = toCopy.originator;
	}
	
	/*
	 * This method overrides the protected clone()
	 * method from the Cloneable interface. A new Bill object
	 * is instantiated using the current values of Bill. Then,
	 * the super class ctor of Cloneable is invoked to create a copy
	 * of the fields specified within the try{} block.
	 * */
	@Override
	public Bill clone(){
		try {
			Bill newBill = (Bill) super.clone();
			newBill.amount = this.amount.clone();
			newBill.dueDate = this.dueDate.clone();
			if(isPaid()){
				newBill.paidDate = this.paidDate.clone();
			}
			return newBill;
		} catch (CloneNotSupportedException e) {
			System.out.println(e);
			return null;
		}
		
	}

	/****************************************************/
	/* This method will check if the paidDate Date		*/
	/* object is set or not, if not then the bill hasn't*/
	/* been paid and the method should return false.	*/
	/* Of course, if it's not null, then the bill has	*/
	/* been paid.										*/
	/****************************************************/
	public boolean isPaid(){
		if(paidDate != null){
			return true;
		}else{
			return false;
		}
	}

	/*
	 * <p>
	 * Custom equals() method. This method has one parameter that is an Object
	 * data type and holds the current values of the Bill object. 
	 * The new values are compared against the previous instantiated values.
	 * </p>
	 * 
	 * @param toCompare is an Object that holds the current values of the
	 * Bill class fields such as the amount and dueDate
	 * */
	@Override
	public boolean equals(Object toCompare){
		Bill tempBillObj = (Bill) toCompare;
		if(this.amount.equals(tempBillObj.getAmount())){
			return true;
		}else{
			return false;
		}
	}
	
	
	/*
	 * This compareTo() method overrides the default
	 * compareTo() method and acts in a similar fashion.
	 * The return value is an integer of 1 for the objects
	 * being equal, or else if they are not then return -1. 
	 * 
	 * @param other is an Object data type used to
	 * pass the values of a Bill through into the method.
	 * 
	 * */
	@Override
	public int compareTo(Object other){
		
		Bill tempBillObj = (Bill) other;
		
		if(this.equals(tempBillObj)){
			return 1;
		}else{
			return -1;
		}
	}
	
	/****************************************************/
	/* Begin getters*/
	/****************************************************/
	public Money getAmount(){
		return amount;
	}

	public Date getDueDate(){
		return dueDate;
	}

	public String getOriginator(){
		return originator;
	}
	/****************************************************/
	/* End getters, begin setters */
	/****************************************************/
	
	/*
	 * This setter method will use the isAfter method
	 * from the Date class to compare 
	 * the dueDate object value to the 
	 * datePaid object's value. If the dueDate object
	 * returns false from isAfter, then return false for setPaid
	 * else update the paidDate with the value of datePaid 
	 * and return true.
	 */
	public boolean setPaid(Date datePaid){
		if(datePaid.isAfter(dueDate)){
			this.paidDate = datePaid;
			System.out.println("Bill was outstanding and not paid on time");
			return false;
		}else{
			System.out.println("Bill has been paid on: " + datePaid);
			this.paidDate = datePaid;
			return true;
		}
	}

	/*
	 * This boolean method will check for the next
	 * provided date value. if the method isPaid is true,
	 * then the dueDate is irrelevant and the method returns false
	 * or else if the bill is not paid, then update the dueDate
	 * to the provided value of nextDate.
	 * */
	public boolean setDueDate(Date nextDate){
		if(isPaid()){
			return false;
		}else{
			this.dueDate = nextDate;
			return true;
		}
	}

	/*
	 * This method will take in a new Money object
	 * that has a value. Then a condition is checked
	 * that if that new value is 0, the bill is paid,
	 * else the amount is set to the latest value.
	 * 
	 * @param amount is a Money object.
	 * @see class variable delcarations
	 */
	
	public boolean setAmount(Money amount){
		if(isPaid()){
			assert(amount != null);
			this.amount.setMoney(0, 0);
			return false;
		}else{
			this.amount = amount;
			return true;
		}
	}

	/****************************************************/
	/* End setters */
	/****************************************************/
	
	/*
	 * custom toString method will get the amount of money,(non-Javadoc).
	 * the dueDate, the paidDate, and the name of the company
	 * doing the billing and tell the person the status of the 
	 * transactions. The return String is different depending on the 
	 * condition of isPaid. When true, it will print the first String,
	 * else it will print the other.
	 * 
	 * @see java.lang.Object#toString()
	 */
	
	public String toString(){
		if(isPaid()){
			assert(paidDate != null);
			return "Amount Due: " + this.amount + "\nCurrent Due Date: "
					+ this.dueDate.toString() + "\nOrigin of Bill: " + this.originator
					+ "\nDate Paid: " + this.paidDate;
		}else{
			return "Amount Due: " + this.amount + "\nCurrent Due Date: "
					+ this.dueDate.toString() + "\nOrigin of Bill: " + this.originator
					+ "\nBill is unpaid or outstanding";
		}
	}
}