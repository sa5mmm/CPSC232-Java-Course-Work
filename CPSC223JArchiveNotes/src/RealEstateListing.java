/* Goes with notes 20180927
 * */
public class RealEstateListing
{
	private int listingNumber;
	private double price;
	private HouseData housedata; //-> nested class object!
	public RealEstateListing(int listingNumber, double price, 
			String address, int sqft)
	{
		this.listingNumber = listingNumber;
		this.price = price;
		housedata = new HouseData(address, sqft);
	}
	
	public void display()
	{
		System.out.print("Listing number: " + 
	this.listingNumber + "\nPrice: " + this.price + "\nAddress: "
	+ housedata.streetAddress + "\nSquare Feet: " 
	+ housedata.squareFeet);
	}

	
	private class HouseData //Nested Class
	{
		private String streetAddress;
		private int squareFeet;
		public HouseData(String streetAddress, int squareFeet)
		{
			this.streetAddress = streetAddress;
			this.squareFeet = squareFeet;
		}
	}
}
