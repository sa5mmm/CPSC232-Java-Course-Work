/*
 * Notes October 9th, 2018
 * Arrays!
 * */
public class Notes20181009 {
	public static void main(String[] args)
	{
		int size = 3;
		int[] myIntArray1 = new int[size];//an Array of size 3! -> allocated memory
		int[] myIntArray2 = {1,2,3};//an array of size 3! -> allocated memory and instantiated!
		int[] myIntArray3= new int[] {1,2,3};//an array of size 3! -> allocated memory and instantiated!
		int[] myIntArray;
		myIntArray = new int[size];//can be on two separate lines!
		
		//2D arrays
		int[][] myInt2DArray;
		int rows = 2;
		int cols = 3;
		myInt2DArray = new int[rows][cols]; //a 2d array. 
		for(int row = 0;row<rows;row++)
		{
			for(int col=0;col<cols;col++)
			{
				myInt2DArray[row][col]=row+col+1;
			}
		}
		
		for(int oneD[] : myInt2DArray)
		{
			for(int element : oneD)
			{
				System.out.print(element + " ");
			}
			System.out.print("\n");
		}
		
		
		
	}

}
