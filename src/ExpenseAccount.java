
public class ExpenseAccount extends ArrayList<Bill> {

	/*
	 * This is the declaration of a list of Objects
	 * that are Bill types. This list is to keep track
	 * of all the current unpaid (outstanding) Bills.
	 * */
	ArrayList<Bill> listOfBills = new ArrayList<Bill>();
	
	/* No arg constructor. This class does not maintain the list directly
	 * and will only be used to add or remove bills to the list.*/
	public ExpenseAccount() {}

	/*
	 * This method is responsible for adding a new Bill
	 * to the list of bills that currently exists. 
	 * The Bill object is first checked for values 
	 * and if it has valid fields, add it to the list.
	 * If the values are invalid, tell the user but don't
	 * do anything to the list.
	 * 
	 * @param aBill is a Bill object that
	 * has values passed in through the driver class
	 * */
	public void addABill(Bill aBill){
		if(aBill != null){
			listOfBills.insert(aBill, getIndex());
		}else{
			System.out.println("Bill is not valid or null");
		}
	}
	
	
	/*
	 * This method is responsible for removing Bills
	 * from the list as long as they are paid and 
	 * have valid field values. If the Bill is not
	 * paid or if the values aren't valid, then
	 * tell the user.  
	 * 
	 * */
	public void removeABill(Bill aBill){
		if(aBill == null || aBill.isPaid() == false){
			System.out.println("Cannot remove bill for it is unpaid or not a valid bill");
		}else{
			listOfBills.remove();
		}
	}

	/*
	 * This method will iterate over the items in the list as
	 * long as that item isn't a null value and display
	 * it to the console. Once the end of the list has been reached
	 * the program exits.
	 * 
	 * */
	@Override
	public void show(){
		listOfBills.show();
	}
}
