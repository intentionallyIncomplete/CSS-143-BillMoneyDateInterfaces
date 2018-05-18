/**
 * @author Ian Bryan
 * 
 * Note: Uncomment for testing. Each added method has its own area
 * in the main method for testing from each class.
 * 
 * All comments previously not in Javadoc format have been converted
 * with exclusion to the lines that are to be uncommented one at a time
 * for testing. 
 */
public class BillMoneyDateDriver
{
	/**
     main driver function
     pre:  none
     post: exercises the methods in Bill, Money, and Date (not done)
	 */
	public static void main(String[] args)
	{
		//Construct some money
//		Money money = new Money(10);
//		Money money1 = new Money(10,1);
		//Money money1 = new Money(10,99);
		//Money money1 = new Money(10,101);
		//Money money2 = new Money(12);

		//useful for when needed but using two objects to play with seemed to work out alright.
		//Money money3 = new Money(11);

		//money1.setMoney(30,50);

		//print out the two test objects
		//System.out.println("-------------Money objects output:------------");
		//System.out.println(money1);
		//System.out.println(money2);

		/****************************************************/
		/* Checking the equals() method by setting money1	*/
		/* to an amount, and then money2 to another or the 	*/
		/* same. should print a statement and return		*/
		/* true or false.									*/
		/****************************************************/
		//        System.out.println(money1.equals(money2));
		//        money1.add(5,500);
		//        System.out.println("new money1: " + money1);
		//        money1.add(5,50);
		//        System.out.println("new money1: " + money1);
		//          money1.add(money2);
		//          System.out.println(money1);

		/****************************************************/
		/*				Testing the Date class				*/
		/****************************************************/
//		Date date1 = new Date(1,1,2016);
//		Date date2 = new Date(1,1,2016);
//
//		assert(date1 != null);
//		assert(date2 != null);
//
//		System.out.println(date1);
//		System.out.println(date2);

		//checking the isAfter functionality
		//comments on method functionality in Date class
		//System.out.println(date2.isAfter(date1));

		//System.out.println(date2.equals(date1));

		//testing the set methods for invariants
		//date1.setDay(32);
		//date1.setMonth(13);
		//date1.setYear(1995);

		/*****************************************************/
		/*				Testing the Bill class				 */
		/*****************************************************/
		//Construct some bills fields to go through to
		//the constructor for Bill
		Money amount = new Money(50);
		//Money amount1 = new Money(50);
		Date dueDate = new Date(4, 30, 2017);
		Date datePaid = new Date(5, 15, 2017);

		//instantiating a new object bill1 with values
		//from the Money object 'amount' and the Date object
		//'dueDate'. Then copy it using the copy ctor in
		//the Bill class.
		Bill bill1 = new Bill(amount, dueDate, "The phone company");
		//Bill bill2 = new Bill(amount1, dueDate, "Another Company");

		//System.out.println("----------Constructing Bill 1------------");
		//System.out.println(bill1);
		//System.out.println("----------Constructing Bill 2------------");
		//System.out.println(bill2);
		
		/************************************************************/
		/*			Testing compareTo() method for each class		*/
		/************************************************************/
		
//		System.out.println(amount.compareTo(amount1));
//		System.out.println(bill1.compareTo(bill2));
		
//		Date testDueDate1 = new Date(5,04,2016);
//		Date testDueDate2 = new Date(5,05,2017);
//		System.out.println(testDueDate1.compareTo(testDueDate2));
		
//		Money moneyTest1 = new Money(20);
//		Money moneyTest2 = new Money(25);
//		System.out.println(moneyTest1.compareTo(moneyTest2));
		
		/********************************************************/
		/*				End Testing compareTo() method			*/
		/********************************************************/
		
		ExpenseAccount testExpAcc = new ExpenseAccount();
		testExpAcc.addABill(bill1);
		testExpAcc.show();
		
		//checking the equals method
		//will be reused a few times to 
		//keep track of the bills.
//		System.out.println("---------------------------");
//		System.out.println("Bill has been not updated?: " + bill1.equals(bill2));

		//using the setDueDate method that resets the
		//dueDate value on the conditions of the isPaid
		//method in the Bill class.
//		bill1.setDueDate(new Date(5, 30, 2017));
//		System.out.println("----------Bill 1------------");
//		System.out.println(bill1);
//		System.out.println("---------------------------");
//		System.out.println("Bill has been not updated?: " + bill1.equals(bill2));
		
		//checking the setPaid method
		//and setting the amount to 0 to show this.
//		Money newAmount = new Money(0);
//		bill1.setAmount(newAmount);
//		bill1.setPaid(datePaid);
//		System.out.println("----------Bill 1------------");
//		System.out.println(bill1);
				
	}
}
