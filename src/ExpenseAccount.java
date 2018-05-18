
public class ExpenseAccount extends ArrayList<Bill> {

	ArrayList<Bill> listOfBills = new ArrayList<Bill>();
	
	/* Bill object is given to this class */
	public ExpenseAccount(Bill aBill) {
		listOfBills.insert(aBill, getNextElement());
	}
}
