import java.io.Serializable;

public class Money implements Comparable, Cloneable, Serializable{

	//class variables
	private int dollars;
	private double cents;

	//when only being passed int's that
	//represent whole dollars
	public Money(int dollars){
		this.dollars = dollars;
		this.cents = 0;
	}

	//when passed two args, one for whole dollars
	//and the other for cents represented as whole numbers
	public Money(int dollars, int cents){
		this.dollars = dollars;
		this.cents = cents;
	}

	//copy ctor
	public Money(Money other){
		this.dollars = other.dollars;
		this.cents = other.cents;
	}
	
	/* *
	* This clone() method 
	*
	*
	* @param
	* @param
	* @param
	* @param
	* @see
	* @see
	* */
	@Override
	public Money clone(){
		try{
			Money newMoney = (Money) super.clone();
			return newMoney;
		}catch(CloneNotSupportedException e){
			return null;
		}
	}

	//if the current object's return value
	//is equal to the one compared against, 
	//print a message and return true,
	//else print a different message and return false.
	//the equals method here compares them as doubles.
	@Override
	public boolean equals(Object otherAmount){
		Money tempMoneyObj = (Money) otherAmount;
		
		if(this.getMoney() == tempMoneyObj.getMoney()){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	 * 
	 * */
	@Override
	public int compareTo(Object otherMoney){
		
		Money tempMoneyObj = (Money) otherMoney;
		
		if(this.equals(tempMoneyObj)){
			return 1;
		}else{return -1;}
	}
	
	/* Will take in dollar amount and add to current count.*/
	public void add(int dollars){
		this.dollars += dollars;
	}

	//takes in dollars and cents to add their sums
	//individually to the current count.
	public void add(int dollars, int cents){
		this.dollars += dollars;
		this.cents = cents;
	}
	
	//will add the handed Money object's value
	//to the count of the current object's value
	//individually for dollars and cents.
	public void add(Money other){
		this.dollars += other.dollars;
		this.cents += other.cents;
	}
	
	/****************************************************/
	/* Being getters */
	/****************************************************/
	public double getMoney(){
		return dollars + ((double)cents/100);
	}
	
	public int getDollars(){
		return dollars;
	}
	
	public int getCents(){
		return (int)cents;
	}
	
	/****************************************************/
	/* End getters, begin setters */
	/****************************************************/
	public void setMoney(int dollars, int cents){
		this.dollars = dollars;
		this.cents = cents;
	}

	/*String.format(format, arg) is there to set the returned amount
	* to display as a number with two decimal places
	*/
	@Override
	public String toString(){
		return "$" + String.format("%.2f", getMoney());
	}
}