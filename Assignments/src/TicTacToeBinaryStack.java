/*
public class TicTacToeBinaryStack {
	int[] combinations;
	//int[] value;
	public TicTacToeBinaryStack()
	{
		value = new int[9];
	}
	public String print(int decimal)
	{
		String values = "";
		convertToBase3(decimal);
		for(int i = 0; i<9;i++)
		{
			values = values + value[i]+" ";
			//System.out.print(value[i]+" ");
		}
		values = values+"\n";
		//System.out.print("\n");
		return values;
		
	}
	private int convertToBase3()
	{
		int value =0;
		int decimal = BoardTools;
		int quotient = (int)(decimal/3);
		int remainder = decimal%3;
		int index = 8;
		while(quotient !=0)
		{
			value = remainder;
			quotient = quotient/3;
			remainder = quotient%3;
			index--;
		}
		return value;
	}

}
*/