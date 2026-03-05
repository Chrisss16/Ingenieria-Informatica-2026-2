
public class Dispenser {
	private int numberOfItems; //variable to store the number of

	//items in the dispenser
	private int cost; //variable to store the cost of an item


	public Dispenser()
	//Default constructor to set the cost and number of
	//items to the default values
	//Postcondition: numberOfItems = 50; cost = 50;
	public Dispenser(int setNoOfItems, int setCost)
	//Constructor with parameters to set the cost and number
	//of items in the dispenser specified by the user
	//Postcondition: numberOfItems = setNoOfItems;
	// cost = setCost;


	public int getCount()
	//Method to show the number of items in the dispenser
	//Postcondition: The value of the instance variable
	// numberOfItems is returned
	public int getProductCost()
	//Method to show the cost of the item
	//Postcondition: The value of the instance
	// variable cost is returned
	public void makeSale()
	//Method to reduce the number of items by 1
	//Postcondition: numberOfItems = numberOfItems - 1;
}
