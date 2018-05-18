public class ArrayList<T> {

	/*****************************************************/
	/*					class variables					 */
	/* arrList will store the list of objects			 */
	/* nextElement is the input 'object' that will be	 */
	/* added to the list								 */
	/* arrListSize is determined by the number of args	 */
	/* passed to the constructor						 */
	/*****************************************************/
	private Object[] arrList = new Object[5];
	private int nextElement = 0;
	private int arrListSize;


	public ArrayList(int arrListSize){
		this.arrListSize = arrListSize;
		this.arrList = new Object[arrListSize];
	}
	
	public ArrayList(){
		arrList = new Object[10];
		nextElement = 0;
	}

	/*****************************************************/
	/* takes in an object and the specified index ## in	 */
	/* the array and adds the object at that position	 */
	/* does not check for valid input					 */
	/*****************************************************/
	public void insert(Object anElement, int index){
			arrList[index] = anElement;
	}

	/*****************************************************/
	/* checks first if the array is populated, then 	 */
	/* prints a message about the next step which is the */
	/* removal of the current position by setting the arr*/
	/* to the decremented value of the nextElement		 */
	/*****************************************************/
	public Object remove(){
		if(nextElement >= 0){
			System.out.println("the element: " + arrList[nextElement] + 
					" has been removed successfully");
			return arrList[nextElement--];
		} else {

			System.out.println("no items, array is empty");

			return "-1";
		}
	}

	/*****************************************************/
	/* show the items in the array */
	/*****************************************************/
	public void show(){
		for(Object i : arrList){
			System.out.println(i + " ");
		}
	}

	/*****************************************************/
	/* checks for equality between the current object and*/
	/* a passed object									 */
	/*****************************************************/
	public boolean equal(Object that){
		if(this == that){
			return true;
		}else{
			return false;
		}
	}
	
	public int getNextElement(){
		for(int i=0;i<){
			
		}
	}
	
	/*****************************************************/
	/* This toString method will override the default    */
	/* toString method. The StringBuilder will build an  */
	/* string object with a space appended between the	 */
	/* elements in the object array						 */
	/*****************************************************/
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		while(arrList[nextElement] != null){
			sb.append(" ").append(arrList[nextElement]);
		}
		return sb.toString();
	}
}
