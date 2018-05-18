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
	/* This method will check if the amount of money 	*/
	/* returned from Money is 0. If that's true, then	*/
	/* return true, else the value is GT than 0 and must*/
	/* return false.									*/
	/****************************************************/
	public boolean isPaid(){
		if(this.amount.getMoney() == 0){
			return true;
		}else{
			return false;
		}
	}

	//checking the current bill with an "updated"
	//one that may have different values.
	public boolean equals(Object toCompare){
		if(this.toString().equals(toCompare.toString())){
			return true;
		}else{
			return false;
		}
	}
	
	
	/*
	 * 
	 * 
	 * */
	public int compareTo(Object other){
		
		Bill tempBillObj = (Bill) other;
		
		if(!getAmount().equals(tempBillObj.getAmount())){
			System.out.println("Amounts are different");
			return -1;
		}else if(!getDueDate().equals(tempBillObj.getDueDate())){
			System.out.println("Due dates are not the same");
			return -1;
		}else if(!getOriginator().equals(tempBillObj.getOriginator())){
			System.out.println("The origin of the bill is no longer the same");
			return -1;
		}else{return 1;}
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
	//will use the isAfter method from the Date class
	//to compare the dueDate object value to the 
	//datePaid object's value. If the dueDate object
	//returns false from isAfter, then return false for setPaid
	//else update the paidDate with the value of datePaid 
	//and return true.
	public boolean setPaid(Date datePaid){
		if(datePaid.isAfter(dueDate)){
			return false;
		}else{
			this.paidDate = datePaid;
			return true;
		}
	}

	//this boolean method will check for the next
	//provided date value. if the method isPaid is true,
	//then the dueDate is irrelevant and the method returns false
	//or else if the bill is not paid, then update the dueDate
	//to the provided value of nextDate.
	public boolean setDueDate(Date nextDate){
		if(isPaid()){
			return false;
		}else{
			this.dueDate = nextDate;
			return true;
		}
	}

	//this method will take in a new Money object
	//that has a value. Then a condition is checked
	//that if that new value is 0, the bill is paid,
	//else the amount is set to the latest value.
	public boolean setAmount(Money amount){
		if(isPaid()){
			assert(amount != null);
			return false;
		}else{
			this.amount = amount;
			return true;
		}
	}

	public void setOriginator(String originator){
		this.originator = originator;
	}

	/****************************************************/
	/* End setters */
	/****************************************************/
	//custom toString method will get the amount of money,
	//the dueDate, the paidDate, and the name of the company
	//doing the billing and tell the person the status of the 
	//transactions. The return String is different depending on the 
	//condition of isPaid. When true, it will print the first String,
	//else it will print the other.
	public String toString(){
		if(isPaid()){
			assert(paidDate != null);
			return "Amount Due: " + this.amount + "\nCurrent Due Date: "
					+ this.dueDate.toString() + "\nOrigin of Bill: " + this.originator
					+ "\nDate Paid: " + this.paidDate;
		}else{
			return "Amount Due: " + this.amount + "\nCurrent Due Date: "
					+ this.dueDate.toString() + "\nOrigin of Bill: " + this.originator;
		}
	}
}