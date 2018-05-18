
public class ExpenseAccount extends ArrayList<Bill> {

	ArrayList<Bill> listOfBills = new ArrayList<Bill>();

	/* Bill object is given to this class */
	public ExpenseAccount() {}

	/*
	 * 
	 * */
	public void addABill(Bill aBill){
		if(aBill != null){
			listOfBills.insert(aBill, getNextElement());
		}else{
			System.out.println("Bill is not valid or null");
		}
	}
	
	public void removeABill(Bill aBill){
		if(aBill == null || aBill.isPaid() == false){
			System.out.println("Cannot remove bill for it is unpaid or not a valid bill");
		}else{
			listOfBills.remove();
		}
	}

	public void show(){
		try{
			listOfBills.show();
		}catch(NullPointerException npe){
			System.out.println("------------------\n"
					+ "End of the list of Bills");
			System.exit(0);
		}
	}
}
